package data.dto;

import lombok.Data;
import org.apache.ibatis.type.Alias;

@Data
@Alias("TagDto")
public class TagDto {
    private int num;
    private String name;
    private int roomNum;
}
