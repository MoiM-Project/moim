package data.mapper;

import data.dto.RoomDto;
import data.dto.TagDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DetailMapper {
    public RoomDto getRoomData(int num);
    public void updateReadCount(int num);
    public List<TagDto> getTagName(int num);
    public List<TagDto> getImg(int num);

}
