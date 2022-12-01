package data.mapper;

import data.dto.BookingDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;

@Mapper
public interface BookingMapper {
    // 바로결제
    public void insertBooking(BookingDto dto);
    public void deleteBooking(HashMap<String,Object> map);
}
