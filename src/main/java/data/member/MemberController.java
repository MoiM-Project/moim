package data.member;

import data.config.BaseException;
import data.config.BaseResponse;
import data.config.BaseResponseStatus;
import data.config.JwtTokenUtil;
import data.dto.BookingDetailDto;
import data.dto.MemberDto;
import data.mapper.MemberMapper;
import data.mapper.SellerMapper;
import data.member.model.*;
import data.seller.PostSellerReq;
import data.util.ChangeName;
import data.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.authentication.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.util.*;

import static data.config.BaseResponseStatus.*;
import static data.util.Validation.isValidatedIdx;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/member")
public class MemberController {
    private final MemberDao memberDao;

    String uploadFileName;
    ArrayList<String> uploadFileNames = new ArrayList<>();

    @Autowired
    MemberService memberService;

    @Autowired
    SellerMapper sellerMapper;

    @Autowired
    MemberMapper memberMapper;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private EmailCertService emailCertService;

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    public MemberController(MemberDao memberDao) {
        this.memberDao = memberDao;
    }


    @ResponseBody
    @PostMapping("/signup")
    public BaseResponse<PostMemberRes> createMember(@RequestBody PostMemberReq postMemberReq) {

        try {
            if (postMemberReq.getNickname() == null) {
                return new BaseResponse<>(POST_USER_NICKNAME_NULL);
            }

            String token = UUID.randomUUID().toString();
            System.out.println("====== Controller : createMember : Req ====== " + postMemberReq);

            PostMemberRes postMemberRes = memberService.createMember(postMemberReq, token);
            UserDetails userDetails = memberService.findByEmailStatusZero(postMemberReq.getEmail());

            final String jwt = jwtTokenUtil.generateToken(userDetails);

            emailCertService.createEmailConfirmationToken(token, postMemberReq.getEmail(), jwt);

            return new BaseResponse<>(postMemberRes);

        } catch (Exception exception) {
            System.out.println(exception);
            return new BaseResponse<>(BaseResponseStatus.FAIL);
        }
    }

    @ResponseBody
    @GetMapping("/confirm")
    public RedirectView signupConfirm(GetEmailConfirmReq getEmailConfirmReq) throws Exception {
        GetEmailCertRes getEmailCertRes = emailCertService.signupConfirm(getEmailConfirmReq);
        return new RedirectView("http://localhost:3000/emailconfirm/" + getEmailConfirmReq.getJwt());
    }

    @ResponseBody
    @GetMapping("/modify")
    public BaseResponse<GetMemberRes> getModifyMemberInfo(@AuthenticationPrincipal UserLoginRes userLoginRes) {

        if (userLoginRes == null) {
            return new BaseResponse<>(NOT_LOGIN);
        }
        try {
            BigInteger userIdx = userLoginRes.getIdx();
            GetMemberRes getMemberRes = memberService.getModifyMemberInfo(userIdx);
            return new BaseResponse<>(getMemberRes);

        } catch (Exception exception) {
            return new BaseResponse<>(EMPTY_IDX);
        }
    }


    @ResponseBody
    @PatchMapping("/modify/{idx}")
    public BaseResponse<String> modifyMemberInfo(@AuthenticationPrincipal UserLoginRes userLoginRes, @PathVariable("idx") BigInteger idx, @RequestBody PatchMemberModityReq patchMemberModityReq) {

        if (idx == null) {
            return new BaseResponse<>(EMPTY_IDX);
        }
        if (!isValidatedIdx(idx)) {
            return new BaseResponse<>(INVALID_IDX);
        }
        if (userLoginRes == null) {
            return new BaseResponse<>(NOT_LOGIN);
        }

        try {
            BigInteger userIdx = userLoginRes.getIdx();
            System.out.println("== userLoginRes.getIdx: " + userLoginRes.getIdx() + ", Idx: " + idx);

            if (!userIdx.equals(idx)) {
                return new BaseResponse<>(INVALID_USER_JWT);
            }

            memberService.modifyMemberInfo(patchMemberModityReq, idx);
            String result = patchMemberModityReq.getNickname() + "로 변경 완료.";
            return new BaseResponse<>(result);
        } catch (BaseException exception) {
            return new BaseResponse<>(exception.getStatus());
        }
    }

    @ResponseBody
    @PostMapping("/sellersignup")
    public BaseResponse<PostMemberRes> createSeller(@RequestBody PostSellerReq postSellerReq) {

        try {
            System.out.println("========================== Req: " + postSellerReq);

            String token = UUID.randomUUID().toString();
            PostMemberRes postMemberRes = memberService.createSeller(postSellerReq,token);
            return new BaseResponse<>(postMemberRes);

        } catch (Exception exception) {
            System.out.println(exception);
            return new BaseResponse<>(BaseResponseStatus.FAIL);
        }
    }

    @PostMapping("/Sellercheck")
    public Map<String,Object> getLogin(@RequestBody Map<String,String> map) {
        System.out.println("check id:"+map.get("email"));
        int check = sellerMapper.getLogin(map);  // 아이디와 비번이 맞으면 1 반환, 틀리면 0 반환
        // 성공시 회원이름도 보내보다
        String name="";
        if(check==1){  // 성공하면
            name = sellerMapper.getName(map.get("email"));
        }
        Map<String, Object> sendmap = new HashMap<>();
        sendmap.put("check", check);
        sendmap.put("name", name);
        return sendmap;
    }

