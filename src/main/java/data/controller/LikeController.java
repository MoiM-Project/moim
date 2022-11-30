package data.controller;

import data.dto.QnADto;
import data.dto.RoomDto;
import data.mapper.LikeMapper;
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
public class LikeController {

    @Autowired
    LikeMapper likeMapper;

    @GetMapping("/likeList")
    public List<RoomDto> likeList(@RequestParam int userNum, @RequestParam(defaultValue = "readCount desc") String sort){

        Map<String, Object> map=new HashMap<>();

        map.put("userNum",userNum);
        map.put("sort",sort);

        return likeMapper.selectLikeByUserNum(map);
    }

}
