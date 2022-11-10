package data.mapper;

import data.dto.BookingDetailDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BookingDetailMapper {
    public void insertBookingDetail(BookingDetailDto dto);
}
