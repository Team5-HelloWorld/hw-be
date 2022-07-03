package com.camping.dev.service;

import com.camping.dev.mapper.GoodsMapper;
import com.camping.dev.model.vo.GoodsSampleVO;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@Service
@AllArgsConstructor
public class GoodsServiceImpl implements GoodsService{

    private GoodsMapper goodsMapper;
    private final ClassPathResource mainCsvResource = new ClassPathResource("csv/main_page_data_renew.csv");
    private final Logger logger = LoggerFactory.getLogger("GoodsServiceImpl's log");

    @Override
    public List<GoodsSampleVO> getSampleList(){

        logger.info("getSampleList called!");

        return goodsMapper.getSampleList();

    }

    // 메인 화면 굿즈 데이터 DB 에 적재
    @PostConstruct
    public void readMainDataCsvAndInsert() {
        BufferedReader reader = null;

        int count = goodsMapper.getCount();

        // 초기 Data 가 없을 때 csv read
        if (count == 0) {

            try {
                reader = Files.newBufferedReader(Paths.get(mainCsvResource.getURI()));
                String line = "";

                // read first line(column)
                String tmp = reader.readLine();

                while ((line = reader.readLine()) != null) {

                    String goodsDetail[] = line.split(",");
                    String category = goodsDetail[1];
                    String name = goodsDetail[2];
                    int price = Integer.parseInt(goodsDetail[3]);
                    int reviews = Integer.parseInt(goodsDetail[4]);
                    String imageUrl = goodsDetail[5];

                    goodsMapper.insertSampleData(category, name, price, reviews, imageUrl);

                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (reader != null) {
                        reader.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }

}
