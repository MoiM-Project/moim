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
    public List<RoomDto> selectThemeRoomList(
            int themeNum,
            @RequestParam(defaultValue = "readCount desc") String sort,
            @RequestParam(defaultValue = "1") int headCount,
            @RequestParam(defaultValue = "") String name,
            @RequestParam(defaultValue = "") String address,
            @RequestParam(defaultValue = "") String payment,
            @RequestParam(defaultValue = "0") int sprice,
            @RequestParam(defaultValue = "1000000") int eprice){

        HashMap<String, Object> map = new HashMap<>();

        map.put("themeNum",themeNum);
        map.put("sort",sort);
        map.put("headCount",headCount);
        map.put("name",name);
        map.put("address",address);
        map.put("payment",payment);
        map.put("sprice",sprice);
        map.put("eprice",eprice);

        return themeMapper.selectThemeRoomList(map);
    }
    @GetMapping("/theme/data")
    public ThemeDto selectTheme(int themeNum){

        return themeMapper.selectTheme(themeNum);
    }
    @GetMapping("/tag/list")
    public Map<String,Object> selectTagList(@RequestParam int num){

        Map<String,Object> map = new HashMap<>();

        map.put("roomImageData",roomMapper.selectRoomImageList(num));
        map.put("tagData",tagMapper.selectTagList(num));
        map.put("reviewCount",reviewMapper.selectReviewCount(num));
        map.put("likeCount",likeMapper.selectLikeCount(num));

        return map;
    }
}
