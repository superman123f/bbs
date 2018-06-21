package com.xh.bbs.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * 用户实体类
 */
public class UserEntity {

//	private String user_id;
	private int user_id;
	private String user_name;
	private String user_password;
	private String user_sex;
	private String user_face;
	private String user_phone;
	private String user_email;
	private String user_from;
	private int isAdmin;
	
	
	// 关联回复信息,一对多的关联
	private List<ReplyEntity> replyList = new ArrayList<ReplyEntity>();
	// 和帖子进行关联,一对多
	private List<ForumEntity> forumList = new ArrayList<ForumEntity>();
	
	
	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getUser_password() {
		return user_password;
	}

	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}

	public String getUser_sex() {
		return user_sex;
	}

	public void setUser_sex(String user_sex) {
		this.user_sex = user_sex;
	}

	public String getUser_face() {
		return user_face;
	}

	public void setUser_face(String user_face) {
		this.user_face = user_face;
	}

	public String getUser_phone() {
		return user_phone;
	}

	public void setUser_phone(String user_phone) {
		this.user_phone = user_phone;
	}

	public String getUser_email() {
		return user_email;
	}

	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}

	public String getUser_from() {
		return user_from;
	}

	public void setUser_from(String user_from) {
		this.user_from = user_from;
	}
	
	

	public int getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(int isAdmin) {
		this.isAdmin = isAdmin;
	}

	public List<ReplyEntity> getReplyList() {
		return replyList;
	}

	public void setReplyList(List<ReplyEntity> replyList) {
		this.replyList = replyList;
	}

	public List<ForumEntity> getForumList() {
		return forumList;
	}

	public void setForumList(List<ForumEntity> forumList) {
		this.forumList = forumList;
	}

}
