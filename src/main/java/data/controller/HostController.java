package data.controller;

import data.dto.CategoryDto;
import data.dto.MainCategoryDto;
import data.dto.RoomDto;
import data.mapper.HostMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import util.ChangeName;
import util.FileUtil;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/host")
public class HostController {
    String uploadFileName;

    List<String> roomList = new ArrayList<>();

    @Autowired
    HostMapper hostMapper;

//    @GetMapping("/")
//    public String HostHome() {
//        return "/";
//    }

    @GetMapping("/list")
    public List<RoomDto> roomList() {
//        System.out.println(hostMapper.getRoomList().size());
        return hostMapper.getRoomList();
    }

    @GetMapping("/maincategoryList")
    public List<MainCategoryDto> mainCategoryList() {
        System.out.println("hostMapper.getMainCategoryList().size()" + hostMapper.getMainCategoryList().size());
        return hostMapper.getMainCategoryList();
    }

    @GetMapping("/categoryList")
    public List<CategoryDto> categoryList() {
        System.out.println("hostMapper.getCategoryList().size()" + hostMapper.getCategoryList().size());
        return hostMapper.getCategoryList();
    }


    @PostMapping("/insert")
    public int insertRoom(@RequestBody RoomDto dto) {
        //업로드한 파일 이름 넣기
        dto.setThumbnailImage(uploadFileName);

        hostMapper.insertRoom(dto);

        uploadFileName = null; //비워줘야 다음에 먼저 첨부했떤 파일이 들어가있지 않음

        System.out.println(dto.getNum());
        return dto.getNum();
    }


    //썸네일 업로드
    @PostMapping("/photoupload")
    public String fileUploadlist(@RequestBody MultipartFile uploadFile, HttpServletRequest request) {
        System.out.println("React로부터 이미지 업로드");

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

            System.out.println("업로드 성공");

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
}
