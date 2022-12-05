package data.controller;

import data.dto.RoomDto;
import data.mapper.SearchMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
public class SearchController {

    @Autowired
    SearchMapper searchMapper;

    @GetMapping("/searchroom")
    public List<RoomDto> searchroomList(
            @RequestParam String searchWord,
            @RequestParam(defaultValue = "readCount desc") String sort){

        System.out.println("Space sort = "+sort);
        System.out.println("Space searchWord = "+ searchWord);

        HashMap<String, Object> map = new HashMap<>();
        map.put("searchWord", searchWord);
        map.put("sort", sort);

//        System.out.println(searchMapper.getSearchRoom(map));
        return searchMapper.getSearchRoom(map);
    }

    @PostMapping("/searchroom")
    public List<RoomDto> searchroomList(
            @RequestBody HashMap<String,Object> data
//            @RequestParam String searchWord,
//            @RequestParam(defaultValue = "readCount desc") String sort
    ){

//        System.out.println("Space sort = "+sort);
//        System.out.println("Space searchWord = "+ searchWord);

        HashMap<String, Object> map = new HashMap<>();
        map.put("searchWord", data.get("searchWord"));
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

//        System.out.println(searchMapper.getSearchRoom(map));
        return searchMapper.getSearchRoom(map);
    }
}
