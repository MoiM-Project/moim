package data.controller;

import data.dto.BookingDto;
import data.mapper.BookingDetailMapper;
import data.mapper.BookingMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/booking")
public class BookingController {
    @Autowired
    BookingMapper bookingMapper;
    BookingDetailMapper bookingDetailMapper;

    // 바로결제
    @PostMapping("/insert")
    public void insertBooking(@RequestBody BookingDto dto){
        bookingMapper.insertBooking(dto);
    }

//    @PostMapping("/delete")
//    public void deleteBooking(int num){
//        bookingMapper.deleteBooking(num);
//    }

    @PostMapping("/delete")
    public void deleteBooking(@RequestBody HashMap<String,Object> data){
        HashMap<String, Object> map = new HashMap<>();

        map.put("bookingDetailNum",data.get("bookingDetailNum"));

        bookingMapper.deleteBooking(map);
    }
}
