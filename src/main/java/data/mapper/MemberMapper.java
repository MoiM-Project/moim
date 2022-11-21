package data.mapper;

import data.dto.MemberDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface MemberMapper {

//    List<MemberDto> getMemberList();
    List<MemberDto> getMemberSearchList(HashMap<String,Object> map);
}
