package data.controller;

import data.dto.*;
import data.mapper.*;
import data.util.ChangeName;
import data.util.FileUtil;
import data.util.S3UploadUtil;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.Host;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
@CrossOrigin
@RequiredArgsConstructor
public class AdminController {

    //파일 첨부를 위한 변수 선언
//    String uploadFileName;

    @Autowired
    MemberMapper memberMapper;

    @Autowired
    HostMapper hostMapper;

    @Autowired
    RoomMapper roomMapper;

    @Autowired
    NoticeMapper noticeMapper;

    @Autowired
    WarningMapper warningMapper;

    //AWS S3 유틸 import
    private final S3UploadUtil s3UploadUtil;

    //로그인 한 회원 등급확인 (admin 확인용)
    @GetMapping("/adminCheck")
    public String adminCheck(int userNum)
    {
        //grade는 ADMIN 이랑 USER 두 종류임

        return memberMapper.adminCheck(userNum);
    }

    //관리자 페이지에서 멤버정보 가져오기
    @GetMapping("/admin/memberList")
    public List<MemberDto> getMemberSearchList(
            @RequestParam String searchWord,
            @RequestParam String sort)
    {
        //saerchWord 넘어오는지 테스트
//        System.out.println("Member searchWord = "+searchWord);
//        System.out.println("Member sort = "+sort);

        HashMap<String, Object> map = new HashMap<>();
        map.put("searchWord",searchWord);
        map.put("sort",sort);

        //map 출력 테스트
//        System.out.println("MemberList map = "+ map);

        return memberMapper.getMemberSearchList(map);
    }

    //관리자 페이지에서 멤버 활성상태 업데이트
    @GetMapping("/admin/memberActive")
    public void updateMemberAcitve(@RequestParam int userNum)
    {
        //num 값 확인
//        System.out.println("num = "+userNum);

        memberMapper.updateMemberActive(userNum);
    }

    //관리자 페이지에서 멤버 비밀번호 초기화
    @GetMapping("/admin/memberPassReset")
    public void updateMemberPassword(@RequestParam int userNum)
    {
        //num 값 확인
//        System.out.println("num = "+userNum);


        memberMapper.updateMemberPassword(userNum);
    }



    //관리자 페이지에서 호스트정보 가져오기
    @GetMapping("/admin/hostList")
    public List<HostDto> getHostSearchList(
            @RequestParam String searchWord,
            @RequestParam String sort)
    {
        //saerchWord 넘어오는지 테스트
//        System.out.println("Host searchWord = "+searchWord);
//        System.out.println("Host sort = "+sort);
        
        HashMap<String, Object> map = new HashMap<>();
        map.put("searchWord",searchWord);
        map.put("sort",sort);

        //map 출력 테스트
//        System.out.println("HostList map = "+ map);
        
        return hostMapper.getHostSearchList(map);
    }

    //admin > host warningCount reset
    @GetMapping("/admin/hostWCount")
    public void updateHostWarning(@RequestParam int hostNum)
    {
        //num 값 확인
//        System.out.println("경고초기화 hostNum = "+hostNum);

        hostMapper.updateHostWarning(hostNum);
    }

    //admin > host warningCount reset
    @GetMapping("/admin/hostActive")
    public void updateHostActive(@RequestParam int hostNum)
    {
        //num 값 확인
//        System.out.println("상태 변경 hostNum = "+hostNum);

        hostMapper.updateHostActive(hostNum);
    }

    //admin > host warningCount reset
    @GetMapping("/admin/hostPass")
    public void updateHostPassword(@RequestParam int hostNum)
    {
        //num 값 확인
//        System.out.println("비번초기화 hostNum = "+hostNum);

        hostMapper.updateHostPassword(hostNum);
    }


    //관리자페이지 > 공간관리 : 방 리스트 가져오기
    @GetMapping("/admin/spaceList")
    public List<RoomDto> getSpaceList(
            @RequestParam String searchWord,
            @RequestParam String sort)
    {
//        System.out.println("Space sort = "+sort);
//        System.out.println("Space searchWord = "+ searchWord);

        HashMap<String, Object> map = new HashMap<>();
        map.put("searchWord",searchWord);
        map.put("sort",sort);

//        System.out.println("SpaceList map = "+ map);

        return roomMapper.getSpaceSearchList(map);
    }

    //관리자페이지 > 공간관리 : 공간 승인하기
    @GetMapping("/admin/approveSpace")
    public void approveSpace(@RequestParam int roomNum)
    {
        //넘어온 방 번호 확인
//        System.out.println("대상 방번호 = "+roomNum);
        
        //방 번호 넘기기
        roomMapper.approveSpace(roomNum);
    }

    //관리자페이지 > 공간관리 : 공간 거부하기
    @GetMapping("/admin/rejectSpace")
    public void rejectSpace(@RequestParam int roomNum)
    {
        //넘어온 방 번호 확인
//        System.out.println("대상 방번호 = "+roomNum);

        //방 번호 넘기기
        roomMapper.rejectSpace(roomNum);
    }


