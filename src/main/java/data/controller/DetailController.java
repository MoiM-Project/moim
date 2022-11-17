package data.controller;

import data.dto.RoomDto;
import data.mapper.DetailMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin
public class DetailController {

    @Autowired
    DetailMapper detailMapper;

    @GetMapping("/detailroom")
    public Map<String,Object> detailroom(@RequestParam int num){

        //조회수 증가
        //detailMapper.updateReadCount(num);

        Map<String, Object> map=new HashMap<>();
        map.put("roomData",detailMapper.getRoomData(num));
        map.put("tag",detailMapper.getTagName(num));
        map.put("roomImg",detailMapper.getImg(num));
        return map;
    }

    @GetMapping("/detailInfo")
    public Map<String,Object> detailInfo(@RequestParam int num){
        Map<String, Object> map=new HashMap<>();
        map.put("roomData",detailMapper.getRoomData(num));
        map.put("roomInfo",detailMapper.getInformation(num));
        map.put("pre",detailMapper.getPrecaution(num));
        map.put("category",detailMapper.getCategoryData(num));
        map.put("facility",detailMapper.getFacilityList(num));
        return map;
    }

}
