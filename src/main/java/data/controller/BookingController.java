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
}
