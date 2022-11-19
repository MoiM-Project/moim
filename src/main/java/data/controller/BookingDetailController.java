package data.controller;

import data.dto.BookingDetailDto;
import data.mapper.BookingDetailMapper;
import data.mapper.RoomMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/bookingDetail")
public class BookingDetailController {
    @Autowired
    BookingDetailMapper bookingDetailMapper;

    @PostMapping("/insert")
    public void insertFood(@RequestBody BookingDetailDto dto)
    {
        bookingDetailMapper.insertBookingDetail(dto);
    }

    @GetMapping("/list")
    public List<BookingDetailDto> getBookingDetail(int userNum){
        List<BookingDetailDto> dto = bookingDetailMapper.getBookingDetailList(userNum);

        return dto;
    }
}
