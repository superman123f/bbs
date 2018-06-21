package com.xh.bbs.service;

import java.util.ArrayList;
import java.util.List;

import com.xh.bbs.dao.BbsDaoImpl;
import com.xh.bbs.dao.BbsDaoInf;
import com.xh.bbs.dao.UserDaoImpl;
import com.xh.bbs.dao.UserDaoInf;
import com.xh.bbs.entity.ForumEntity;
import com.xh.bbs.entity.ReplyEntity;
import com.xh.bbs.entity.UserEntity;

public class BbsServiceImpl implements BbsServiceInf{

	
	public List<ForumEntity> findForumList() {
		System.out.println("查询帖子列表");
		BbsDaoInf bbsDao = new BbsDaoImpl();
		UserDaoInf userDao = new UserDaoImpl(); 
	
		List<ForumEntity> forumList = bbsDao.findForumList();
	
		for (ForumEntity forumEntity : forumList) {
			int uid = forumEntity.getAuthor().getUser_id();
			UserEntity author = userDao.findUserById(uid);
			forumEntity.setAuthor(author);
			
			
		}
		System.out.println(forumList);
		return forumList;
	}

	//发表帖子
	public int createForum(ForumEntity forum) {
		BbsDaoInf bbsDao = new BbsDaoImpl();
		return bbsDao.addForum(forum);
	}


	public ForumEntity findReplyList(int fid) {
		BbsDaoInf bbsDao = new BbsDaoImpl();
		UserDaoInf userDao = new UserDaoImpl();
	
		ForumEntity forum = bbsDao.findForumById(fid);		
		UserEntity author = userDao.findUserById(forum.getAuthor().getUser_id());
			
		List<ReplyEntity> replyList = bbsDao.findReplyList(fid);
			
		for (ReplyEntity replyEntity : replyList) {
			UserEntity replyUser = userDao.findUserById(replyEntity.getUser().getUser_id());
			replyEntity.setUser(replyUser);
		}
		
		forum.setAuthor(author);
		forum.setReplyList(replyList);
		return forum;
	}

	//发表回复
	public int createReply(ReplyEntity reply) {
		BbsDaoInf dao = new BbsDaoImpl();
		return dao.addReply(reply);
	}
	
	//查询个人发帖
	public List<ForumEntity> personForum(int pid){
		BbsDaoInf dao=new BbsDaoImpl();
		List<ForumEntity> personList=new ArrayList<ForumEntity>();
		
		personList=dao.personForum(pid);
		
		return (personList==null)?null:personList;
	}
	
	//删除个人帖子
	public void deleteForumByFid(int fid){
		BbsDaoInf dao=new BbsDaoImpl();
		dao.deleteForum(fid);
	}
								
	//删除帖子的所有回复
	public void deleteReplyByFid(int fid){
		BbsDaoInf dao=new BbsDaoImpl();
		dao.deleteReply(fid);
	}
	
	//删除帖子下的某个用户的回帖
	public void deleteReplyByRid(int rid){
		BbsDaoInf dao=new BbsDaoImpl();
		dao.deleteReplyByRid(rid);
	}
			                      //管理员模块
	//删除用户（删除用户信息，发帖信息，回帖信息）
	public void dUserAllForumByUid(int uid){
		BbsDaoInf dao=new BbsDaoImpl();
		dao.dUserAllforumByUid(uid);
	}
	
	//删除该用户所有回帖
	public void dUserAllreplyByUid(int uid){
		BbsDaoInf dao=new BbsDaoImpl();
		dao.dUserAllreplyByUid(uid);
	}
	
	//删除用户帖子下的所有回帖
	public void dUserOtherRelyByFid(int uid){
		BbsDaoInf dao=new BbsDaoImpl();
		dao.dUserOtherRelyByFid(uid);
	}
	
	//查看单个用户发帖情况
	public List<ForumEntity> seeUserForumList(int uid){
		BbsDaoInf dao=new BbsDaoImpl();
		List<ForumEntity> forum=dao.personForum(uid);	
		return forum;
	}
}
