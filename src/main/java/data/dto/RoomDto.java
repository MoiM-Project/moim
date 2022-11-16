package data.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.apache.ibatis.type.Alias;

import java.sql.Timestamp;

@Data
@Alias("RoomDto")
public class RoomDto {
    private int num;
    private String name;
    private String oneIntroduction;
    private String fullIntroduction;
    private String thumbnailImage;
    private String address;
    private String address2;
    private int headcount;
    private int stime;
    private int etime;
    private int holiday;
    private int floor;
    private int parking;
    private int elevator;
    private String payment;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "Asia/Seoul")
    private Timestamp writeday;
    private boolean hideStatus;
    private boolean approvalStatus;
    private int weekAmPrice;
    private int weekPmPrice;
    private int holiAmPrice;
    private int holiPmPrice;
    private String lat;
    private String lng;
    private int hostNum;
    private int readCount;

    // categoryDto
    private String cname;

    // facilityDto
    private String fname;
    private String imageUrl;

    //roptionDto
    private String oname;
    private int price;
    private String oimageUrl;

    //hostDto
    private String companyName;
}
