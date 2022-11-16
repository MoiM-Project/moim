package data.mapper;

import data.dto.BookingDetailRoptionDto;
import data.dto.RoomDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface BookingDetailRoptionMapper {
    public void insertBDRoption(HashMap<String, Object> map);
    public List<BookingDetailRoptionDto> getROptionData(int num);
}
