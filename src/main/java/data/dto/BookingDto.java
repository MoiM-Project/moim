package data.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.apache.ibatis.type.Alias;

import java.sql.Timestamp;

@Data
@Alias("BookingDto")
public class BookingDto {
    private int num;
    private int totalPrice;
    private String pg;
    private String merchantUid;
    private String payMethod;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "Asia/Seoul")
    private Timestamp createdAt;
    private int userNum;
    private int roomNum;
    private int bookingDetailNum;

    //조인되서 가져오는것 부킹
    private String name;
    private String roomName;
    private String bookingName;
    private int hostNum;
    private int payStatus;
    private int bookingStatus;
}
