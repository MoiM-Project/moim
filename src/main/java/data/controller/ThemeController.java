package data.controller;

import data.dto.RoomDto;
import data.dto.TagDto;
import data.dto.ThemeDto;
import data.mapper.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
public class ThemeController {

    @Autowired
    ThemeMapper themeMapper;
    @Autowired
    TagMapper tagMapper;
    @Autowired
    ReviewMapper reviewMapper;
    @Autowired
    LikeMapper likeMapper;
    @Autowired
    RoomMapper roomMapper;

    @GetMapping("/main/theme")
    public List<ThemeDto> selectThemeList() {

        return themeMapper.selectThemeList();
    }
    @GetMapping("/theme/list")
    public List<RoomDto> selectThemeRoomList(@RequestParam int num, String sort){

        System.out.println(num+" / "+sort);

        HashMap<String, Object> map = new HashMap<>();

        map.put("num",num);
        map.put("sort",sort);

        return themeMapper.selectThemeRoomList(map);
    }
    @GetMapping("/theme/data")
    public ThemeDto selectTheme(@RequestParam int num){

        return themeMapper.selectTheme(num);
    }
    @GetMapping("/tag/list")
    public Map<String,Object> selectTagList(@RequestParam int num){

        Map<String,Object> map = new HashMap<>();

        System.out.println(roomMapper.selectRoomImageList(num).size());
        map.put("roomImageData",roomMapper.selectRoomImageList(num));
        map.put("tagData",tagMapper.selectTagList(num));
        map.put("reviewCount",reviewMapper.selectReviewCount(num));
        map.put("likeCount",likeMapper.selectLikeCount(num));

        return map;
    }
}
