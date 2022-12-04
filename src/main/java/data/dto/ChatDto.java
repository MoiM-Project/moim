package data.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.sql.Timestamp;

@Data
public class ChatDto {
    private int memberNum;
    private int hostNum;
    private int roomNum;
    private String message;
    private boolean isRead;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm",timezone = "Asia/Seoul")
    private Timestamp chatDate;
}
