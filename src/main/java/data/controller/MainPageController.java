package data.controller;

import data.dto.CategoryDto;
import data.dto.ReviewDto;
import data.dto.RoomDto;
import data.dto.TagDto;
import data.mapper.CategoryMapper;
import data.mapper.ReviewMapper;
import data.mapper.RoomMapper;
import data.mapper.TagMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class MainPageController {

    @Autowired
    CategoryMapper categoryMapper;
    @Autowired
    RoomMapper roomMapper;
    @Autowired
    ReviewMapper reviewMapper;

    @Autowired
    TagMapper tagMapper;


    //메인페이지에 category 가져오기
    @GetMapping("/categoryList")
    public List<CategoryDto> categoryList()
    {

        return categoryMapper.getAllCategory();
    }
    
    //메인페이지에 추천공간(room) 가져오기
    @GetMapping("/roomList")
    public List<RoomDto> roomList()
    {

        return roomMapper.getRoomList();
    }
    
    //메인페이지에 리뷰(review) 가져오기
    @GetMapping("/reviewList")
    public List<ReviewDto> reviewList()
    {

        return reviewMapper.getReviewList();
    }

    //메인페이지 리뷰에 태그Tag 가져오기
    @GetMapping("/tagList")
    public List<TagDto> tagList(int num)
    {

        return tagMapper.selectTagList(num);
    }
}
