package data.controller;

import data.dto.BookingDetailDto;
import data.mapper.BookingDetailMapper;
import data.mapper.RoomMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/bookingDetail")
public class BookingDetailController {
    @Autowired
    BookingDetailMapper bookingDetailMapper;

    @PostMapping("/insert")
    public void insertFood(@RequestBody BookingDetailDto dto)
    {
        System.out.println("dddd");
        System.out.println(dto);
        bookingDetailMapper.insertBookingDetail(dto);
    }
}
