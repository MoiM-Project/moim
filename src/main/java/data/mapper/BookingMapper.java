package data.mapper;

import data.dto.BookingDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BookingMapper {
    // 바로결제
    public void insertBooking(BookingDto dto);
}