    //관리자 페이지에서 공지사항 리스트 가져오기
    @GetMapping("/admin/noticeList")
    public List<NoticeDto> getNoticeSearchList(
            @RequestParam String searchWord, String sort)
    {
        //saerchWord 넘어오는지 테스트
//        System.out.println("Notice searchWord = "+searchWord);
//        System.out.println("Notice sort = "+sort);

        HashMap<String, Object> map = new HashMap<>();
        map.put("searchWord",searchWord);
        map.put("sort",sort);

        //map 출력 테스트
//        System.out.println("NoticeList map = "+ map);

        return noticeMapper.getNoticeSearchList(map);
    }

    //관리자 페이지에서 공지사항 작성하기
    @PostMapping("/admin/noticeInsert")
    public void noticeInsert (
            @RequestParam("uploadFile") MultipartFile multipartFile,
            String noticeType,
            String noticeTitle,
            String noticeContent
    ){

        //DB에 Insert하기위해 map 선언
        HashMap<String, Object> map = new HashMap<>();

        //uploadFile을 제외하고 map에 담기
        map.put("noticeType",noticeType);
        map.put("noticeTitle",noticeTitle);
        map.put("noticeContent",noticeContent);

        //파일을 첨부했는지 안했는지 체크
        try {
            //파일첨부를 했을때
            if(multipartFile != null) {

                //s3에 파일 업로드하고 map에 담기
                map.put("uploadFile",s3UploadUtil.upload(multipartFile,"notice"));

                //성공 확인 sout
                System.out.println("AWS에 업로드 성공!");

            //upload 파일첨부를 안했을때
            }else {

                //map 에 uploadFile null 로 담기
                map.put("uploadFile",null);
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
        noticeMapper.noticeInsert(map);
    }

    //관리자 페이지에서 공지사항 삭제하기
    @DeleteMapping("/admin/deleteNotice")
    public void deleteNotice(@RequestParam int num)
    {
        //넘어온 방 번호 확인
//        System.out.println("delete num값 확인 = "+num);

        //방 번호 넘겨서 정보 가져오기 (첨부 이미지 때문)
        String path = noticeMapper.getNoticeInfo(num).getImageUrl().split("/",4)[3];

        System.out.println("기존의 파일은 AWS 에서 삭제합니다");
        //기존 업로드 파일이 있을 경우 AWS 경로에서 파일 삭제
        s3UploadUtil.delete(path);

        //방 번호 넘겨서 notice DB 삭제하기
        noticeMapper.deleteNotice(num);
        System.out.println("DB에서 데이터 row 삭제 완료");

    }

    //관리자 페이지에서 공지사항 리스트 가져오기 (modal에 띄우기)
    @GetMapping("/admin/getNoticeInfo")
    public NoticeDto getNoticeInfo(
            @RequestParam int num)
    {
        //넘어온 Notice 번호 확인
//        System.out.println("num값 확인 = " + num);

        //num 값 전달
        return noticeMapper.getNoticeInfo(num);
    }


    //관리자 페이지에서 공지사항 수정하기
    @PostMapping("/admin/updateNotice")
    public void updateNotice (@RequestParam(value="updateFile", required = false) MultipartFile multipartFile,
                              String updateType,
                              String updateTitle,
                              String updateContent,
                              String oldPhoto,
                              int num
    ){

        //DB에 update하기위해 map 선언
        HashMap<String, Object> map = new HashMap<>();

        //uploadFile을 제외하고 map에 담기
        map.put("updateType",updateType);
        map.put("updateTitle",updateTitle);
        map.put("updateContent",updateContent);
        map.put("num",num);

        //파일을 첨부했는지 안했는지 체크
        try {
            // 이미지파일 첨부 여부 체크
            if (multipartFile != null) {

                // 이미지파일 첨부시
                if (noticeMapper.getNoticeInfo(num).getImageUrl() != null) {
                    // db에 이미지 url이 있는 경우
                    // 기존 데이터의 이미지url을 가져온 후 s3파일 삭제
                    String path = noticeMapper.getNoticeInfo(num).getImageUrl().split("/", 4)[3];

                    System.out.println("기존의 파일은 AWS 에서 삭제합니다");
                    s3UploadUtil.delete(path);

                    // 새로운 이미지 s3에 업로드 하면서, map에 추가
                    map.put("updateFile", s3UploadUtil.upload(multipartFile, "notice"));
                    System.out.println("새로 첨부한 파일을 DB에 업로드합니다.");

                    // 이미지파일 미첨부시
                } else {

                    // db의 이미지 url 가져와서 map에 추가
                    map.put("updateFile", oldPhoto);
                    System.out.println("기존 파일 유지!");
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        // insert sql 에 map 전달
        noticeMapper.updateNotice(map);
    }



    // report || warning 신고하기 관련
    //관리자 페이지에서 신고 DB 가져오기
    @GetMapping("/admin/reportList")
    public List<WarningDto> getReportList (@RequestParam String sort,
                String searchWord
        ){

        HashMap<String, Object> map = new HashMap<>();
        map.put("sort",sort);
        map.put("searchWord",searchWord);

        //map 출력 테스트
        System.out.println("warningList map = "+ map);

        return warningMapper.getReportList(map);
    }

    //admin > report > 상세보기
    @GetMapping("/admin/reportInfo")
    public WarningDto getReportInfo(@RequestParam int num)
    {
        //sort 넘어오는지 테스트
//        System.out.println("report num = "+num);

        return warningMapper.getReportInfo(num);
    }


    //관리자 페이지에서 공지사항 수정하기
    @PostMapping("/admin/reportUpdate")
    public void reportUpdate (@RequestParam String reportStatus,
                              String reportAnswer,
                              int num
    ){

        //DB에 update하기위해 map 선언
        HashMap<String, Object> map = new HashMap<>();

        //uploadFile을 제외하고 map에 담기
        map.put("reportStatus",reportStatus);
        map.put("reportAnswer",reportAnswer);
        map.put("num",num);
        //finishday 는 수정일자로 진행하고, SQL(xml)에 now()로 설정해둠

        System.out.println(map);

        // insert sql 에 map 전달
        warningMapper.updateReport(map);
    }


    //방 상세정보에서 신고하기 작성
    @PostMapping("/admin/reportInsert")
    public void reportInsert (@RequestParam String reportType,
                              String reportContent,
                              int roomNum,
                              int userNum
    ){
        //값 받아오는지 확인
//        System.out.println(reportType);
//        System.out.println(reportContent);
//        System.out.println(roomNum);
//        System.out.println(userNum);

        //DB에 Insert하기위해 map 선언
        HashMap<String, Object> map = new HashMap<>();

        // map에 담기
        map.put("reportType",reportType);
        map.put("reportContent",reportContent);
        map.put("status","신고 접수");
        map.put("QnANum",null);
        map.put("reviewNum",null);
        map.put("roomNum",roomNum);
        map.put("userNum",userNum);

//        System.out.println(map);

        // insert sql 에 map 전달
        warningMapper.reportInsert(map);

        // hostNum 구하기
        int hostNum = roomMapper.getRoomHostNum(roomNum);
        System.out.println("호스트번호:"+ hostNum);

        // warningCount 증가
        hostMapper.addWarningCount(hostNum);    //void add

        // warningCount 가 5를 넘을 경우 비활성화(inActive) 시키기
        int warningCount = hostMapper.getWarningCount(hostNum);

        if(warningCount < 5)
        {
            System.out.println("누적 경고 수 : "+ warningCount);

        }else {
            System.out.println("누적 경고 수 : "+ warningCount);

            // 5를 넘을 경우 계정 비활성화
            hostMapper.updateHostBlock(hostNum);

            System.out.println("신고가 누적되어 계정이 정지됩니다");
        }
    }


    //마이페이지 > QNA 목록에서 신고하기 작성
    @PostMapping("/admin/reportQnaInsert")
    public void reportQnaInsert (@RequestParam String reportType,
                              String reportContent,
                              int qnaNum,
                              int userNum,
                              int roomNum
    ){

        //확인
//        System.out.println(roomNum);

        //DB에 Insert하기위해 map 선언
        HashMap<String, Object> map = new HashMap<>();

        // map에 담기
        map.put("reportType",reportType);
        map.put("reportContent",reportContent);
        map.put("status","신고 접수");
        map.put("QnANum",qnaNum);
        map.put("reviewNum",null);
        map.put("roomNum",roomNum);
        map.put("userNum",userNum);

//        System.out.println(map);

        // insert sql 에 map 전달
        warningMapper.reportInsert(map);

        // hostNum 구하기
        int hostNum = roomMapper.getRoomHostNum(roomNum);
        System.out.println("호스트번호:"+ hostNum);

        // warningCount 증가
        hostMapper.addWarningCount(hostNum);    //void add

        // warningCount 가 5를 넘을 경우 비활성화(inActive) 시키기
        int warningCount = hostMapper.getWarningCount(hostNum);


        if(warningCount < 5)
        {
            System.out.println("누적 경고 수 : "+ warningCount);

        }else {
            System.out.println("누적 경고 수 : "+ warningCount);

            // 5를 넘을 경우 계정 비활성화
            hostMapper.updateHostBlock(hostNum);

            System.out.println("신고가 누적되어 계정이 정지됩니다");
        }
    }

    //관리자 페이지 메인에 신고누적 호스트 가져오기 -> 보류 (인기있는 공간&호스트 로 변경)
    @GetMapping("/admin/warningHost5")
    public List<HostDto> getWarningHost()
    {

        return hostMapper.getWarningHost();
    }

    //관리자 페이지 메인에 인기있는 공간&호스트 가져오기
    @GetMapping("/admin/popularSpace")
    public List<RoomDto> getPopularSpace()
    {

        return roomMapper.getPopularSpace();
    }

    //관리자 페이지 메인에 등록 대기중인 공간 가져오기
    @GetMapping("/admin/waitSpace")
    public List<RoomDto> getWaitSpaceList()
    {

        return roomMapper.waitSpaceList();
    }

    //관리자 페이지 메인에 등록 대기중인 공간 가져오기
    @GetMapping("/admin/waitReport")
    public List<WarningDto> getWaitReportList()
    {

        return warningMapper.waitReportList();
    }


}


