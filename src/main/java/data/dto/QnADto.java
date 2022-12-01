package data.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.apache.ibatis.type.Alias;

import java.sql.Timestamp;

@Data
@Alias("QnADto")
public class QnADto {
    private int num;
    private String question;
    private String answer;
    private String status;
    private int roomNum;
    private int userNum;
    private String title;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm",timezone = "Asia/Seoul")
    private Timestamp writeday;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm",timezone = "Asia/Seoul")
    private Timestamp answerday;

    //member
    private String nickname;
    private String profile_image;
    private String name;
}
