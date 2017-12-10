package excle.drdc;

public class RegexReadExcle {
	
/*			Regex.sign_type=RSA
			Regex.merId=\\d{1,8}
			Regex.version=4.0

			Regex.merName=^\\S[\\s\\S]{1,16}$
			Regex.merType=1|2
			Regex.contActsName=^[\u4e00-\u9fa5a-zA-Z\.\s]{1,16}$
			Regex.mobileNo=^[0-9]{11}$
			Regex.licenseType=1|2
			Regex.saas.licenseNo=^[0-9]{15}$
			Regex.saas.licenseNos=^[0-9a-zA-Z]{18}$
			Regex.organizationId=^[0-9]{8}-[0-9]{1}$
			Regex.taxPayerNum=^[A-Za-z0-9]{1,20}$
			Regex.lawyer=^[\u4e00-\u9fa5a-zA-Z\.\s]{1,16}$
			Regex.cardNo=^[1-9]\\d{5}(18|19|([23]\\d))\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\\d{3}[0-9Xx]$
			Regex.bankName=^[\u4E00-\u9FA5]{2,64}$
			Regex.bankAccount=^[0-9]{1,28}$
			Regex.province=^[0-9]{3}$
			Regex.areaCode=^[0-9]{3}$
			Regex.email=^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$
			Regex.merNotifyUrl=.{1,128}】*/
	private String Regexemail = "";
	
	public static void main(String[] args) {
        System.out.println("********************");
        strMatch(); //字符串匹配
    }
	
    private static void strMatch() {
        String phone = "13539770000";
        //检查phone是否是合格的手机号(标准:1开头，第二位为3,5,8，后9位为任意数字)
        System.out.println(phone + ":" + phone.matches("1[358][0-9]{9,9}")); //true    
        
        String str = "abcd12345efghijklmn";
        //检查str中间是否包含12345
        System.out.println(str + ":" + str.matches("\\w+12345\\w+")); //true
        System.out.println(str + ":" + str.matches("\\w+123456\\w+")); //false
    }

}
