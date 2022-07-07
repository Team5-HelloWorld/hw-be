package com.camping.dev.service;

import com.camping.dev.mapper.ReviewMapper;
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

@Service
@AllArgsConstructor
public class ReviewServiceImpl implements  ReviewService {

    private ReviewMapper reviewMapper;

    private final ClassPathResource reviewCsvResource = new ClassPathResource("csv/reviews_by_prd_4_cols.csv");
    private final Logger logger = LoggerFactory.getLogger("ReviewServiceImpl's log");

    @PostConstruct
    public void readReviewDataCsvAndInsert() {
        BufferedReader reviewsReader = null;

        int count = reviewMapper.getCount();

        // 초기 Data 가 없을 때 csv read
        if (count == 0) {

            try {
                reviewsReader = Files.newBufferedReader(Paths.get(reviewCsvResource.getURI()));
                String line = "";

                // read first line(column)
                String tmp = reviewsReader.readLine();

                while ((line = reviewsReader.readLine()) != null) {

                    String reviewDetail[] = line.split(",");
                    String prdId = reviewDetail[0];
                    String userId = reviewDetail[1];

                    // review 에 콤마가 있을 수 있기 때문에 grade 전까지의 스트링을 review 에 모두 넣음.
                    String review = "";
                    for(int i = 2; i < reviewDetail.length - 1; i++)
                        review += reviewDetail[i];

                    int grade = Integer.parseInt(reviewDetail[reviewDetail.length - 1]);

                    reviewMapper.insertInitData(prdId, userId, grade, review);

                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (reviewsReader != null) {
                        reviewsReader.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            reviewMapper.updateId();

        }
    }

}
