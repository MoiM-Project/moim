package data.dto;

import lombok.Data;
import org.apache.ibatis.type.Alias;

@Data
@Alias("BookingDetailRoption")
public class BookingDetailRoption {
    private int num;
    private int count;
    private int userNum;
    private int roomNum;
    private int roptionNum;
    private int bookingDetailNum;
}
