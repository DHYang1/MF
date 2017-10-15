package mf.service;
import java.io.FileOutputStream;
import java.util.List;

import mf.pojo.Shop;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class CreateSimpleExcelToDisk
{
    public void creat(List<Shop> shops){
        /**
         * @功能：手工构建一个简单格式的Excel
         */
        // 第一步，创建一个webbook，对应一个Excel文件
        HSSFWorkbook wb = new HSSFWorkbook();
        // 第二步，在webbook中添加一个sheet,对应Excel文件中的sheet
        HSSFSheet sheet = wb.createSheet("美发地图表");
        // 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short
        HSSFRow row = sheet.createRow((int) 0);
        // 第四步，创建单元格，并设置值表头 设置表头居中
        HSSFCellStyle style = wb.createCellStyle();
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 创建一个居中格式

        HSSFCell cell = row.createCell(0);
        cell.setCellValue("name");
        cell.setCellStyle(style);
        cell = row.createCell(1);
        cell.setCellValue("x");
        cell.setCellStyle(style);
        cell = row.createCell(2);
        cell.setCellValue("y");
        cell.setCellStyle(style);
        cell = row.createCell( 3);
        cell.setCellValue("address");
        cell.setCellStyle(style);
        cell = row.createCell(4);
        cell.setCellValue("telephone");
        cell.setCellStyle(style);

        // 第五步，写入实体数据 实际应用中这些数据从数据库得到，
        List list = shops;

        for (int i = 0; i < list.size(); i++)
        {
            row = sheet.createRow((int) i + 1);
            Shop shop = (Shop) list.get(i);
            // 第四步，创建单元格，并设置值
            row.createCell(0).setCellValue(shop.getName());
            row.createCell(1).setCellValue((double)shop.getX());
            row.createCell(2).setCellValue((double) shop.getY());
            row.createCell(3).setCellValue(shop.getAddress());
            row.createCell(4).setCellValue(shop.getPhone());
        }
        // 第六步，将文件存到指定位置
        try
        {
            FileOutputStream fout = new FileOutputStream("E:/students.xls");
            wb.write(fout);

            fout.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
