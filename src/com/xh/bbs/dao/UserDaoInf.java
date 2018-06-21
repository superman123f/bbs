package com.xh.bbs.dao;

import java.util.List;

import com.xh.bbs.entity.UserEntity;

public interface UserDaoInf {

	//登录时作用户的验证查询
	public UserEntity findUser(String userId, String passwd);
	
	//根据id查询用户
	public UserEntity findUserById(int id);
	
	//添加用户
	public int addUser(UserEntity user);
	
	//删除用户
	public void deleteUser(int uid);
	
	//修改用户
	public void updateUser(UserEntity user);
	
	//查询所有用户信息
	public List<UserEntity> findUserlist();
}
