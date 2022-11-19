package data.mapper;

import data.dto.BookingDetailDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BookingDetailMapper {
    public void insertBookingDetail(BookingDetailDto dto);
    public List<BookingDetailDto> getBookingDetailList(int userNum);
}
