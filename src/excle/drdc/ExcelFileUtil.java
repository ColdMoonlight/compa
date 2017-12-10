/*************************************************************************
 *file name   :  ExcelFileUtil.java
 *copyright   :   umpay
 *modified    :   Jan 19, 2011
 *************************************************************************/
package excle.drdc;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;


//import com.umpay.sp.exception.BaseException;
//import com.umpay.sp.util.StringUtil;

/*************************************************************************
 *class : ExcelFileUtil
 * 
 * @author : Ding Zhe
 *@version : 1.0 description : 
 *		2011.03.07 Gongqin 增加读取excel文档的功能，并解决 jxl 读取大于 10000 行记录时出错的问题
 *@see :
 *************************************************************************/
public class ExcelFileUtil {

	public static WritableSheet addSheet(WritableWorkbook workbook,
			List<String> tableHeadList, String sheetName, int sheetNum)
			throws Exception {
		if (null == workbook) {
			String errMsg = "workbook为空！";
//			log.error("增加sheet失败：" + errMsg);
			throw new Exception(errMsg);
		}

		if (tableHeadList == null || tableHeadList.size() == 0) {
			String errMsg = "sheet的头信息列表为空！";
//			log.error("增加sheet失败：" + errMsg);
			throw new Exception(errMsg);
		}

		WritableSheet sheet = workbook.createSheet(sheetName, sheetNum);
		int size = tableHeadList.size();
		sheet.mergeCells(0, 0, size, 0); // 合并单元格，
		// 设置标题的格式
		WritableCellFormat title = new WritableCellFormat();
		title.setBackground(jxl.format.Colour.GRAY_25);
		title.setAlignment(jxl.format.Alignment.CENTRE);
		for (int i = 0; i < size; i++) {
			sheet.setColumnView(i, 20);
			Label temp = new Label(i, 1, tableHeadList.get(i), title);
			sheet.addCell(temp);
		}

		return sheet;
	}

	public static WritableSheet addSheet(WritableWorkbook workbook,
			List<String> tableHeadList, String sheetName, int sheetNum,
			int[] widthArr) throws Exception {

		if (null == workbook) {
			String errMsg = "workbook为空！";
//			log.error("增加sheet失败：" + errMsg);
			throw new Exception(errMsg);
		}

		if (tableHeadList == null || tableHeadList.size() == 0) {
			String errMsg = "sheet的头信息列表为空！";
//			log.error("增加sheet失败：" + errMsg);
			throw new Exception(errMsg);
		}

		if (widthArr == null || widthArr.length == 0) {
			String errMsg = "sheet的头信息宽度为空！";
//			log.error("增加sheet失败：" + errMsg);
			throw new Exception(errMsg);
		}

		WritableSheet sheet = workbook.createSheet(sheetName, sheetNum);
		int size = tableHeadList.size();
		sheet.mergeCells(0, 0, size, 0); // 合并单元格，
		// 设置标题的格式
		WritableCellFormat title = new WritableCellFormat();
		title.setBackground(jxl.format.Colour.GRAY_25);
		title.setAlignment(jxl.format.Alignment.CENTRE);
		for (int i = 0; i < size; i++) {
			sheet.setColumnView(i, widthArr[i]);
			Label temp = new Label(i, 1, tableHeadList.get(i), title);
			sheet.addCell(temp);
		}

		return sheet;
	}
	/**
	 * 方法说明：读取excel文件一行数据
	 * @param int row指定的行数
	 * @return String[] 结果数组
	 * @author 弓勤
	 */
	private static String[] readLine(Sheet sheet, int row) throws Exception {
		// 获取数据表列数
		int colnum = sheet.getColumns();
		String[] rest = new String[colnum];
		for (int colIndex = 0; colIndex < colnum; colIndex++) {
			Cell cell = sheet.getCell(colIndex, row);
			String sTemp = cell.getContents();
			if (sTemp != null)
				rest[colIndex] = sTemp;
		}
		return rest;
	}
	/**
	 * 取得97-2003版本Excel中的指定范围记录，如此可以解决JXL读取10000行以上的sheet的问题。
	 * @param start 开始行号
	 * @param len 读取行数
	 * @return List<String[]>
	 * @author 弓勤
	 */
	public static List<String[]> readExcelSubRecord(Sheet sheet, int start, int len) {
		List<String[]> list = new ArrayList<String[]>(10);
		int rownum = start + len;
		for (int i = start; i < rownum; i++) {
			try {
				list.add(readLine(sheet, i));
			} catch (Exception e) {
//				log.error("读取第 " + i + " 行数据出错。" + e.getLocalizedMessage(), e);
			}
		}
		return list;
	}
	
	/**
	 * 	
	 * desc:解析xls文件(读取第一个sheet)
	 * <p>创建人：liuguangjun , Nov 8, 2013 5:46:08 PM</p>
	 * @param tagerFileName
	 * @return
	 * @throws BaseException
	 * @throws BiffException
	 * @throws IOException
	 */
	public static List<String[]> readWorkbook(String tagerFileName) throws Exception, BiffException, IOException{
		List<String[]> lineList=new ArrayList<String[]>();;
		Workbook workbook = null;
		try {
			//1，校验文件存在性
			File file = new File(tagerFileName);
			if (!file.exists()) {
				throw new Exception("未找到需要解析的xls文件");
			}
			//2解析xls
			workbook = Workbook.getWorkbook(file);
			Sheet sheet = workbook.getSheet(0);
			int totalRow = sheet.getRows();
			lineList = readExcelSubRecord(sheet, 2, totalRow- 2);//读取数据 tanlin 20140606 批量付款三期优化，文件头变化
		}finally{
			if(null != workbook) 
				  workbook.close();
		}
		return lineList;
	}

 
	/**
	 * desc:判断头标题是否符合要求，参数propKey表示key
	 * <p>创建人：chengliuyun , Jun 4, 2012 4:04:33 PM</p>
	 * @return
	 */
//	public static boolean headStrIsRight(String propKey,Sheet sheet) throws Exception{
//		String head = PropertyUtil.getStrValue("resources"+File.separator+"checkParam","mapping_keys.properties", propKey, "");//excel表头
//		String[] heads = head.split(",");
//		for (int i = 0; i < heads.length; i++) {
//			Cell cell = sheet.getCell(i, 1); //tanlin  20140606 批量付款三期优化，文件头变化
//			if (!StringUtil.trim(heads[i]).equals(StringUtil.trim(cell.getContents()))) {
//				log.error("[批量付款-校验线程]excel表头内容不符合要求！excel表头:" + heads[i] + "=="+cell.getContents());
//				return false;
//			}
//		}
//		return true;
//	}
}
