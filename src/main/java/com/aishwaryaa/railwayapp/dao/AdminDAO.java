package com.aishwaryaa.railwayapp.dao;

import com.aishwaryaa.railwayapp.exception.DbException;

public interface AdminDAO {

	public String Userlogin(String username, int pass)throws DbException;

}
