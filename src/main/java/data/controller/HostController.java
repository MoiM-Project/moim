package data.controller;

import data.dto.CategoryDto;
import data.dto.MainCategoryDto;
import data.dto.RoomDto;
import data.mapper.CategoryMapper;
import data.mapper.HostMapper;
import data.mapper.TagMapper;
import data.util.ChangeName;
import data.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.*;

@RestController
@CrossOrigin
@RequestMapping("/host")

public class HostController {
    String uploadFileName;

    List<String> roomList = new ArrayList<>();

    @Autowired
    HostMapper hostMapper;

    @Autowired
    TagMapper tagMapper;

    @Autowired
    CategoryMapper categoryMapper;

    @GetMapping("/list")
    public List<RoomDto> roomList() {
//        System.out.println(hostMapper.getRoomList().size());
        return hostMapper.getRoomList();
    }

    @GetMapping("/maincategoryList")
    public List<MainCategoryDto> mainCategoryList() {
//        System.out.println("hostMapper.getMainCategoryList().size()" + hostMapper.getMainCategoryList().size());
        return hostMapper.getMainCategoryList();
    }

    @GetMapping("/categoryList")
    public List<CategoryDto> categoryList() {
//        System.out.println("hostMapper.getCategoryList().size()" + hostMapper.getCategoryList().size());
        return hostMapper.getCategoryList();
    }


    @PostMapping("/insert")
    public int insertRoom(@RequestBody RoomDto dto) {
        //업로드한 파일 이름 넣기
        dto.setThumbnailImage(uploadFileName);

        hostMapper.insertRoom(dto);

        uploadFileName = null; //비워줘야 다음에 먼저 첨부했떤 파일이 들어가있지 않음

//        System.out.println(dto.getNum());
        return dto.getNum();
    }

    @PostMapping("/insert2")
    public void insertRoom2(@RequestBody HashMap<String,Object> params) throws Exception{

        HashMap<String,Object> map1 = new HashMap<>();
        List<Map<String,Object>> infoList = (List<Map<String, Object>>)params.get("InfoList");
        List<Map<String,Object>> preList = (List<Map<String, Object>>)params.get("PreList");
        List<Map<String,Object>> imgList = (List<Map<String, Object>>)params.get("RoomList");
        List<Map<String,Object>> optionList = (List<Map<String, Object>>)params.get("OptionList");

        System.out.println(infoList.get(0));

//        try {
//            System.out.println(infoList.get(0));
//        }catch (NullPointerException e) {
//            System.out.println("--NullPointerException 발생--");
//            System.out.println("기존 코드를 체크해 주세요!!");
//        }finally {
//            System.out.println("예외처리 코드가 오류없이 진행되었습니다.");
//        }


        map1.put("infoList",infoList);
        map1.put("preList",preList);
        map1.put("imgList",imgList);
        map1.put("optionList",optionList);

        System.out.println("infoList="+infoList);
        System.out.println("preList="+preList);
        System.out.println("imgList="+imgList);
        System.out.println("optionList="+optionList);

        hostMapper.insertInformation(map1);
        hostMapper.insertPrecaution(map1);
        hostMapper.insertRoomImage(map1);
        hostMapper.insertRoomOption(map1);

        HashMap<String,Object> map2 = new HashMap<>();
        List<Map<String,Object>> tagList = (List<Map<String, Object>>)params.get("Taglist");
        map2.put("tagList",tagList);
        tagMapper.insertTag(map2);

        HashMap<String,Object> map3 = new HashMap<>();
        List<Map<String,Object>> cateList = (List<Map<String, Object>>)params.get("CateList");
        map3.put("cateList",cateList);
        categoryMapper.insertCategory(map3);
    }

