package model;

public class Board {
	int boardId;
	int moneybagId;
	public int writerId;
	public String title;
	public String content;
	int hits;
	String time;
	
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
	public int getWriterId() {
		return writerId;
	}
	public void setWriterId(int writer) {
		this.writerId = writer;
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
	public int getHits() {
		return hits;
	}
	public void setHits(int hit) {
		this.hits = hit;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String dateTime) {
		this.time = dateTime;
	}
	@Override
	public String toString() {
		return "Board [boardId=" + boardId + ", moneybagId=" + moneybagId + ", writer=" + writerId + ", title=" + title + ", content=" + content
				+ ", hits=" + hits + ", time=" + time + "]";
	}
	
	
	
}
