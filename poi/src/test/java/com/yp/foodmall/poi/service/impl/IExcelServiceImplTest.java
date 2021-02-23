package com.yp.foodmall.poi.service.impl;

import com.yp.foodmall.poi.service.IExcelService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;

import static org.junit.Assert.*;

/**
 * @author pan
 * @date 2021/2/23 12:01
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class IExcelServiceImplTest {
    @Autowired
    private IExcelService iExcelService;
    @Test
    public void writeToExcel() throws IOException {
        iExcelService.writeToExcel();
    }

    @Test
    public void readFromExcel() {
    }
}