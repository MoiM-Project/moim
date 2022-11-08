package data.dto;

import lombok.Data;
import org.apache.ibatis.type.Alias;

@Data
@Alias("RoomThemeDto")
public class RoomThemeDto {
    private int num;
    private int roomNum;
    private int themeNum;
}
