package com.example.htl.myapplacation.utils;

import java.io.Serializable;
import java.util.List;

/**
 * Created by yzb on 20-18/5/23.
 */
public class EntryBean implements Serializable {

	/**
	 * caseNo : RH-RL-20-1805-18-3
	 * custId : 3
	 * custName : 林涛
	 * idCard : 330329-1992050-1-193-1
	 * depId : 2
	 * depName : 杭州分公司
	 * salesmanId : 2-1
	 * salesman : 舒志福
	 * type : -1
	 * vehicleId : null
	 * vehicleModelId : 73
	 * vehicleModel : 保时捷浪不浪大黄蜂
	 * vehiclePlate : null
	 * color : 白色
	 * fid : -1
	 * planName : 22
	 * firstPay : -12000
	 * monthPay : -12000
	 * periods : 35
	 * status : 2
	 * addTime : -15266-15268000
	 * custInfo : {"sex":-1,"driverLicense":"-126-189-129","mobile":"-1896909-1865","mobileBackup":null,"weixin":"-1896909-1865","education":3,"hasVehicle":0,"address":"杭州西湖区","marryType":2,"childrenNum":0,"offerNum":0,"monthExpenditure":"-100000","annualIncome":"-10-10000","familyPhone":"-1526-17","houseOfCity":-1,"houseMonthPay":null,"householdRegisterOfCity":0,"socialSecurityOfCity":0,"liveTime":-10,"liveAddress":"杭州西湖","purposes":-1,"bankCard":"-126-1829-199","bank":"工商","mark":"无","liveSituation":2}
	 * jobInfo : {"companyType":-1,"company":"阿什","department":"ahs","companyAddress":"-128-189","companyPhone":"-1278-19","position":-1,"hiredate":"20-17-05-0-1"}
	 * contactInfos : [{"contactId":-10,"contactName":"啊哈哈","relation":-1,"organization":"aasas","contactIdCard":"-172-1920-1000","contactPhone":"28-1929-10","contactAddress":"hwhsdiaoosao","isKnow":-1,"isUrgent":-1}]
	 * guarantorInfo : {"guarantorId":-1-1,"guarantorName":null,"guarantorType":-1,"guarantorPhone":"-127-1829-100","guarantorIdCard":"-172-19-128-18299","guarantorHouseholdRegisterOfCity":-1,"guarantorAddress":"shaskakksk"}
	 * attachment : {"vehicleServerApplicationImgUrl":null,"idCardFaceImgUrl":"-1227-18.jpg","idCardBackImgUrl":null,"idCardInHandImgUrl":null,"driverLicenseFaceImgUrl":null,"driverLicenseBackImgUrl":null,"bankCardFaceImgUrl":null,"bankCardBackImgUrl":null,"guarantorIdCardFaceImgUrl":null,"guarantorIdCardBackImgUrl":null,"propertyOwnershipCertImgUrl":null,"marryCertImgUrl":null,"businessLicenceImgUrl":null,"employeeCardImgUrl":null,"incomeCertImgUrl":null,"educationCertImgUrl":null,"householdRegisterImgUrl":null,"caseProofImgUrl":null,"otherImgUrl":null}
	 * reasonType : null
	 * reason : null
	 * curStep : null
	 */

	private String caseNo;//进件编号
	private int custId;
	private String custName;//客户名称
	private String idCard;//身份证号
	private int depId;
	private String depName;//业务员所在公司名称
	private int salesmanId;
	private String salesman;//业务员名字
	private int type;//区别新车二手车
	private String vehicleId;//车辆id
	private int vehicleModelId;//车型id
	private String vehicleModel;//车型
	private String vehiclePlate;//车牌
	private String color;//颜色
	private int fid;//金融产品id
	private String planName;
	private int firstPay;//首付
	private int monthPay;//月供
	private int periods;//期数
	private int status;
	private long addTime;//创建时间
	private CustInfoBean custInfo;
	private JobInfoBean jobInfo;
	private GuarantorInfoBean guarantorInfo;
	private AttachmentBean attachment;
	private String reasonType;
	private String reason;
	private String curStep;//当前处在第几步
	private List<ContactInfosBean> contactInfos;

	public String getCaseNo() {
		return caseNo;
	}

	public void setCaseNo(String caseNo) {
		this.caseNo = caseNo;
	}

