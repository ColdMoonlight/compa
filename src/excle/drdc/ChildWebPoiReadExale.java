package excle.drdc;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
public class ChildWebPoiReadExale {
	
	public static final String childWebleng = "merName&merType&contactsName&mobileNo&licenseType&licenseNo&organizationId&taxPayerNum&okCard&lawyer&cardNo&bankName&accountName&accountType&bankAccount&province&areaCode&minMoney&cheakCycle&email";
	
	public static final String RegexmerName="^\\S[\\s\\S]{1,16}$";
	public static final String RegexmerType="1|2";
	public static final String RegexmobileNo="^[0-9]{11}$";
	public static final String RegexsaaslicenseNo="^[0-9]{15}$";
	
	public static final String RegexorganizationId="^[0-9]{8}-[0-9]{1}$";
	public static final String RegextaxPayerNum="^[A-Za-z0-9]{1,20}$";
//	public static final String Regexlawyer="^[\u4e00-\u9fa5a-zA-Z\.\s]{1,16}$";
	public static final String RegexcardNo="^[1-9]\\d{5}(18|19|([23]\\d))\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\\d{3}[0-9Xx]$";
	
	public static final String RegexbankName="^[\u4E00-\u9FA5]{2,64}$";
	public static final String RegexbankAccount="^[0-9]{1,28}$";//bankAccount
	public static final String Regexprovince="^[0-9]{3}$";
	
	public static final String RegexareaCode="^[0-9]{3}$";//areaCode
	public static final String Regexemail="^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$";//email
//			Regex.merType=1|2
//			Regex.contActsName=^[\u4e00-\u9fa5a-zA-Z\.\s]{1,16}$//
//			Regex.mobileNo=^[0-9]{11}$
//			Regex.licenseType=1|2
//			Regex.saas.licenseNo=^[0-9]{15}$
//			Regex.saas.licenseNos=^[0-9a-zA-Z]{18}$//
//			Regex.organizationId=^[0-9]{8}-[0-9]{1}$
//			Regex.taxPayerNum=^[A-Za-z0-9]{1,20}$
//			Regex.lawyer=^[\u4e00-\u9fa5a-zA-Z\.\s]{1,16}$
//			Regex.cardNo=^[1-9]\\d{5}(18|19|([23]\\d))\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\\d{3}[0-9Xx]$
//			Regex.bankName=^[\u4E00-\u9FA5]{2,64}$
//			Regex.bankAccount=^[0-9]{1,28}$
//			Regex.province=^[0-9]{3}$
//			Regex.areaCode=^[0-9]{3}$
//			Regex.email=^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$
//			Regex.merNotifyUrl=.{1,128}】
	
	public static void main(String[] args) {
		
		//需要读取的excle文件
		long time1 = System.currentTimeMillis();
		System.out.println("开始读取时间"+time1);
		File file = new File("F:/file/20170904test3.xls");
		List<List<String>> result = new ArrayList<List<String>>();
		try {
			//读取文件内容
			HSSFWorkbook workbook = new HSSFWorkbook(FileUtils.openInputStream(file));
			//默认读取第一个工作表sheet
			HSSFSheet sheet = workbook.getSheetAt(0);
			//默认读取第一个工作表sheet的第一行+总行数
			int firstRowNum = 0;
			int lastRowNum = sheet.getLastRowNum();
			//遍历每行的数据
			int succNum = 0;
			int fauleNum = 0;
			for(int i=1;i<=lastRowNum;i++){
				HSSFRow row = sheet.getRow(i);
				//获取当前行最后的单元格列号码
				int lastCellNum = row.getLastCellNum();
				//每行做一个list
				List<String> resultOne = new ArrayList<String>();
				ChildWeb childWeb = new ChildWeb();
				//Field[] beanFiled=childWeb.getClass().getDeclaredFields();
				Map<String, String> reqMap=new HashMap<String, String>();
				String[] chrstr1=childWebleng.split("&");
				String[] chrstr2 =  new String[lastCellNum];
				for(int j=0;j<lastCellNum;j++){
					HSSFCell cell = row.getCell(j);
					if(cell!=null){
						cell.setCellType(Cell.CELL_TYPE_STRING);
						String value = cell.getStringCellValue();
//						System.out.print(value+"\t");
						chrstr2[j] = value;
						resultOne.add(value);			
				     }
				}
				for(int s=0;s<chrstr1.length;s++)
				{
					reqMap.put(chrstr1[s],chrstr2[s]);
				}
//				System.out.println(reqMap);
//				System.out.println();
//				System.out.println("**************************");
//				System.out.println(resultOne);	
				int resMsg = cheak(reqMap);
//				System.out.println("**************************");
				if(resMsg>0){
					fauleNum++;
				}else{
					succNum++;
				}
				System.out.println("成功:"+succNum+",失败:"+fauleNum);
			}			
			long time2 = System.currentTimeMillis();
			System.out.println("开始读取时间"+time2);
			long timeCha = time2-time1;			
			System.out.println("读取所需"+timeCha);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//校验字段是否合规
	private static int cheak(Map<String, String> reqMap) {
		// TODO Auto-generated method stub
		int flag = 0;
		String merName = reqMap.get("merName");
		boolean mName=merName.matches(RegexmerName);
		if(mName==false){
			flag++;
		}
		String merType = reqMap.get("merType");
		boolean mType=merType.matches(RegexmerType);
		if(mType==false){
			flag++;
		}
		String mobileNo = reqMap.get("mobileNo");
		boolean mbileNo=mobileNo.matches(RegexmerName);
		if(mbileNo==false){
			flag++;
		}
		String licenseType = reqMap.get("licenseType");
		boolean mlicType=licenseType.matches(RegexmerName);
		if(mlicType==false){
			flag++;
		}
		String organizationId = reqMap.get("organizationId");
		boolean morganizationId=organizationId.matches(RegexorganizationId);
		if(morganizationId==false){
			flag++;
		}
		String taxPayerNum = reqMap.get("taxPayerNum");
		boolean mtaxPayerNum=taxPayerNum.matches(RegextaxPayerNum);
		if(mtaxPayerNum==false){
			flag++;
		}
		String cardNo = reqMap.get("cardNo");
		boolean mcardNo=cardNo.matches(RegexcardNo);
		if(mcardNo==false){
			flag++;
		}
		String bankName = reqMap.get("bankName");
		boolean mbankName=bankName.matches(RegexbankName);
		if(mbankName==false){
			flag++;
		}
		String bankAccount = reqMap.get("bankAccount");
		boolean mbankAccount=bankAccount.matches(RegexbankAccount);
		if(mbankAccount==false){
			flag++;
		}
		String province = reqMap.get("province");
		boolean mprovince=province.matches(Regexprovince);
		if(mprovince==false){
			flag++;
		}
		String areaCode = reqMap.get("areaCode");
		boolean mareaCode=areaCode.matches(RegexareaCode);
		if(mareaCode==false){
			flag++;
		}
		String email = reqMap.get("email");
		boolean memail=email.matches(Regexemail);
		if(memail==false){
			flag++;
		}
		return flag;
	}
	
}
