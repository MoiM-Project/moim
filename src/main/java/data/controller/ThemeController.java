package data.controller;

import data.dto.RoomDto;
import data.dto.TagDto;
import data.dto.ThemeDto;
import data.mapper.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    @PostMapping("/theme/list")
    public List<RoomDto> selectThemeRoomList(@RequestBody HashMap<String,Object> data){

        HashMap<String, Object> map = new HashMap<>();

        map.put("themeNum",data.get("themeNum"));
        map.put("sort",data.get("sort"));
        map.put("headCount",data.get("headCount"));
        map.put("name",data.get("roomName"));
        map.put("address",data.get("address"));
        map.put("payment",data.get("payment"));
        map.put("sprice",data.get("sprice"));
        map.put("eprice",data.get("eprice"));
        map.put("facilityList",data.get("facility"));
        map.put("facilityCount",data.get("facilityCount"));
        map.put("holiday",data.get("holiday"));
        map.put("stime",data.get("stime"));
        map.put("etime",data.get("etime"));

        System.out.println(data);
        System.out.println(map);

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
    @DeleteMapping("/theme/delete/room")
    public void deleteThemeRoom(int themeNum, int roomNum){

        HashMap<String,Object> map = new HashMap<>();

        map.put("themeNum",themeNum);
        map.put("roomNum",roomNum);
        System.out.println(map);

        themeMapper.deleteThemeRoom(map);
    }
}
