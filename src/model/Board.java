package model;

public class Board {
	int boardId;
	int moneybagId;
	public String writer;
	public String title;
	public String content;
	int hit;
	String dateTime;
	
	public int getBoardId() {
		return boardId;
	}
	public void setBoardId(int boardId) {
		this.boardId = boardId;
	}
	public int getMoneybagId() {
		return moneybagId;
	}
	public void setMoneybagId(int moneybagId) {
		this.moneybagId = moneybagId;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	public String getDateTime() {
		return dateTime;
	}
	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}
	@Override
	public String toString() {
		return "Board [boardId=" + boardId + ", moneybagId=" + moneybagId + ", writer=" + writer + ", title=" + title + ", content=" + content
				+ ", hit=" + hit + ", dateTime=" + dateTime + "]";
	}
	
	
	
}
