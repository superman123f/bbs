package com.xh.bbs.service;

import java.util.List;

import com.xh.bbs.dao.UserDaoImpl;
import com.xh.bbs.dao.UserDaoInf;
import com.xh.bbs.entity.UserEntity;

public class UserServiceImpl implements UserServiceInf{

	public UserEntity login(String userId, String passwd) {
		//调用dao做用户的查询
		UserDaoInf userDao = new UserDaoImpl();
		UserEntity user = userDao.findUser(userId, passwd);
		return (user==null) ? null : user;
	}

	public int saveUser(UserEntity user) {
		//调用dao保存用户
		UserDaoInf userDao = new UserDaoImpl();
		return userDao.addUser(user);
	}
	
		//调用Dao删除用户
	public void deleteUser(int uid){
		UserDaoInf user=new UserDaoImpl();
		user.deleteUser(uid);
	}
	
	public void updateUser(UserEntity user){
		UserDaoInf userdao=new UserDaoImpl();
		userdao.updateUser(user);
	}
	
	public UserEntity findUser(int uid){
		UserDaoInf userDao=new UserDaoImpl();
		UserEntity user=userDao.findUserById(uid);
		return (user==null)?null:user;
	}
	
	public List<UserEntity> findUserList(){
		UserDaoInf userDao=new UserDaoImpl();
		
		List<UserEntity> userList=userDao.findUserlist();		
		
		return userList;
	}

}
