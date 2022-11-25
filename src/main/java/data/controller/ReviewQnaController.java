package data.controller;

import data.dto.ReviewDto;
import data.mapper.ReviewMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;


@RestController
@CrossOrigin
public class ReviewQnaController {

    @Autowired
    ReviewMapper reviewMapper;

    @GetMapping("/reviewQna/reviewList")
    public List<ReviewDto> getReviewByUserNum(@RequestParam int userNum,@RequestParam String sort){
        HashMap<String, Object> map = new HashMap<>();
        map.put("userNum",userNum);
        map.put("sort",sort);

        System.out.println(map);

        return reviewMapper.getReviewByUserNum(map);
    }
}
