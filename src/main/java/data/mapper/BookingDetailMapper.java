package data.mapper;

import data.dto.BookingDetailDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface BookingDetailMapper {
    public void insertBookingDetail(BookingDetailDto dto);
    // 예약내역리스트페이지 (booking list page)
    public List<BookingDetailDto> getBookingDetailList(HashMap<String,Object> map);
    // 상세페이지 (booking detail page)
    public BookingDetailDto getBookingDetailData(int bookingDetailNum);
}
