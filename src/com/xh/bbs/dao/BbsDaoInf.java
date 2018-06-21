package com.xh.bbs.dao;

import java.util.List;

import com.xh.bbs.entity.ForumEntity;
import com.xh.bbs.entity.ReplyEntity;

public interface BbsDaoInf {

	//查询所有帖子
	public List<ForumEntity> findForumList();
	
	//根据ID查询某个帖子
	public ForumEntity findForumById(int id);
	
	//添加帖子
	public int addForum(ForumEntity forum);
		
	//根据帖子的ID查询所有回复
	public List<ReplyEntity> findReplyList(int fid);
	
	//添加回复
	public int addReply(ReplyEntity reply);
	
	//根据用户ID查询用户的所有发帖
	public List<ForumEntity> personForum(int uid);
	
	//用户删除个人某个帖子
	public void deleteForum(int fid);
	
	//根据帖子id删除所有回复
	public void deleteReply(int fid);
	
	//用户删除某个回帖
	public void deleteReplyByRid(int rid);
	
									//用户管理模块
	//删除用户所有发帖
	public void dUserAllforumByUid(int uid);
	
	//删除该用户所有回帖
	public void dUserAllreplyByUid(int uid);
	
	//删除用户帖子下的所有回帖
	public void dUserOtherRelyByFid(int uid);
	

}
