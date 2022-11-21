package data.controller;

import data.dto.QnADto;
import data.dto.RoomDto;
import data.mapper.DetailMapper;
import data.mapper.ReviewMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
public class DetailController {

    @Autowired
    DetailMapper detailMapper;

    @Autowired
    ReviewMapper reviewMapper;

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

    @GetMapping("detailBookingTime")
    public String getBookingTime(@RequestParam int num,@RequestParam String selectDay){
        Map<String, Object> smap=new HashMap<>();
        smap.put("num",num);
        smap.put("selectDay",selectDay);

        return detailMapper.getBookingTime(smap);
    }

    @GetMapping("/detailQna")
    public List<QnADto> detailQna(@RequestParam int num){
       return detailMapper.getQnaList(num);
    }

    @PostMapping("/detail/insertQna")
    public void insertQna(@RequestBody QnADto dto){
        dto.setStatus("답변대기중");
        detailMapper.insertQna(dto);
    }

    @GetMapping("/detailReview")
    public Map<String,Object> detailReview(@RequestParam int num){
        Map<String, Object> map=new HashMap<>();
        map.put("count",reviewMapper.selectReviewCount(num));
        map.put("avg",reviewMapper.getReviewAvg(num));
        map.put("review",detailMapper.getReviewList(num));
        map.put("reviewPhoto",detailMapper.getReviewPhoto(num));
        map.put("host",detailMapper.getHostByNum(num));
        map.put("roomData",detailMapper.getRoomData(num));

        return map;
    }

    @GetMapping("/detailHost")
    public Map<String,Object> detailHost(@RequestParam int hostNum){
        Map<String, Object> map=new HashMap<>();
        map.put("list",detailMapper.getRoomByHostNum(hostNum));

        return map;
    }
}
