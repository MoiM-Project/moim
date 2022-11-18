package data.controller;

import data.dto.HostDto;
import data.dto.MemberDto;
import data.dto.RoomDto;
import data.mapper.HostMapper;
import data.mapper.MemberMapper;
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
}
