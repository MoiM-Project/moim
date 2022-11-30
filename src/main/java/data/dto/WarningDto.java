package data.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.apache.ibatis.type.Alias;

import java.sql.Timestamp;

@Data
@Alias("WarningDto")
public class WarningDto {
    private String content;
    private String type;
    private String status;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm",timezone = "Asia/Seoul")
    private Timestamp writeday;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm",timezone = "Asia/Seoul")
    private Timestamp finishday;

    private int userNum;
    private int roomNum;
    private int QnANum;
    private int reviewNum;
    
    // join을 위한 dto 추가
    private String nickname;
    private String companyName;
}
