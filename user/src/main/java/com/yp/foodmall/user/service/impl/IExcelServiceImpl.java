package com.yp.foodmall.user.service.impl;
/**
 * @author pan
 * @date 2021/2/23 11:52
 */


import com.yp.foodmall.common.entity.Order;
import com.yp.foodmall.user.service.IExcelService;
import com.yp.foodmall.user.service.IOrderService;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @ClassName : com.yp.foodmall.poi.service.impl.IExcelServiceImpl
 * @Description : 类描述
 * @author pan
 * @date 2021/2/23 11:52
 */

@Service
public class IExcelServiceImpl implements IExcelService {
    @Autowired
    private IOrderService iOrderService;

    @Override
    public void writeToExcel() throws IOException {
        List<Order> orders = iOrderService.selectOrderByUser(1);
        //创建一个·excel对象
        HSSFWorkbook excel = new HSSFWorkbook();
        //生成表单
        HSSFSheet sheet = excel.createSheet("订单");
        for(int i=0; i<orders.size();i++){
            //生成行
            HSSFRow row = sheet.createRow(i);
            Order order = orders.get(i);
            //生成单元格
            row.createCell(0).setCellValue(order.getOrderId());
            row.createCell(1).setCellValue(order.getUser().getUserName());
            row.createCell(2).setCellValue(order.getComStore().getStore().getStoreName());
            row.createCell(3).setCellValue(order.getComStore().getCommodity().getComName());
            row.createCell(4).setCellValue(order.getPrice());
            row.createCell(5).setCellValue(order.getCount());
            row.createCell(6).setCellValue(order.getStatus());
            row.createCell(7).setCellValue(order.getCreateTime());


        }

        //生成文件
        excel.write(new File("C:/Users/dell/Desktop/oder.xls"));

    }

    @Override
    public void readFromExcel() {

    }
}
