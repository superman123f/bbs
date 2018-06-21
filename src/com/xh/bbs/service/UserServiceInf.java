package com.xh.bbs.service;

import java.util.List;

import com.xh.bbs.entity.UserEntity;

public interface UserServiceInf {

	// 登录时作用户的验证查询
	public UserEntity login(String userId, String passwd);

	// 添加用户
	public int saveUser(UserEntity user);
	
	//删除用户
	public void deleteUser(int uid);
	
	//修改用户
	public void updateUser(UserEntity user);
	
	//查询用户信息ById
	public UserEntity findUser(int uid);
	
	//查询所有用户
	public List<UserEntity> findUserList();

}
