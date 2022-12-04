package data.controller;

import data.dto.RoomDto;
import data.dto.ThemeDto;
import data.mapper.*;
import data.util.ChangeName;
import data.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
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

    String uploadFileName;

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

        System.out.println(data);
        System.out.println(map);

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
        System.out.println(map);

        themeMapper.deleteThemeRoom(map);
    }

    @DeleteMapping("/theme/delete")
    public void deleteTheme(int num){
        themeMapper.deleteTheme(num);
    }

    @PatchMapping("/theme/update")
    public void updateTheme (@RequestBody MultipartFile file,
                              HttpServletRequest request,
                              String title,
                              String description,
                              int num
    ){
        HashMap<String, Object> map = new HashMap<>();

        map.put("title",title);
        map.put("description",description);
        map.put("num",num);

        try {
            if(file != null) {
                String path = request.getSession().getServletContext().getRealPath("/image");
                if (uploadFileName != null) {
                    FileUtil.deletePhoto(path, uploadFileName);
                }
                uploadFileName = file.getOriginalFilename();
                uploadFileName = ChangeName.getChangeFileName(file.getOriginalFilename());
                file.transferTo(new File(path + "/" + uploadFileName));
                System.out.println("파일 업로드 성공 -> 경로 // 파일명 " + path + "//" +uploadFileName );
                map.put("file",uploadFileName);
            }else {
                map.put("file",null);
            }
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } catch (NullPointerException e) {
        }
        themeMapper.updateTheme(map);
    }

    @PostMapping("/theme/insert")
    public void insertTheme (@RequestBody MultipartFile file,
                              HttpServletRequest request,
                              String title,
                              String description
    ){
        System.out.println(title);
        System.out.println(description);

        HashMap<String, Object> map = new HashMap<>();

        map.put("title",title);
        map.put("description",description);

        try {
            if(file != null) {
                String path = request.getSession().getServletContext().getRealPath("/image");
                if (uploadFileName != null) {
                    FileUtil.deletePhoto(path, uploadFileName);
                }
                uploadFileName = file.getOriginalFilename();
                uploadFileName = ChangeName.getChangeFileName(file.getOriginalFilename());
                file.transferTo(new File(path + "/" + uploadFileName));
                System.out.println("파일 업로드 성공 -> 경로 // 파일명 " + path + "//" +uploadFileName );
                map.put("file",uploadFileName);
            }else {
                map.put("file",null);
            }
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } catch (NullPointerException e) {
        }
        System.out.println(map);
        themeMapper.insertTheme(map);
    }

    @PostMapping("/theme/insert/room")
    public void insertThemeRoom(@RequestBody HashMap<String,Object> params){

        HashMap<String, Object> map = new HashMap<>();

        map.put("roomNumList",params.get("roomNumList"));
        map.put("themeNum",params.get("themeNum"));

        System.out.println(map);

        themeMapper.insertThemeRoom(map);
    }
    @GetMapping("/theme/select/exclude/room")
    public List<RoomDto> selectThemeExcludeRoom(int themeNum){
        System.out.println(themeNum);
        return roomMapper.selectThemeExcludeRoom(themeNum);
    }
}
