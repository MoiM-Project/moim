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
import java.util.List;


@RestController
@CrossOrigin
public class ReviewQnaController {

    String uploadFileName;

    @Autowired
    ReviewMapper reviewMapper;


    @GetMapping("/reviewQna/reviewList")
    public List<ReviewDto> getReviewByUserNum(@RequestParam int userNum,@RequestParam String sort){
        HashMap<String, Object> map = new HashMap<>();
        map.put("userNum",userNum);
        map.put("sort",sort);

        return reviewMapper.getReviewByUserNum(map);
    }

    @DeleteMapping("/reviewDelete")
    public void reviewDelete(@RequestParam int num){
        reviewMapper.reviewDelete(num);
    }

    @GetMapping("/reviewMember")
    public ReviewDto reviewMember(@RequestParam int num){
        return reviewMapper.getReviewByNum(num);
    }

    @PostMapping("/reviewUpdate")
    public void updateReview (@RequestBody MultipartFile uploadFile,
                              HttpServletRequest request,
                              @RequestParam String content,
                              int rating,
                              int num,
                              String oldPhoto
    ){

        //DB에 Insert하기위해 map 선언
        HashMap<String, Object> map = new HashMap<>();

        //uploadFile을 제외하고 map에 담기
        map.put("content",content);
        map.put("rating",rating);
        map.put("num",num);

        System.out.println(content);
        System.out.println(rating);

        //파일을 첨부했는지 안했는지 체크
        try {

            //upload 파일첨부를 했을때
//            if(!uploadFile.isEmpty()) {
            if(uploadFile != null) {

                // 업로드할 폴더의 경로(path) 구하기
                String path = request.getSession().getServletContext().getRealPath("/image");

                //기존 업로드 파일이 있을 경우 path 경로에서 파일 삭제 후 다시 업로드
                if (oldPhoto != null) {
                    FileUtil.deletePhoto(path, oldPhoto);   //있을 경우 path 경로의 oldPhoto 를 지운다
                    System.out.println("기존 사진 oldPhoto 삭제 완료");
                }

                //업로드 파일을 변수에 담기
                uploadFileName = uploadFile.getOriginalFilename();

                //파일명을 날짜타입으로 변경
                uploadFileName = ChangeName.getChangeFileName(uploadFile.getOriginalFilename());

                //path 경로에 파일 업로드 진행
                uploadFile.transferTo(new File(path + "/" + uploadFileName));

                //성공 시 콘솔에 찍기
                System.out.println("파일 업로드 성공 -> 경로 // 파일명 " + path + "//" +uploadFileName );

                //map 에 uploadFile 담기
                map.put("uploadFile",uploadFileName);

                //upload 파일첨부를 안했을때
            }else {
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
        reviewMapper.updateReview(map);
        System.out.println(map);
    }

}
