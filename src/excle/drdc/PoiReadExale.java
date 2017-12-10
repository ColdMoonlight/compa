package excle.drdc;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;

/**
 * poi——excle导入导出
 * @author shaphua
 * @version 20170718
 * */
public class PoiReadExale {
	
	public static void main(String[] args) {
		//需要读取的excle文件
		File file = new File("F:/file/poi_test0831.xls");
		try {
			//读取文件内容
			HSSFWorkbook workbook = new HSSFWorkbook(FileUtils.openInputStream(file));
			//默认读取第一个工作表sheet
			HSSFSheet sheet = workbook.getSheetAt(1);
			int firstRowNum = 0;
			int lastRowNum = sheet.getLastRowNum();
			for(int i=0;i<lastRowNum;i++){
				HSSFRow row = sheet.getRow(i);
				//获取当前行最后的单元格列号码
				int lastCellNum = row.getLastCellNum();
				for(int j=0;j<lastCellNum;j++){
					HSSFCell cell = row.getCell(j);
					if(cell!=null){
						cell.setCellType(Cell.CELL_TYPE_STRING);
						String value = cell.getStringCellValue();
						System.out.print(value+"\t\t");
				     }
					//String value = cell.getStringCellValue();
				}
				System.out.println();
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
