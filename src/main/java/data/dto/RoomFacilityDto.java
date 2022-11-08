package data.dto;

import lombok.Data;
import org.apache.ibatis.type.Alias;

@Data
@Alias("RoomFacilityDto")
public class RoomFacilityDto {
    private int num;
    private int roomNum;
    private int facilityNum;
}
