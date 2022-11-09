package data.controller;

import data.dto.RoomDto;
import data.mapper.RoomMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/room")
public class RoomController {
    @Autowired
    RoomMapper roomMapper;

    @GetMapping("/detail")
    public RoomDto getSelect(int num)
    {
        RoomDto dto=roomMapper.getRoomData(num);

        return dto;
    }

    @GetMapping("/category")
    public List<RoomDto> getCategory(int num)
    {
        return roomMapper.getCategoryData(num);
    }

    @GetMapping("/facility")
    public List<RoomDto> getFacility(int num)
    {
        return roomMapper.getFacilityList(num);
    }

    @GetMapping("/option")
    public List<RoomDto> getOption(int num)
    {
        return roomMapper.getOptionList(num);
    }

}
