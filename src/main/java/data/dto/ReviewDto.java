package data.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.apache.ibatis.type.Alias;

import java.sql.Timestamp;

@Data
@Alias("ReviewDto")
public class ReviewDto {
    private int num;
    private String content;
    private String answerContent;
    private int rating;
    private String reviewImageUrl;
    private int userNum;
    private int roomNum;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm",timezone = "Asia/Seoul")
    private Timestamp writeday;

    //member
    private String nickname;
}
