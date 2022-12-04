package data.mapper;

import data.seller.PostSellerReq;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface SellerMapper {

    // 이메일로 찾기
    public int getSearchId(String email);

    // 이메일이 맞는지 안맞는지 Map(이메일,비밀번호) => 0 or 1
    public int getLogin(Map<String, String> map);

    public List<PostSellerReq> getAllMembers();

    // 이메일에 해당하는 이름
    public String getName(String email);

    public String getNum(String email);
}
