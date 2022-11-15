package data.mapper;

import data.dto.TagDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface TagMapper {
    List<TagDto> selectTagList(int num);

    public void insertTag(TagDto dto);

}
