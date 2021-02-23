package com.yp.foodmall.poi.service;

import java.io.IOException;

/**
 * @author pan
 * @date 2021/2/23 11:50
 */
public interface IExcelService {
    void writeToExcel() throws IOException;
    void readFromExcel();
}