    @PostMapping("/insertupdate")
    public void insertupdate(@RequestBody RoomDto dto) {
        System.out.println("dto.getFloor()"+dto.getFloor());
        hostMapper.insertUpdateRoom(dto);
    }
    //썸네일 업로드
    @PostMapping("/photoupload")
    public String fileUploadlist(@RequestBody MultipartFile uploadFile, HttpServletRequest request) {
        System.out.println("React로부터 썸네일 이미지 업로드");

        // 업로드할 폴더 구하기
        String path = request.getSession().getServletContext().getRealPath("/image");

        //기존 업로드 파일이 있을 경우 삭제 후 다시 업로드
        if (uploadFileName != null) {
            FileUtil.deletePhoto(path, uploadFileName);   //있을 경우 path 경로의 uploadFileName 을 지운다
        }

        //변수에 담기
        uploadFileName = uploadFile.getOriginalFilename();

        //이전 업로드한 사진을 지운 후 현재 사진 업로드하기(파일명을 날짜타입으로 변경)
        uploadFileName = ChangeName.getChangeFileName(uploadFile.getOriginalFilename());
        try {
            uploadFile.transferTo(new File(path + "/" + uploadFileName));

//            Path saveFile=Paths.get(path+"/"+uploadFileName);
//            uploadFile.transferTo(saveFile);

            System.out.println("썸네일 업로드 성공");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return uploadFileName;
    }

    //사진 리스트 업로드
    //업로드끝난 파일명을 반환해줄거임 -> List<String>
    @PostMapping("/photolistupload")
    public List<String> photoUpload(@RequestParam List<MultipartFile> uploadFile,
                                    HttpServletRequest request) {
        System.out.println(uploadFile.size() + "개 업로드");

        //업로드할 폴더
        String path = request.getSession().getServletContext().getRealPath("/image");

        // foodList 의 기존 사진명 지우기
        roomList.clear();

        //기존 업로드 파일이 있을 경우 삭제 후 다시 업로드
        if (uploadFileName != null) {
            FileUtil.deletePhoto(path, uploadFileName);   //있을 경우 path 경로의 uploadFileName 을 지운다
        }

        for (MultipartFile multi : uploadFile) {
            System.out.println(multi.getOriginalFilename());

            try {
                multi.transferTo(new File(path + "/" + multi.getOriginalFilename()));
                //이전 업로드한 사진을 지운 후 현재 사진 업로드하기(파일명을 날짜타입으로 변경)
                uploadFileName = ChangeName.getChangeFileName(multi.getOriginalFilename());
                roomList.add(multi.getOriginalFilename());

            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }
        return roomList;
    }

    //옵션 사진 업로드
    @PostMapping("/optionimage")
    public String OptionImage(@RequestBody MultipartFile uploadFile, HttpServletRequest request) {
        System.out.println("React로부터 옵션 이미지 업로드");

        // 업로드할 폴더 구하기
        String path = request.getSession().getServletContext().getRealPath("/image");

        //기존 업로드 파일이 있을 경우 삭제 후 다시 업로드
        if (uploadFileName != null) {
            FileUtil.deletePhoto(path, uploadFileName);   //있을 경우 path 경로의 uploadFileName 을 지운다
        }

        //변수에 담기
        uploadFileName = uploadFile.getOriginalFilename();

        //이전 업로드한 사진을 지운 후 현재 사진 업로드하기(파일명을 날짜타입으로 변경)
        uploadFileName = ChangeName.getChangeFileName(uploadFile.getOriginalFilename());
        try {
            uploadFile.transferTo(new File(path + "/" + uploadFileName));

//            Path saveFile=Paths.get(path+"/"+uploadFileName);
//            uploadFile.transferTo(saveFile);

            System.out.println("옵션 업로드 성공");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return uploadFileName;
    }

    @GetMapping("/delphoto")
    public void deletePhoto(@RequestParam int idx) {
//        System.out.println(idx + "번 삭제");
        roomList.remove(idx);
    }

    @DeleteMapping("/cancel")
    public void deleteBoard(@RequestParam int num, HttpServletRequest request) {
        System.out.println(num);
        hostMapper.deleteRoom(num);   //DB 데이터 삭제
    }
}
