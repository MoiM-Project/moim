package data.controller;

import data.dto.RoomDto;
import data.dto.ThemeDto;
import data.mapper.*;
import data.util.S3UploadUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequiredArgsConstructor
public class ThemeController {

    @Autowired
    ThemeMapper themeMapper;
    @Autowired
    TagMapper tagMapper;
    @Autowired
    ReviewMapper reviewMapper;
    @Autowired
    LikeMapper likeMapper;
    @Autowired
    RoomMapper roomMapper;

    private final S3UploadUtil s3UploadUtil;

    @GetMapping("/main/theme")
    public List<ThemeDto> selectThemeList() {

        return themeMapper.selectThemeList();
    }

    @PostMapping("/theme/list")
    public List<RoomDto> selectThemeRoomList(@RequestBody HashMap<String,Object> data){

        HashMap<String, Object> map = new HashMap<>();

        map.put("themeNum",data.get("themeNum"));
        map.put("sort",data.get("sort"));
        map.put("headCount",data.get("headCount"));
        map.put("name",data.get("roomName"));
        map.put("address",data.get("address"));
        map.put("payment",data.get("payment"));
        map.put("sprice",data.get("sprice"));
        map.put("eprice",data.get("eprice"));
        map.put("facilityList",data.get("facility"));
        map.put("facilityCount",data.get("facilityCount"));
        map.put("holiday",data.get("holiday"));
        map.put("stime",data.get("stime"));
        map.put("etime",data.get("etime"));

        return themeMapper.selectThemeRoomList(map);
    }

    @GetMapping("/theme/data")
    public ThemeDto selectTheme(int themeNum){

        return themeMapper.selectTheme(themeNum);
    }

    @GetMapping("/tag/list")
    public Map<String,Object> selectTagList(@RequestParam int num){

        Map<String,Object> map = new HashMap<>();

        map.put("roomImageData",roomMapper.selectRoomImageList(num));
        map.put("tagData",tagMapper.selectTagList(num));
        map.put("reviewCount",reviewMapper.selectReviewCount(num));
        map.put("likeCount",likeMapper.selectLikeCount(num));

        return map;
    }

    @DeleteMapping("/theme/delete/room")
    public void deleteThemeRoom(int themeNum, int roomNum){

        HashMap<String,Object> map = new HashMap<>();

        map.put("themeNum",themeNum);
        map.put("roomNum",roomNum);

        themeMapper.deleteThemeRoom(map);
    }

    @DeleteMapping("/theme/delete")
    public void deleteTheme(int num){

        // db에 이미지가 있는 경우 s3 이미지 파일 삭제
        if(themeMapper.selectTheme(num).getBannerImage()!=null){
            String path = themeMapper.selectTheme(num).getBannerImage().split("/",4)[3];
            s3UploadUtil.delete(path);
        }
        themeMapper.deleteTheme(num);
    }

    @PatchMapping("/theme/update")
    public void updateTheme (@RequestParam(value="file", required = false) MultipartFile multipartFile,
                              String title,
                              String description,
                              int num
    ) throws IOException {

        HashMap<String, Object> map = new HashMap<>();

        map.put("title",title);
        map.put("description",description);
        map.put("num",num);

        // 이미지파일 첨부 여부 체크
        if(multipartFile!=null){
            // 이미지파일 첨부시
            if(themeMapper.selectTheme(num).getBannerImage()!=null){
                // db에 이미지 url이 있는 경우
                // 기존 데이터의 이미지url을 가져온 후 s3파일 삭제
                String path = themeMapper.selectTheme(num).getBannerImage().split("/",4)[3];
                s3UploadUtil.delete(path);
            }
            // 새로운 이미지 s3에 업로드 후 map에 추가
            map.put("file",s3UploadUtil.upload(multipartFile,"theme"));
        } else {
            // 이미지파일 미첨부시
            // db의 이미지 url 가져와서 map에 추가
            map.put("file",themeMapper.selectTheme(num).getBannerImage());
        }

        themeMapper.updateTheme(map);
    }

    @PostMapping("/theme/insert")
    public void insertTheme (@RequestParam("file") MultipartFile multipartFile,
                              String title,
                              String description
    ) throws IOException {

        HashMap<String, Object> map = new HashMap<>();

        map.put("title",title);
        map.put("description",description);
        map.put("file",s3UploadUtil.upload(multipartFile,"theme"));

        themeMapper.insertTheme(map);
    }

    @PostMapping("/theme/insert/room")
    public void insertThemeRoom(@RequestBody HashMap<String,Object> params){

        HashMap<String, Object> map = new HashMap<>();

        map.put("roomNumList",params.get("roomNumList"));
        map.put("themeNum",params.get("themeNum"));

        themeMapper.insertThemeRoom(map);
    }

    @GetMapping("/theme/select/exclude/room")
    public List<RoomDto> selectThemeExcludeRoom(int themeNum){
        return roomMapper.selectThemeExcludeRoom(themeNum);
    }
}
