package com.yp.foodmall.poi.service.impl;
/**
 * @author pan
 * @date 2021/2/23 11:52
 */

import com.yp.foodmall.poi.service.IExcelService;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;

/**
 * @ClassName : com.yp.foodmall.poi.service.impl.IExcelServiceImpl
 * @Description : 类描述
 * @author pan
 * @date 2021/2/23 11:52
 */

@Service
public class IExcelServiceImpl implements IExcelService {
    @Override
    public void writeToExcel() throws IOException {
        //创建一个·excel对象
        HSSFWorkbook excel = new HSSFWorkbook();
        //生成表单
        HSSFSheet sheet = excel.createSheet("饼干类");
        //生成行
        HSSFRow row = sheet.createRow(0);
        //生成单元格
        HSSFCell cell = row.createCell(0);
        cell.setCellValue("三只松鼠小饼干");
        //生成文件
        excel.write(new File("C:/Users/dell/Desktop/food.xls"));

    }

    @Override
    public void readFromExcel() {

    }
}
