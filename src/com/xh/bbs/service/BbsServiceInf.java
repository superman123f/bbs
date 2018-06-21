package com.xh.bbs.service;

import java.util.List;

import com.xh.bbs.entity.ForumEntity;
import com.xh.bbs.entity.ReplyEntity;

public interface BbsServiceInf {

	//查询帖子列表
	public List<ForumEntity> findForumList();
	
	//发表帖子
	public int createForum(ForumEntity forum);
	
	//查询帖子对应的回复
	public ForumEntity findReplyList(int fid);
	
	//发表回复
	public int createReply(ReplyEntity reply);
	
	//查询个人发帖
	public List<ForumEntity> personForum(int pid);
	
	//删除个人帖子
	public void deleteForumByFid(int fid);
	
	//删除帖子的所有回复
	public void deleteReplyByFid(int fid);
	
	//删除帖子下的某个用户的回帖
	public void deleteReplyByRid(int rid);
	
	
	
												//用户管理模块
	//删除用户的所有发帖
	public void dUserAllForumByUid(int uid);
	
	//删除该用户所有回帖
	public void dUserAllreplyByUid(int uid);
	
	//删除用户帖子下的所有回帖
	public void dUserOtherRelyByFid(int uid);
	
	//查看单个用户发帖情况
	public List<ForumEntity> seeUserForumList(int uid);
	
}
