package model;

import java.util.ArrayList;

public class BagMember {
	String[] userIdList;
	int memberNum;
	
	public BagMember(String userIdList, int adminId) {
		userIdList = addAdminToList(userIdList, adminId);
		setUserIdList(userIdList);
		
	}

	private String addAdminToList(String userIdList, int adminId) {
		userIdList+=adminId;
		return userIdList;
	}

	public void setUserIdList(String userIdList){
		this.userIdList = userIdList.split(",");
		setMemberNum();
	}
	
	public String[] getUserIds() {
		return userIdList;
	}
	
	public void setMemberNum(){
		this.memberNum = this.userIdList.length;
	}
	
	public int getMemberNum() {
		return this.memberNum;
	}
	

}
