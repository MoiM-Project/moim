package data.controller;

import data.dto.RoomDto;
import data.mapper.SearchMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
}
