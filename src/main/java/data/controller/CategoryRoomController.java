package data.controller;

import data.dto.CategoryDto;
import data.dto.RoomDto;
import data.mapper.CategoryMapper;
import data.mapper.DetailMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
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
            @RequestParam(defaultValue = "")String address,
            @RequestParam(defaultValue = "")String payment,
            @RequestParam(defaultValue = "0")int sprice,
            @RequestParam(defaultValue = "500000")int eprice,
            @RequestParam(defaultValue = "1")int facilityLength,
            @RequestParam(defaultValue = "1") String facility){
        HashMap<String, Object> map = new HashMap<>();

        List<String> facilityList = Arrays.asList(facility);
        System.out.println(facilityList);
        map.put("num",categoryNum);
        map.put("sort",sort);
        map.put("headCount",headCount);
        map.put("name",name);
        map.put("address",address);
        map.put("payment",payment);
        map.put("sprice",sprice);
        map.put("eprice",eprice);
        map.put("facilityLength",facilityLength);
        System.out.println(map);
        return categoryMapper.getCategoryRoom(map);
    }

}
