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
import org.springframework.web.bind.annotation.RestController;

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
    public List<MemberDto> getMemberList()
    {

        return memberMapper.getMemberList();
    }

    //관리자 페이지에서 호스트정보 가져오기
    @GetMapping("/admin/hostList")
    public List<HostDto> getHostList()
    {

        return hostMapper.getHostList();
    }

    //관리자 페이지에서 공강 정보 가져오기
    @GetMapping("/spaceList")
    public List<RoomDto> roomList()
    {

        return roomMapper.getRoomList();
    }
}
