package data.mapper;

import data.dto.QnADto;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;


@Mapper
public interface QnAMapper {
    List<QnADto> getQnaByUserNum(HashMap<String,Object> map);

}
