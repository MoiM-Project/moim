package data.dto;

import lombok.Data;
import org.apache.ibatis.type.Alias;

@Data
@Alias("BookingDetailRoptionDto")
public class BookingDetailRoptionDto {
    private int num;
    private int count;
    private int userNum;
    private int roomNum;
    private int roptionNum;
    private int bookingDetailNum;
}
