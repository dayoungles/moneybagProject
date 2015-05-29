package model;

public class Round {
	int roundId;
	int moneybagId;
	String createdDate;
	int total;
	String info;
	boolean nBang;
	
	public int getRoundId() {
		return roundId;
	}
	public void setRoundId(int roundId) {
		this.roundId = roundId;
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
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public boolean isnBang() {
		return nBang;
	}
	public void setnBang(boolean nBang) {
		this.nBang = nBang;
	}
	
	
}
