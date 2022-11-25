package data.seller;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PostSellerReq {
    private String email;
    private String password;
    private String companyName;
    private String businessNumber;
    private String logoImage;
    private String phone;
    private String address;
    private String bank;
    private String accountNumber;
    private String token;

}