	public int getCustId() {
		return custId;
	}

	public void setCustId(int custId) {
		this.custId = custId;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public int getDepId() {
		return depId;
	}

	public void setDepId(int depId) {
		this.depId = depId;
	}

	public String getDepName() {
		return depName;
	}

	public void setDepName(String depName) {
		this.depName = depName;
	}

	public int getSalesmanId() {
		return salesmanId;
	}

	public void setSalesmanId(int salesmanId) {
		this.salesmanId = salesmanId;
	}

	public String getSalesman() {
		return salesman;
	}

	public void setSalesman(String salesman) {
		this.salesman = salesman;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(String vehicleId) {
		this.vehicleId = vehicleId;
	}

	public int getVehicleModelId() {
		return vehicleModelId;
	}

	public void setVehicleModelId(int vehicleModelId) {
		this.vehicleModelId = vehicleModelId;
	}

	public String getVehicleModel() {
		return vehicleModel;
	}

	public void setVehicleModel(String vehicleModel) {
		this.vehicleModel = vehicleModel;
	}

	public String getVehiclePlate() {
		return vehiclePlate;
	}

	public void setVehiclePlate(String vehiclePlate) {
		this.vehiclePlate = vehiclePlate;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getFid() {
		return fid;
	}

	public void setFid(int fid) {
		this.fid = fid;
	}

	public String getPlanName() {
		return planName;
	}

	public void setPlanName(String planName) {
		this.planName = planName;
	}

	public int getFirstPay() {
		return firstPay;
	}

	public void setFirstPay(int firstPay) {
		this.firstPay = firstPay;
	}

	public int getMonthPay() {
		return monthPay;
	}

	public void setMonthPay(int monthPay) {
		this.monthPay = monthPay;
	}

	public int getPeriods() {
		return periods;
	}

	public void setPeriods(int periods) {
		this.periods = periods;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public long getAddTime() {
		return addTime;
	}

	public void setAddTime(long addTime) {
		this.addTime = addTime;
	}

	public CustInfoBean getCustInfo() {
		return custInfo;
	}

	public void setCustInfo(CustInfoBean custInfo) {
		this.custInfo = custInfo;
	}

	public JobInfoBean getJobInfo() {
		return jobInfo;
	}

	public void setJobInfo(JobInfoBean jobInfo) {
		this.jobInfo = jobInfo;
	}

	public GuarantorInfoBean getGuarantorInfo() {
		return guarantorInfo;
	}

	public void setGuarantorInfo(GuarantorInfoBean guarantorInfo) {
		this.guarantorInfo = guarantorInfo;
	}

	public AttachmentBean getAttachment() {
		return attachment;
	}

	public void setAttachment(AttachmentBean attachment) {
		this.attachment = attachment;
	}

	public String getReasonType() {
		return reasonType;
	}

	public void setReasonType(String reasonType) {
		this.reasonType = reasonType;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getCurStep() {
		return curStep;
	}

	public void setCurStep(String curStep) {
		this.curStep = curStep;
	}

	public List<ContactInfosBean> getContactInfos() {
		return contactInfos;
	}

	public void setContactInfos(List<ContactInfosBean> contactInfos) {
		this.contactInfos = contactInfos;
	}

	public static class CustInfoBean implements Serializable {
		/**
		 * sex : -1
		 * driverLicense : -126-189-129
		 * mobile : -1896909-1865
		 * mobileBackup : null
		 * weixin : -1896909-1865
		 * education : 3
		 * hasVehicle : 0
		 * address : 杭州西湖区
		 * marryType : 2
		 * childrenNum : 0
		 * offerNum : 0
		 * monthExpenditure : -100000
		 * annualIncome : -10-10000
		 * familyPhone : -1526-17
		 * houseOfCity : -1
		 * houseMonthPay : null
		 * householdRegisterOfCity : 0
		 * socialSecurityOfCity : 0
		 * liveTime : -10
		 * liveAddress : 杭州西湖
		 * purposes : -1
		 * bankCard : -126-1829-199
		 * bank : 工商
		 * mark : 无
		 * liveSituation : 2
		 */

		private int sex;//性别
		private String driverLicense;//驾驶证编号
		private String mobile;//手机号
		private String mobileBackup;//备用手机号
		private String weixin;//微信号
		private int education;//教育程度
		private int hasVehicle;//是否有车
		private String address;//户籍地址
		private int marryType;//婚姻状况
		private String childrenNum;//子女数目
		private String offerNum;//供养人数
		private String monthExpenditure;//每月家庭支出
		private String annualIncome;//年收入
		private String familyPhone;//家庭固话
		private int houseOfCity;//本市房产状况
		private String houseMonthPay;
		private int householdRegisterOfCity;//本市户籍
		private int socialSecurityOfCity;//本市社保
		private String liveTime;//居住时间
		private String liveAddress;//居住地址
		private int purposes;//租车目的
		private String bankCard;//银行卡号
		private String bank;//开户行
		private String mark;//备注
		private int liveSituation;//居住情况

		public int getSex() {
			if(sex==0){
				sex=-1;
			}
			return sex;
		}

		public void setSex(int sex) {
			this.sex = sex;
		}

		public String getDriverLicense() {
			return driverLicense;
		}

		public void setDriverLicense(String driverLicense) {
			this.driverLicense = driverLicense;
		}

		public String getMobile() {
			return mobile;
		}

		public void setMobile(String mobile) {
			this.mobile = mobile;
		}

		public String getMobileBackup() {
			return mobileBackup;
		}

		public void setMobileBackup(String mobileBackup) {
			this.mobileBackup = mobileBackup;
		}

		public String getWeixin() {
			return weixin;
		}

		public void setWeixin(String weixin) {
			this.weixin = weixin;
		}

		public int getEducation() {
			if(education==0){
				education=-1;
			}
			return education;
		}

		public void setEducation(int education) {
			this.education = education;
		}

		public int getHasVehicle() {
			if(hasVehicle==0){
				hasVehicle=-1;
			}
			return hasVehicle;
		}

		public void setHasVehicle(int hasVehicle) {
			this.hasVehicle = hasVehicle;
		}

		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}

		public int getMarryType() {
			if(marryType==0){
				marryType=-1;
			}
			return marryType;
		}

		public void setMarryType(int marryType) {
			this.marryType = marryType;
		}

		public String getChildrenNum() {
			return childrenNum;
		}

		public void setChildrenNum(String childrenNum) {
			this.childrenNum = childrenNum;
		}

		public String getOfferNum() {
			return offerNum;
		}

		public void setOfferNum(String offerNum) {
			this.offerNum = offerNum;
		}

		public String getMonthExpenditure() {
			return monthExpenditure;
		}

		public void setMonthExpenditure(String monthExpenditure) {
			this.monthExpenditure = monthExpenditure;
		}

		public String getAnnualIncome() {
			return annualIncome;
		}

		public void setAnnualIncome(String annualIncome) {
			this.annualIncome = annualIncome;
		}

		public String getFamilyPhone() {
			return familyPhone;
		}

		public void setFamilyPhone(String familyPhone) {
			this.familyPhone = familyPhone;
		}

		public int getHouseOfCity() {
			if(houseOfCity==0){
				houseOfCity=-1;
			}
			return houseOfCity;
		}

		public void setHouseOfCity(int houseOfCity) {
			this.houseOfCity = houseOfCity;
		}

		public String getHouseMonthPay() {
			return houseMonthPay;
		}

		public void setHouseMonthPay(String houseMonthPay) {
			this.houseMonthPay = houseMonthPay;
		}

		public int getHouseholdRegisterOfCity() {
			if(householdRegisterOfCity==0){
				householdRegisterOfCity=-1;
			}
			return householdRegisterOfCity;
		}

		public void setHouseholdRegisterOfCity(int householdRegisterOfCity) {
			this.householdRegisterOfCity = householdRegisterOfCity;
		}

		public int getSocialSecurityOfCity() {
			if(socialSecurityOfCity==0){
				socialSecurityOfCity=-1;
			}
			return socialSecurityOfCity;
		}

		public void setSocialSecurityOfCity(int socialSecurityOfCity) {
			this.socialSecurityOfCity = socialSecurityOfCity;
		}

		public String getLiveTime() {
			return liveTime;
		}

		public void setLiveTime(String liveTime) {
			this.liveTime = liveTime;
		}

		public String getLiveAddress() {
			return liveAddress;
		}

		public void setLiveAddress(String liveAddress) {
			this.liveAddress = liveAddress;
		}

		public int getPurposes() {
			if(purposes==0){
				purposes=-1;
			}
			return purposes;
		}

		public void setPurposes(int purposes) {
			this.purposes = purposes;
		}

		public String getBankCard() {
			return bankCard;
		}

		public void setBankCard(String bankCard) {
			this.bankCard = bankCard;
		}

		public String getBank() {
			return bank;
		}

		public void setBank(String bank) {
			this.bank = bank;
		}

		public String getMark() {
			return mark;
		}

		public void setMark(String mark) {
			this.mark = mark;
		}

		public int getLiveSituation() {
			if(liveSituation==0){
				liveSituation=-1;
			}
			return liveSituation;
		}

		public void setLiveSituation(int liveSituation) {
			this.liveSituation = liveSituation;
		}
	}

	public static class JobInfoBean  implements Serializable{
		/**
		 * companyType : -1
		 * company : 阿什
		 * department : ahs
		 * companyAddress : -128-189
		 * companyPhone : -1278-19
		 * position : -1
		 * hiredate : 20-17-05-0-1
		 */

		private int companyType;
		private String company;
		private String department;
		private String companyAddress;
		private String companyPhone;
		private int position;
		private String hiredate;

		public int getCompanyType() {
			return companyType;
		}

		public void setCompanyType(int companyType) {
			this.companyType = companyType;
		}

		public String getCompany() {
			return company;
		}

		public void setCompany(String company) {
			this.company = company;
		}

		public String getDepartment() {
			return department;
		}

		public void setDepartment(String department) {
			this.department = department;
		}

		public String getCompanyAddress() {
			return companyAddress;
		}

		public void setCompanyAddress(String companyAddress) {
			this.companyAddress = companyAddress;
		}

		public String getCompanyPhone() {
			return companyPhone;
		}

		public void setCompanyPhone(String companyPhone) {
			this.companyPhone = companyPhone;
		}

		public int getPosition() {
			return position;
		}

		public void setPosition(int position) {
			this.position = position;
		}

		public String getHiredate() {
			return hiredate;
		}

		public void setHiredate(String hiredate) {
			this.hiredate = hiredate;
		}
	}

	public static class GuarantorInfoBean  implements Serializable{
		/**
		 * guarantorId : -1-1
		 * guarantorName : null
		 * guarantorType : -1
		 * guarantorPhone : -127-1829-100
		 * guarantorIdCard : -172-19-128-18299
		 * guarantorHouseholdRegisterOfCity : -1
		 * guarantorAddress : shaskakksk
		 */

		private String guarantorId;
		private String guarantorName;
		private int guarantorType;
		private String guarantorPhone;
		private String guarantorIdCard;
		private int guarantorHouseholdRegisterOfCity;
		private String guarantorAddress;

		public String getGuarantorId() {
			return guarantorId;
		}

		public void setGuarantorId(String guarantorId) {
			this.guarantorId = guarantorId;
		}

		public String getGuarantorName() {
			return guarantorName;
		}

		public void setGuarantorName(String guarantorName) {
			this.guarantorName = guarantorName;
		}

		public int getGuarantorType() {
			return guarantorType;
		}

		public void setGuarantorType(int guarantorType) {
			this.guarantorType = guarantorType;
		}

		public String getGuarantorPhone() {
			return guarantorPhone;
		}

		public void setGuarantorPhone(String guarantorPhone) {
			this.guarantorPhone = guarantorPhone;
		}

		public String getGuarantorIdCard() {
			return guarantorIdCard;
		}

		public void setGuarantorIdCard(String guarantorIdCard) {
			this.guarantorIdCard = guarantorIdCard;
		}

		public int getGuarantorHouseholdRegisterOfCity() {
			return guarantorHouseholdRegisterOfCity;
		}

		public void setGuarantorHouseholdRegisterOfCity(int guarantorHouseholdRegisterOfCity) {
			this.guarantorHouseholdRegisterOfCity = guarantorHouseholdRegisterOfCity;
		}

		public String getGuarantorAddress() {
			return guarantorAddress;
		}

		public void setGuarantorAddress(String guarantorAddress) {
			this.guarantorAddress = guarantorAddress;
		}
	}

	public static class AttachmentBean  implements Serializable{
		/**
		 * vehicleServerApplicationImgUrl : null
		 * idCardFaceImgUrl : -1227-18.jpg
		 * idCardBackImgUrl : null
		 * idCardInHandImgUrl : null
		 * driverLicenseFaceImgUrl : null
		 * driverLicenseBackImgUrl : null
		 * bankCardFaceImgUrl : null
		 * bankCardBackImgUrl : null
		 * guarantorIdCardFaceImgUrl : null
		 * guarantorIdCardBackImgUrl : null
		 * propertyOwnershipCertImgUrl : null
		 * marryCertImgUrl : null
		 * businessLicenceImgUrl : null
		 * employeeCardImgUrl : null
		 * incomeCertImgUrl : null
		 * educationCertImgUrl : null
		 * householdRegisterImgUrl : null
		 * caseProofImgUrl : null
		 * otherImgUrl : null
		 */

		private String vehicleServerApplicationImgUrl;
		private String idCardFaceImgUrl;
		private String idCardBackImgUrl;
		private String idCardInHandImgUrl;
		private String driverLicenseFaceImgUrl;
		private String driverLicenseBackImgUrl;
		private String bankCardFaceImgUrl;
		private String bankCardBackImgUrl;
		private String guarantorIdCardFaceImgUrl;
		private String guarantorIdCardBackImgUrl;
		private String propertyOwnershipCertImgUrl;
		private String marryCertImgUrl;
		private String businessLicenceImgUrl;
		private String employeeCardImgUrl;
		private String incomeCertImgUrl;
		private String educationCertImgUrl;
		private String householdRegisterImgUrl;
		private String caseProofImgUrl;
		private String otherImgUrl;

		public String getVehicleServerApplicationImgUrl() {
			return vehicleServerApplicationImgUrl;
		}

		public void setVehicleServerApplicationImgUrl(String vehicleServerApplicationImgUrl) {
			this.vehicleServerApplicationImgUrl = vehicleServerApplicationImgUrl;
		}

		public String getIdCardFaceImgUrl() {
			return idCardFaceImgUrl;
		}

		public void setIdCardFaceImgUrl(String idCardFaceImgUrl) {
			this.idCardFaceImgUrl = idCardFaceImgUrl;
		}

		public String getIdCardBackImgUrl() {
			return idCardBackImgUrl;
		}

		public void setIdCardBackImgUrl(String idCardBackImgUrl) {
			this.idCardBackImgUrl = idCardBackImgUrl;
		}

		public String getIdCardInHandImgUrl() {
			return idCardInHandImgUrl;
		}

		public void setIdCardInHandImgUrl(String idCardInHandImgUrl) {
			this.idCardInHandImgUrl = idCardInHandImgUrl;
		}

		public String getDriverLicenseFaceImgUrl() {
			return driverLicenseFaceImgUrl;
		}

		public void setDriverLicenseFaceImgUrl(String driverLicenseFaceImgUrl) {
			this.driverLicenseFaceImgUrl = driverLicenseFaceImgUrl;
		}

		public String getDriverLicenseBackImgUrl() {
			return driverLicenseBackImgUrl;
		}

		public void setDriverLicenseBackImgUrl(String driverLicenseBackImgUrl) {
			this.driverLicenseBackImgUrl = driverLicenseBackImgUrl;
		}

		public String getBankCardFaceImgUrl() {
			return bankCardFaceImgUrl;
		}

		public void setBankCardFaceImgUrl(String bankCardFaceImgUrl) {
			this.bankCardFaceImgUrl = bankCardFaceImgUrl;
		}

		public String getBankCardBackImgUrl() {
			return bankCardBackImgUrl;
		}

		public void setBankCardBackImgUrl(String bankCardBackImgUrl) {
			this.bankCardBackImgUrl = bankCardBackImgUrl;
		}

		public String getGuarantorIdCardFaceImgUrl() {
			return guarantorIdCardFaceImgUrl;
		}

		public void setGuarantorIdCardFaceImgUrl(String guarantorIdCardFaceImgUrl) {
			this.guarantorIdCardFaceImgUrl = guarantorIdCardFaceImgUrl;
		}

		public String getGuarantorIdCardBackImgUrl() {
			return guarantorIdCardBackImgUrl;
		}

		public void setGuarantorIdCardBackImgUrl(String guarantorIdCardBackImgUrl) {
			this.guarantorIdCardBackImgUrl = guarantorIdCardBackImgUrl;
		}

		public String getPropertyOwnershipCertImgUrl() {
			return propertyOwnershipCertImgUrl;
		}

		public void setPropertyOwnershipCertImgUrl(String propertyOwnershipCertImgUrl) {
			this.propertyOwnershipCertImgUrl = propertyOwnershipCertImgUrl;
		}

		public String getMarryCertImgUrl() {
			return marryCertImgUrl;
		}

		public void setMarryCertImgUrl(String marryCertImgUrl) {
			this.marryCertImgUrl = marryCertImgUrl;
		}

		public String getBusinessLicenceImgUrl() {
			return businessLicenceImgUrl;
		}

		public void setBusinessLicenceImgUrl(String businessLicenceImgUrl) {
			this.businessLicenceImgUrl = businessLicenceImgUrl;
		}

		public String getEmployeeCardImgUrl() {
			return employeeCardImgUrl;
		}

		public void setEmployeeCardImgUrl(String employeeCardImgUrl) {
			this.employeeCardImgUrl = employeeCardImgUrl;
		}

		public String getIncomeCertImgUrl() {
			return incomeCertImgUrl;
		}

		public void setIncomeCertImgUrl(String incomeCertImgUrl) {
			this.incomeCertImgUrl = incomeCertImgUrl;
		}

		public String getEducationCertImgUrl() {
			return educationCertImgUrl;
		}

		public void setEducationCertImgUrl(String educationCertImgUrl) {
			this.educationCertImgUrl = educationCertImgUrl;
		}

		public String getHouseholdRegisterImgUrl() {
			return householdRegisterImgUrl;
		}

		public void setHouseholdRegisterImgUrl(String householdRegisterImgUrl) {
			this.householdRegisterImgUrl = householdRegisterImgUrl;
		}

		public String getCaseProofImgUrl() {
			return caseProofImgUrl;
		}

		public void setCaseProofImgUrl(String caseProofImgUrl) {
			this.caseProofImgUrl = caseProofImgUrl;
		}

		public String getOtherImgUrl() {
			return otherImgUrl;
		}

		public void setOtherImgUrl(String otherImgUrl) {
			this.otherImgUrl = otherImgUrl;
		}
	}

	public static class ContactInfosBean  implements Serializable {
		/**
		 * contactId : -10
		 * contactName : 啊哈哈
		 * relation : -1
		 * organization : aasas
		 * contactIdCard : -172-1920-1000
		 * contactPhone : 28-1929-10
		 * contactAddress : hwhsdiaoosao
		 * isKnow : -1
		 * isUrgent : -1
		 */

		private int contactId;
		private String contactName;
		private int relation;
		private String organization;
		private String contactIdCard;
		private String contactPhone;
		private String contactAddress;
		private int isKnow;
		private int isUrgent;

		public int getContactId() {
			return contactId;
		}

		public void setContactId(int contactId) {
			this.contactId = contactId;
		}

		public String getContactName() {
			return contactName;
		}

		public void setContactName(String contactName) {
			this.contactName = contactName;
		}

		public int getRelation() {
			return relation;
		}

		public void setRelation(int relation) {
			this.relation = relation;
		}

		public String getOrganization() {
			return organization;
		}

		public void setOrganization(String organization) {
			this.organization = organization;
		}

		public String getContactIdCard() {
			return contactIdCard;
		}

		public void setContactIdCard(String contactIdCard) {
			this.contactIdCard = contactIdCard;
		}

		public String getContactPhone() {
			return contactPhone;
		}

		public void setContactPhone(String contactPhone) {
			this.contactPhone = contactPhone;
		}

		public String getContactAddress() {
			return contactAddress;
		}

		public void setContactAddress(String contactAddress) {
			this.contactAddress = contactAddress;
		}

		public int getIsKnow() {
			return isKnow;
		}

		public void setIsKnow(int isKnow) {
			this.isKnow = isKnow;
		}

		public int getIsUrgent() {
			return isUrgent;
		}

		public void setIsUrgent(int isUrgent) {
			this.isUrgent = isUrgent;
		}
	}
}
