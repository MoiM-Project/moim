package data.controller;

import data.dto.HostDto;
import data.dto.MemberDto;
import data.dto.NoticeDto;
import data.dto.RoomDto;
import data.mapper.HostMapper;
import data.mapper.MemberMapper;
import data.mapper.NoticeMapper;
import data.mapper.RoomMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
@CrossOrigin
public class AdminController {

    @Autowired
    MemberMapper memberMapper;

    @Autowired
    HostMapper hostMapper;

    @Autowired
    RoomMapper roomMapper;

    @Autowired
    NoticeMapper noticeMapper;
    
    //관리자 페이지에서 멤버정보 가져오기
    @GetMapping("/admin/memberList")
    public List<MemberDto> getMemberSearchList(
            @RequestParam String searchWord,
            @RequestParam String sort)
    {
        //saerchWord 넘어오는지 테스트
        System.out.println("Member searchWord = "+searchWord);
        System.out.println("Member sort = "+sort);

        HashMap<String, Object> map = new HashMap<>();
        map.put("searchWord",searchWord);
        map.put("sort",sort);

        //map 출력 테스트
        System.out.println("MemberList map = "+ map);

        return memberMapper.getMemberSearchList(map);
    }

    //관리자 페이지에서 멤버 활성상태 업데이트
    @GetMapping("/admin/memberActive")
    public void updateMemberAcitve(@RequestParam int userNum)
    {
        //num 값 확인
        System.out.println("num = "+userNum);

        memberMapper.updateMemberActive(userNum);
    }

    @GetMapping("/admin/memberPassReset")
    public void updateMemberPassword(@RequestParam int userNum)
    {
        //num 값 확인
        System.out.println("num = "+userNum);


        memberMapper.updateMemberPassword(userNum);
    }



    //관리자 페이지에서 호스트정보 가져오기
    @GetMapping("/admin/hostList")
    public List<HostDto> getHostSearchList(
            @RequestParam String searchWord,
            @RequestParam String sort)
    {
        //saerchWord 넘어오는지 테스트
        System.out.println("Host searchWord = "+searchWord);
        System.out.println("Host sort = "+sort);
        
        HashMap<String, Object> map = new HashMap<>();
        map.put("searchWord",searchWord);
        map.put("sort",sort);

        //map 출력 테스트
        System.out.println("HostList map = "+ map);
        
        return hostMapper.getHostSearchList(map);
    }

    //admin > host warningCount reset
    @GetMapping("/admin/hostWCount")
    public void updateHostWarning(@RequestParam int hostNum)
    {
        //num 값 확인
        System.out.println("경고초기화 hostNum = "+hostNum);

        hostMapper.updateHostWarning(hostNum);
    }

    //admin > host warningCount reset
    @GetMapping("/admin/hostPass")
    public void updateHostPassword(@RequestParam int hostNum)
    {
        //num 값 확인
        System.out.println("비번초기화 hostNum = "+hostNum);

        hostMapper.updateHostPassword(hostNum);
    }


    @GetMapping("/admin/spaceList")
    public List<RoomDto> getSpaceList(
            @RequestParam String searchWord,
            @RequestParam String sort)
    {
        System.out.println("Space sort = "+sort);
        System.out.println("Space searchWord = "+ searchWord);

        HashMap<String, Object> map = new HashMap<>();
        map.put("searchWord",searchWord);
        map.put("sort",sort);

        System.out.println("SpaceList map = "+ map);

        return roomMapper.getSpaceSearchList(map);
    }

    //관리자 페이지에서 멤버정보 가져오기
    @GetMapping("/admin/noticeList")
    public List<NoticeDto> getNoticeSearchList(
            @RequestParam String searchWord)
    {
        //saerchWord 넘어오는지 테스트
        System.out.println("Notice searchWord = "+searchWord);

        HashMap<String, Object> map = new HashMap<>();
        map.put("searchWord",searchWord);

        //map 출력 테스트
        System.out.println("NoticeList map = "+ map);

        return noticeMapper.getNoticeSearchList(map);
    }
}


