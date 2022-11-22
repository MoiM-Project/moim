package data.mapper;

import data.dto.NoticeDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface NoticeMapper {

    List<NoticeDto> getNoticeSearchList(HashMap<String, Object> map);
}
