package excle.drdc;

import java.io.Serializable;

public class ChildWeb implements Serializable{
	
	private static final long serialVersionUID = 1L;
	/**
	 * <P> Description：</P>
	 * <P>---*---Founder：zhangqiang---*---Date：2017-9-1---*---Time：上午11:07:10---*--Antediluvian</P>
	 * Version:1.0
	 * <P> Modifier: Version:</P>
	 */
	private String merName;//商户名称
	private String merType;//商户类型
	private String contactsName;//联系人
	private String mobileNo;//联系人手机号
	private String licenseType;//是否三证合一
	private String licenseNo;//营业执照号 主键
	private String organizationId;//组织机构代码证
	private String taxPayerNum;//税务登记证
	
//	private String merId;//主商户编号 主键
//	private String subMerId;//子商户编号
//	private String appSysId;//应用编号
	
	/*开户许可证*/
	private String okCard;//开户许可证
	
	private String lawyer;//法人姓名
	private String cardNo;//法人身份证
	private String bankName;//银行名称
	
	/*账户名称*/
	/*账户类型*/
	private String accountName;//账户名称
	private String accountType;//账户类型
	
	private String bankAccount;//银行账号
	private String province;//开户省
	private String areaCode;//开户市
	
	/*起结金额*/
	/*结算周期*/
	private String minMoney;//起结金额
	private String cheakCycle;//结算周期
	
//	private String signState;//审核状态
	private String email;//邮箱
	public String[] setSit;
//	private String modTime;//更新时间
//	private String inTime;//入库时间
//	private String merNotifyUrl;//异步通知
//	private String modUser;//操作人
//	private String merGrade;//商户评级
	public String getLicenseNo() {
		return licenseNo;
	}
	public void setLicenseNo(String licenseNo) {
		this.licenseNo = licenseNo;
	}
	public String[] getSetSit() {
		return setSit;
	}
	public void setSetSit(String[] setSit) {
		this.setSit = setSit;
	}
	//	public String getMerId() {
//		return merId;
//	}
//	public void setMerId(String merId) {
//		this.merId = merId;
//	}
//	public String getSubMerId() {
//		return subMerId;
//	}
//	public void setSubMerId(String subMerId) {
//		this.subMerId = subMerId;
//	}
//	public String getAppSysId() {
//		return appSysId;
//	}
//	public void setAppSysId(String appSysId) {
//		this.appSysId = appSysId;
//	}
	public String getMerName() {
		return merName;
	}
	public void setMerName(String merName) {
		this.merName = merName;
	}
	public String seSit1(String merName) {
		// TODO Auto-generated method stub
		this.merName = merName;
		return merName;
	}
	public String getMerType() {
		return merType;
	}
	public void setMerType(String merType) {
		this.merType = merType;
	}
	public String getContactsName() {
		return contactsName;
	}
	public void setContactsName(String contactsName) {
		this.contactsName = contactsName;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getLicenseType() {
		return licenseType;
	}
	public void setLicenseType(String licenseType) {
		this.licenseType = licenseType;
	}
	public String getOrganizationId() {
		return organizationId;
	}
	public void setOrganizationId(String organizationId) {
		this.organizationId = organizationId;
	}
	public String getTaxPayerNum() {
		return taxPayerNum;
	}
	public void setTaxPayerNum(String taxPayerNum) {
		this.taxPayerNum = taxPayerNum;
	}
	public String getLawyer() {
		return lawyer;
	}
	public void setLawyer(String lawyer) {
		this.lawyer = lawyer;
	}
	public String getCardNo() {
		return cardNo;
	}
	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public String getBankAccount() {
		return bankAccount;
	}
	public void setBankAccount(String bankAccount) {
		this.bankAccount = bankAccount;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getAreaCode() {
		return areaCode;
	}
	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}
//	public String getSignState() {
//		return signState;
//	}
//	public void setSignState(String signState) {
//		this.signState = signState;
//	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
//	public String getModTime() {
//		return modTime;
//	}
//	public void setModTime(String modTime) {
//		this.modTime = modTime;
//	}
//	public String getInTime() {
//		return inTime;
//	}
//	public void setInTime(String inTime) {
//		this.inTime = inTime;
//	}
//	public String getMerNotifyUrl() {
//		return merNotifyUrl;
//	}
//	public void setMerNotifyUrl(String merNotifyUrl) {
//		this.merNotifyUrl = merNotifyUrl;
//	}
//	public String getModUser() {
//		return modUser;
//	}
//	public void setModUser(String modUser) {
//		this.modUser = modUser;
//	}
//	public String getMerGrade() {
//		return merGrade;
//	}
//	public void setMerGrade(String merGrade) {
//		this.merGrade = merGrade;
//	}
	public String getOkCard() {
		return okCard;
	}
	public void setOkCard(String okCard) {
		this.okCard = okCard;
	}
	public String getAccountName() {
		return accountName;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public String getMinMoney() {
		return minMoney;
	}
	public void setMinMoney(String minMoney) {
		this.minMoney = minMoney;
	}
	public String getCheakCycle() {
		return cheakCycle;
	}
	public void setCheakCycle(String cheakCycle) {
		this.cheakCycle = cheakCycle;
	}
		

}
