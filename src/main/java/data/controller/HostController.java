package data.controller;

import data.dto.HostDto;
import data.mapper.HostMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class HostController {

    @Autowired
    HostMapper hostMapper;

    @GetMapping("/host")
    public String HostHome() {
        return "/home";
    }

    // booking detail page - host info
    @GetMapping("/host/list")
    public HostDto getHostInfoList(int num)
    {
        HostDto dto = hostMapper.getHostInfoList(num);
//        System.out.println(dto);
        return dto;
    }
}
