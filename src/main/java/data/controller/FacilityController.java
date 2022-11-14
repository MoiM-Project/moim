package data.controller;

import data.dto.FacilityDto;
import data.dto.RoomDto;
import data.dto.ThemeDto;
import data.mapper.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
public class FacilityController {

    @Autowired
    FacilityMapper FacilityMapper;

    @GetMapping("/facility/select")
    public List<FacilityDto> selectFacility() {

        return FacilityMapper.selectFacility();
    }

}
