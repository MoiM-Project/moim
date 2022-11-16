package data.controller;

import data.dto.CategoryDto;
import data.dto.RoomDto;
import data.mapper.CategoryMapper;
import data.mapper.DetailMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@CrossOrigin
public class CategoryRoomController {

    @Autowired
    CategoryMapper categoryMapper;

    @GetMapping("/category/data")
    public CategoryDto categoryData(int categoryNum){
        return categoryMapper.selectCategory(categoryNum);
    }

    @GetMapping("/categoryroomList")
    public List<RoomDto>  categoryroomList(
            @RequestParam int categoryNum,
            @RequestParam(defaultValue = "readCount desc") String sort,
            @RequestParam(defaultValue = "1") int headCount,
            @RequestParam(defaultValue = "") String name,
            @RequestParam(defaultValue = "")String address){
        HashMap<String, Object> map = new HashMap<>();

        System.out.println("호출");
        map.put("num",categoryNum);
        map.put("sort",sort);
        map.put("headCount",headCount);
        map.put("name",name);
        map.put("address",address);
        System.out.println(map);
        return categoryMapper.getCategoryRoom(map);
    }

}
