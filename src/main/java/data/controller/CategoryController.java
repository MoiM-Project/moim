package data.controller;

import data.dto.CategoryDto;
import data.mapper.CategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class CategoryController {

    @Autowired
    CategoryMapper categoryMapper;

    @GetMapping("/categoryList")
    public List<CategoryDto> categoryList()
    {
        System.out.println("asd");
        return categoryMapper.getAllCategory();
    }
}
