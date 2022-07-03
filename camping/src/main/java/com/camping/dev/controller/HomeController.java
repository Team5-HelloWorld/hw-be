package com.camping.dev.controller;

import com.camping.dev.model.vo.GoodsSampleVO;
import com.camping.dev.service.GoodsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/home")
public class HomeController {

    @Autowired
    private GoodsService goodsService;

    private final Logger logger = LoggerFactory.getLogger("SampleController's Log");

    @GetMapping("/")
    public @ResponseBody
    List<GoodsSampleVO> getSampleList() {

        logger.info("HomeController called!");
        return goodsService.getSampleList();

    }

}
