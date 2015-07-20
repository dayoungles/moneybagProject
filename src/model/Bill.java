package model;

public class Bill {
	int bill_id;// billId로 하면 구분이 안돼서 ㅋㅋ카멜표기 안함  
	int moneybagId;
	String billName;
	String createdDate;
	String info;
	String fileName;
	int usedMoney;
	
	public Bill(){
		
	}

	public Bill(String billName2, String usedMoney2, String info2, int parseInt) {
		this.billName = billName2;
		this.moneybagId = parseInt;
		this.usedMoney = Integer.parseInt(usedMoney2);//앞단에서 인티저로 줄 것. 
		this.info = info2;
	}

	public int getUsedMoney() {
		return usedMoney;
	}

	public void setUsedMoney(int usedMoney) {
		this.usedMoney = usedMoney;
	}

	public int getBill_id() {
		return bill_id;
	}

	public void setBill_id(int bill_Id) {
		this.bill_id = bill_Id;
	}

	public int getMoneybagId() {
		return moneybagId;
	}

	public void setMoneybagId(int moneybagId) {
		this.moneybagId = moneybagId;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}


	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public String getBillName() {
		return billName;
	}

	public void setBillName(String billName) {
		this.billName = billName;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	@Override
	public String toString() {
		return "Bill [bill_id=" + bill_id + ", moneybagId=" + moneybagId
				+ ", billName=" + billName + ", createdDate=" + createdDate
				+ ", info=" + info + ", fileName=" + fileName + ", usedMoney="
				+ usedMoney + "]";
	}


}
