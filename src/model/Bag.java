package model;

public class Bag {

	int id;
	int adminId;
	String createdDate;
	String account;
	String info;
	String fileName;

	Bag(int adminId, String account) {
		this.adminId = adminId;
		this.account = account;
	}

	Bag(int adminId, String account, String info) {
		this.adminId = adminId;
		this.account = account;
		this.info = info;
	}

	Bag(int adminId, String account, String info, String picture) {
		this.adminId = adminId;
		this.account = account;
		this.info = info;
		this.fileName = picture;
	}

	public Bag() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAdminId() {
		return adminId;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public String getfileName() {
		return fileName;
	}

	public void setFileName(String picture) {
		this.fileName = picture;
	}

	@Override
	public String toString() {
		return "Bag [id=" + id + ", adminId=" + adminId + ", createdDate="
				+ createdDate + ", account=" + account + ", info=" + info
				+ ", fileName=" + fileName + "]";
	}

}
