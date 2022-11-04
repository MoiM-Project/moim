package util;

import java.io.File;

public class FileUtil {

    // 이미지 파일 삭제
    public static void deletePhoto(String path, String fileName) {

        // 파일 객체 생성
        File file = new File(path+"/"+fileName);

        // 존재할 경우 삭제
        if(file.exists()) {
            file.delete();
            System.out.println(fileName+" file delete");
        }
    }
    
    //git push test 용도
    //주석 추가
    //2222
}
