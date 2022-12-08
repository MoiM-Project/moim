package data.controller;

import data.dto.BookingDetailDto;
import data.dto.RoomDto;
import data.mapper.BookingDetailMapper;
import data.mapper.RoomMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
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
    public List<BookingDetailDto> getBookingDetail(int userNum,
                                                   @RequestParam(defaultValue = "1") String bookingStatus,
                                                   @RequestParam(defaultValue = "num desc") String sort){

        HashMap<String, Object> map = new HashMap<>();
        map.put("userNum",userNum);
        map.put("bookingStatus",bookingStatus);
        map.put("sort",sort);
        if (bookingStatus.equals("-1"))
            return bookingDetailMapper.getBookingDetailList2(userNum);

        return bookingDetailMapper.getBookingDetailList(map);
    }

    @GetMapping("/detail")
    public BookingDetailDto getBookingDetail(int bookingDetailNum){
        BookingDetailDto dto = bookingDetailMapper.getBookingDetailData(bookingDetailNum);

        return dto;
    }

    @PatchMapping("/update")
    public void updateCancel(@RequestBody HashMap<String,Object> data){
        HashMap<String, Object> map = new HashMap<>();

        map.put("num",data.get("num"));
        map.put("cancelReason", data.get("cancelReason"));

        bookingDetailMapper.updateCancel(map);
    }

    @GetMapping("/getMaxNum")
    public BookingDetailDto LastData()
    {
        return bookingDetailMapper.getMaxNum();
    }

    @PatchMapping("/updateStatus")
    public void updateStatus(@RequestBody HashMap<String,Object> data){
        HashMap<String, Object> map = new HashMap<>();
        map.put("num",data.get("num"));

        bookingDetailMapper.updateBLStatus(map);
    }
}
