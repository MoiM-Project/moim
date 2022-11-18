package data.mapper;

import data.dto.QnADto;
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
    public List<TagDto> getInformation(int num);
    public List<TagDto> getPrecaution(int num);
    public List<RoomDto> getCategoryData(int num);
    public List<RoomDto> getFacilityList(int num);
    public List<QnADto> getQnaList(int num);
}
