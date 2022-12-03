package data.dto;

import lombok.Data;
import org.apache.ibatis.type.Alias;

@Data
@Alias("CategoryDto")
public class CategoryDto {
    private int num;
    private String cname;
    private int mainCategoryNum;
    
    private String categoryImg;
    // 메인에 출력될 카테고리 이미지 컬럼 추가
    private String categorybanner;
}
