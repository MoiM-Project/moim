package data.controller;

import data.dto.BookingDetailRoptionDto;
import data.mapper.BookingDetailRoptionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/bookingDetailOption")
public class BookingDetailRoptionController {
    @Autowired
    BookingDetailRoptionMapper optionMapper;

    @PostMapping("/insert")
    @ResponseBody
    public void insertOption(
            @RequestBody HashMap<String,Object> params) {
        HashMap<String,Object> map = new HashMap<String,Object>();

        List<Map<String,Object>> optionList = (List<Map<String,Object>>) params.get("optionInsertList");

        map.put("optionList" , optionList);

        optionMapper.insertBDRoption(map);
    }

    @GetMapping("/list")
    public List<BookingDetailRoptionDto> getROption(int num)
    {
        return optionMapper.getROptionData(num);
    }
}
