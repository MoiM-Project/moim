package data.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.apache.ibatis.type.Alias;

import java.sql.Timestamp;

@Data
@Alias("HostDto")
public class HostDto {
    private int num;
    private String email;
    private String password;
    private String companyName;
    private String businessNumber;
    private String logoImage;
    private String phone;
    private String address;
    private String bank;
    private String accountNumber;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "Asia/Seoul")
    private Timestamp createdAt;

    private int warningCount;
    private int active;

}
