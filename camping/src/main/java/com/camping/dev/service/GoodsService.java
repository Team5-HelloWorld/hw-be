package com.camping.dev.service;

import com.camping.dev.model.vo.GoodsDetailVO;
import com.camping.dev.model.vo.GoodsSampleVO;

import java.util.List;

public interface GoodsService {

    public List<GoodsSampleVO> getSampleList();

    public GoodsDetailVO getGoodsDetail(int id);

}
