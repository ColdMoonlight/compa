package excle.drdc;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * poi——excle导入导出
 * @author shaphua
 * @version 20170718
 * */
public class HightPoiExpExale {
	
	public static void main(String[] args) {
		String[] title = {"id","name","sex"};
		
		//创建一个工作簿
		XSSFWorkbook workbook = new XSSFWorkbook();
		//创建一个工作表
		Sheet sheet = workbook.createSheet("sheet0");		
		//创建第一行
		Row row = sheet.createRow(0);
		//创建单元格
		Cell cell = null;
		//写入属性行
		for(int i=0;i<title.length;i++){
			cell = row.createCell(i);
			cell.setCellValue(title[i]);
		}
		//追加数据
		for(int i=1;i<=10;i++){
			Row nextrow = sheet.createRow(i);
			Cell cell2 = nextrow.createCell(0);
			
			cell2.setCellValue("a"+i);
			cell2 = nextrow.createCell(1);
			cell2.setCellValue("user"+i);
			cell2 = nextrow.createCell(2);
			cell2.setCellValue("nv"+i);
		}
		
		//创建文件
		File file = new File("F:/file/poi_test0831high.xls");
		try {
			file.createNewFile();
			
			FileOutputStream stream = FileUtils.openOutputStream(file);
			workbook.write(stream);
			stream.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
