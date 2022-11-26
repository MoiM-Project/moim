package data.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.apache.ibatis.type.Alias;

import java.sql.Timestamp;

@Data
@Alias("MemberDto")
public class MemberDto {
    private int idx;
    private String email;
    private String nickname;
    private String password;
    private String profile_image;
    private int point;
    private String grade;
    private String phoneNum;
    private String gender;
    private String birthday;
    private String notification;
    private int status;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "Asia/Seoul")
    private Timestamp created_at;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "Asia/Seoul")
    private Timestamp updated_at;

}
