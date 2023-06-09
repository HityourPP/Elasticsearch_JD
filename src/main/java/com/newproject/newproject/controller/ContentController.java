package com.newproject.newproject.controller;

import com.newproject.newproject.pojo.Content;
import com.newproject.newproject.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;
import java.util.Map;

//请求编写
@RestController
public class ContentController {

    @Autowired
    private ContentService contentService;
    @GetMapping("/parse/{keyword}")
    public boolean parse(@PathVariable("keyword") String keyword) throws IOException {
        return contentService.parseContent(keyword);
    }
    @GetMapping("/search/{keyword}/{pageNo}/{pageSize}")
    public List<Map<String,Object>> search(
            @PathVariable("keyword") String keyword,
            @PathVariable("pageNo") int pageNo,
            @PathVariable("pageSize") int pageSize) throws IOException {
        return contentService.searchPage(keyword,pageNo,pageSize);
    }
}
