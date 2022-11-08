package data.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.sql.Timestamp;

public class BookingDetail {
    private int num;
    private String bookingTime;
    private int headCount;
    private String name;
    private String phone;
    private String email;
    private String purpose;
    private String request;
    private int totalPrice;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "Asia/Seoul")
    private Timestamp createdAt;
    private int bookingStatus;
    private String cancelReason;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "Asia/Seoul")
    private Timestamp cancleDate;
    private int roomNum;
    private int userNum;
}
