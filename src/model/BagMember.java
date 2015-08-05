package model;

import java.util.ArrayList;

public class BagMember {
	String[] userIdList;
	int memberNum;
	ArrayList<User> memberList = new ArrayList<User>();
	
	public BagMember() {
		
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
	
	public void setMemberList(ArrayList<User> memberList){
		this.memberList = memberList;
	}
	
	public ArrayList<User> getMemberList(){
		return this.memberList;
	}
}