    @GetMapping("/getMemberInfo")
    public MemberDto getMemberInfo(
            @RequestParam int idx)
    {
        //넘어온 Notice 번호 확인
        System.out.println("num값 확인 = " + idx);

        //num 값 전달
        return memberMapper.getMemberInfo(idx);
    }


    // 프로필 사진 변경
    @PostMapping("/modify/profileImage")
    public void noticeInsert (@RequestBody MultipartFile updateFile,
                              HttpServletRequest request,
                              @RequestParam String oldPhoto,
                              int idx
    ){

        //DB에 update하기위해 map 선언
        HashMap<String, Object> map = new HashMap<>();

        //uploadFile을 제외하고 map에 담기
        map.put("idx",idx);

        //파일을 첨부했는지 안했는지 체크
        try {

            //upload 파일첨부를 했을때
            if(updateFile != null) {

                // 업로드할 폴더의 경로(path) 구하기
                String path = request.getSession().getServletContext().getRealPath("/image");

                //기존 업로드 파일이 있을 경우 path 경로에서 파일 삭제 후 다시 업로드
                if (oldPhoto != null) {
                    FileUtil.deletePhoto(path, oldPhoto);   //있을 경우 path 경로의 oldPhoto 를 지운다
                    System.out.println("기존 사진 oldPhoto 삭제 완료");
                }

                //업로드 파일을 변수에 담기
                uploadFileName = updateFile.getOriginalFilename();

                //파일명을 날짜타입으로 변경(util 활용)
                uploadFileName = ChangeName.getChangeFileName(updateFile.getOriginalFilename());

                //path 경로에 uploadFileName 의 파일명으로 업로드 진행
                updateFile.transferTo(new File(path + "/" + uploadFileName));

                //성공 시 콘솔에 찍기
                System.out.println("신규 이미지 업로드 성공 -> 경로 // 파일명 " + path + "//" +uploadFileName );

                //map 으로 updateFile에 파일명 담기
                map.put("updateFile",uploadFileName);

                System.out.println(map);
                System.out.println("프사 변경");
                //upload 파일첨부를 안했을때
            }else {

                //map 으로 updateFile에 기존 사진(oldPhoto) 으로 담기
                map.put("updateFile",oldPhoto);
                System.out.println("기존 파일 유지!");
            }

        } catch (IllegalStateException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            throw new RuntimeException(e);
        }

        // insert sql 에 map 전달
        memberMapper.profileUpdate(map);
    }

    //  비밀번호 수정 API
    @PostMapping("/updatePassword")
    public void updatePassword(@RequestParam String password,@RequestParam String email) {
//        System.out.println("update email 확인 = "+email);
        System.out.println("회원 수정");
        memberService.updatePassword(password, email);
    }

    @PostMapping("/updateNickname")
    public void updateNickname(@RequestParam int idx,@RequestParam String nickname){

        HashMap<String, Object> map = new HashMap<>();
        map.put("idx",idx);
        map.put("nickname",nickname);
        memberMapper.updateNickname(map);
    }

    // 소셜 타입 구분
    @GetMapping("/checksocial")
    public String checkSocial(@RequestParam String email){
        System.out.println("확인할 이메일="+email);

        String check = "normal";
        if(memberMapper.searchSocial(email).equals("kakao")){
            check = "social";
        }
        return check;
    }

    //  계정 탈퇴 API
    @DeleteMapping("/delete")
    public void deleteUser(@RequestParam int idx) {
        System.out.println("delete num값 확인 = "+idx);
        System.out.println("회원 삭제");
        memberMapper.deleteMember(idx);
    }

    @ResponseBody
    @GetMapping("{email}")
    public Boolean getUserEmail(@PathVariable("email") String email) {
        Boolean result = memberService.getUserEmail(email);
        return result;
    }

    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {

        if (authenticationRequest.getUsername().length() == 0) {
            System.out.println("username is NULL");
        }

        if (authenticationRequest.getPassword().length() == 0) {
            System.out.println("Password is NULL");
        }

// 탈퇴한 회원인지 확인.
//        if (!memberDao.isValidStatus(authenticationRequest)) {
//            System.out.println("탈퇴한 회원");
//        }

        System.out.println(authenticationRequest.getUsername() + ", " + authenticationRequest.getPassword());

        Authentication authentication = authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());
        UserLoginRes userLoginRes = (UserLoginRes) authentication.getPrincipal();

        final String token = jwtTokenUtil.generateToken(userLoginRes);

        return ResponseEntity.ok(new JwtResponse(token));
    }

    private Authentication authenticate(String username, String password) throws Exception {

        try {
            return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new DisabledException("USER_DISABLED", e);
        } catch (AccountExpiredException e) {
            throw new AccountExpiredException("AccountExpiredException", e);
        } catch (BadCredentialsException e) {
            throw new BadCredentialsException("비밀번호 오류 입니다. INVALID_CREDENTIALS", e);
        } catch (InternalAuthenticationServiceException e) {
            throw new InternalAuthenticationServiceException("존재하지 않는 아이디 입니다. InternalAuthenticationServiceException", e);
        }
        catch (AuthenticationCredentialsNotFoundException e) {
            throw new AuthenticationCredentialsNotFoundException("인증 요구 거부.", e);
        }
    }


}
