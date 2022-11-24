package data.mapper;

import data.dto.NoticeDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface NoticeMapper {

    List<NoticeDto> getNoticeSearchList(HashMap<String, Object> map);

    void noticeInsert(HashMap<String, Object> map);

    void deleteNotice(int num);

    void updateNotice(HashMap<String, Object> map);

    NoticeDto getNoticeInfo(int num);
}
