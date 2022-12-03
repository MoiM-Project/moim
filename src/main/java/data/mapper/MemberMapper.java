package data.mapper;

import data.dto.MemberDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface MemberMapper {

    //멤버 리스트 출력
    List<MemberDto> getMemberSearchList(HashMap<String,Object> map);
    
    //멤버 활성화 상태 변경
    void updateMemberActive(int userNum);

    //멤버 비밀번호 초기화
    void updateMemberPassword(int userNum);

    void updatePassword(HashMap<String,Object>map);

    void updateNickname(HashMap<String,Object>map);

    String LoginTypeCheck(int userNum);

    void profileUpdate(HashMap<String, Object> map);

    MemberDto getMemberInfo(int idx);

    void deleteMember(int idx);

    Integer findUserByUserId(String email);

    // 소셜 여부 확인
    String searchSocial(String email);

}
