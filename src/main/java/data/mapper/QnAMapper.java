package data.mapper;

import data.dto.QnADto;
import data.dto.ReviewDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;


@Mapper
public interface QnAMapper {
    List<QnADto> getQnaByUserNum(HashMap<String,Object> map);
    QnADto getQnaByNum(int num);
    void qnaDelete(int num);
    void updateQna(HashMap<String,Object> map);
    List<QnADto> getQnaByHostNum(HashMap<String,Object> map);
    void insertQnaAnswer(HashMap<String,Object> map);

}
