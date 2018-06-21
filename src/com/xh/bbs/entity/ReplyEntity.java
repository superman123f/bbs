package com.xh.bbs.entity;

import java.sql.Timestamp;
/** 回贴实体类 */
public class ReplyEntity {

	private int rid;
	private String content;
	private Timestamp replyTime;
	// 回复人,多对一的关联
	private UserEntity user = new UserEntity();
	// 多对一关联
	private ForumEntity forum = new ForumEntity();

	public int getRid() {
		return rid;
	}

	public void setRid(int rid) {
		this.rid = rid;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Timestamp getReplyTime() {
		return replyTime;
	}

	public void setReplyTime(Timestamp replyTime) {
		this.replyTime = replyTime;
	}

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}

	public ForumEntity getForum() {
		return forum;
	}

	public void setForum(ForumEntity forum) {
		this.forum = forum;
	}

}
