package data.controller;

import data.dto.ReviewDto;
import data.mapper.ReviewMapper;
import data.util.ChangeName;
import data.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

//a3
import data.util.S3UploadUtil;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@CrossOrigin
@RequestMapping("/review")
public class ReviewController {
    @Autowired
    ReviewMapper reviewMapper;

    private final S3UploadUtil s3UploadUtil; // a3
    String uploadFileName;
    ArrayList<String> uploadFileNames = new ArrayList<>();

    //  리뷰작성 - booking detail page
    @PostMapping("/insert")
    public void reviewInsert (@RequestParam(value="uploadFile", required = false) MultipartFile multipartFile,
                              HttpServletRequest request,
                              @RequestParam String content,
                              int rating,
                              int userNum,
                              int roomNum,
                              int bookingDetailNum
    ){

        //DB에 Insert하기위해 map 선언
        HashMap<String, Object> map = new HashMap<>();

        //uploadFile을 제외하고 map에 담기
        map.put("content",content);
        map.put("rating",rating);
        map.put("userNum",userNum);
        map.put("roomNum",roomNum);
        map.put("bookingDetailNum", bookingDetailNum);

        //파일을 첨부했는지 안했는지 체크
        try {
            //upload 파일첨부를 했을때
            if(multipartFile!=null) {
                //map 에 uploadFile 담기
               // map.put("uploadFile",uploadFileName);
                map.put("uploadFile",s3UploadUtil.upload(multipartFile,"review"));
            }else {
                //upload 파일첨부를 안했을때
                //map 에 uploadFile null 로 담기
                map.put("uploadFile",null);
            }

        } catch (IllegalStateException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            throw new RuntimeException(e);
        } catch (NullPointerException e) {

        }
        // insert sql 에 map 전달
        reviewMapper.reviewInsert(map);
    }

    @GetMapping("/check")
    public ReviewDto reviewCheck(int bookingDetailNum){
        return reviewMapper.reviewCheck(bookingDetailNum);
    }
}
