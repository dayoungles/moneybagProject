package model;

public class UserMapping {
	int userId;
	int moneybagId;

	public UserMapping() {

	}

	public UserMapping(int userId, int moneybagId) {
		this.userId = userId;
		this.moneybagId = moneybagId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getMoneybagId() {
		return moneybagId;
	}

	public void setMoneybagId(int moneybagId) {
		this.moneybagId = moneybagId;
	}

}
