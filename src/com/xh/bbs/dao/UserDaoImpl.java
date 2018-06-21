package com.xh.bbs.dao;


import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


import com.xh.bbs.entity.UserEntity;
import com.xh.bbs.utils.*;

public class UserDaoImpl implements UserDaoInf{

	public UserEntity findUser(String userId, String passwd) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from user_info where user_id=? and user_password=?";
		UserEntity user = null;
		try{
			conn = DBUtil.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, userId);
			ps.setString(2, passwd);
			rs = ps.executeQuery();
			if(rs.next()){	
				user = new UserEntity();	
	
				user.setUser_id(rs.getInt(1));
				user.setUser_name(rs.getString(2));
				user.setUser_password(rs.getString(3));
				user.setUser_sex(rs.getString(4));
				user.setUser_face(rs.getString(5));
				user.setUser_phone(rs.getString(6));
				user.setUser_email(rs.getString(7));
				user.setUser_from(rs.getString(8));
				user.setIsAdmin(rs.getInt(9));
			}	
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBUtil.close(rs, ps, conn);
		}
		return user;
	}

	public int addUser(UserEntity user) {
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "insert into user_info(user_id,user_name,user_password,user_sex,user_face,user_phone,user_email,user_from) values(?,?,?,?,?,?,?,?)";
				
		System.out.println(user.getUser_id());
	
		int i = 0;
		try{
//			String newPassword=MD5.generateCode(user.getUser_password());
			conn = DBUtil.getConnection();
			
			ps = conn.prepareStatement(sql);
			ps.setInt(1, user.getUser_id());
			ps.setString(2, user.getUser_name());
			ps.setString(3, user.getUser_password());
			ps.setString(4, user.getUser_sex());
			ps.setString(5, user.getUser_face());
			ps.setString(6, user.getUser_phone());
			ps.setString(7, user.getUser_email());
			ps.setString(8, user.getUser_from());
									
			i = ps.executeUpdate();
						 
			System.out.println("插入数据库成功");
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBUtil.close(null,ps, conn); 
		}
		return i;
	}
	
	public void deleteUser(int uid){
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		String sql="delete from user_info where user_id=?";
		
		try {
			conn=DBUtil.getConnection();
			ps=conn.prepareStatement(sql);
			ps.setInt(1, uid);
			ps.executeUpdate();

			System.out.println("删除用户成功！");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{			
			DBUtil.close(rs, ps, conn);
		}
		
	}

	
	public void updateUser(UserEntity user){
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
//		user_name,user_password,user_sex,user_face,user_phone,user_email,user_from
		
//		String sql="update user_info set user_name='"+user.getUser_name()+"',user_password='"+user.getUser_password()+"',user_sex='"+user.getUser_sex()+"',user_face='"+user.getUser_face()+"',user_phone='"+user.getUser_phone()+"',user_email='"+user.getUser_email()+"',user_from='"+user.getUser_from()+"' where user_id="+user.getUser_id()+"";
		String sql="update user_info set user_name=?,user_password=?,user_sex=?,user_face=?,user_phone=?,user_email=?,user_from=? where user_id=?";
		try {
			conn=DBUtil.getConnection();
			ps=conn.prepareStatement(sql);
			
			ps.setString(1,user.getUser_name());
			ps.setString(2,user.getUser_password());
			ps.setString(3,user.getUser_sex());
			
			ps.setString(4,user.getUser_face());
			ps.setString(5,user.getUser_phone());
			ps.setString(6,user.getUser_email());
			ps.setString(7,user.getUser_from());
			ps.setInt(8, user.getUser_id());
			ps.executeUpdate();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.close(rs, ps, conn);
		}
		
	}
	public UserEntity findUserById(int id) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from user_info where user_id=?";
		UserEntity user = null;
		try{
			conn = DBUtil.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1,id);
			rs = ps.executeQuery();
			if(rs.next()){	
				user = new UserEntity();
				user.setUser_id(rs.getInt(1));
				user.setUser_name(rs.getString(2));
				user.setUser_password(rs.getString(3));
				user.setUser_sex(rs.getString(4));
				user.setUser_face(rs.getString(5));
				user.setUser_phone(rs.getString(6));
				user.setUser_email(rs.getString(7));
				user.setUser_from(rs.getString(8));
			}	
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBUtil.close(rs, ps, conn);
		}
		return user;
	}
	
	public List<UserEntity> findUserlist(){
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		List<UserEntity> userlist=new ArrayList<UserEntity>();
		String sql="select * from user_info";
		
		try {
			conn=DBUtil.getConnection();
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			
			while(rs.next()){
				UserEntity user=new UserEntity();
				user.setUser_id(rs.getInt(1));
				user.setUser_name(rs.getString(2));
				user.setUser_password(rs.getString(3));
				user.setUser_sex(rs.getString(4));
				user.setUser_face(rs.getString(5));
				user.setUser_phone(rs.getString(6));
				user.setUser_email(rs.getString(7));
				user.setUser_from(rs.getString(8));
				user.setIsAdmin(rs.getInt(9));
				
				userlist.add(user);
			}
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.close(rs, ps, conn);
		}
	
		
		return userlist;
	}

}