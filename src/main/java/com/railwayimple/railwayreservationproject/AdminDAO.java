package com.railwayimple.railwayreservationproject;

public interface AdminDAO {
	//@SqlQuery("select user_name,password from Admin")
	public String Userlogin(String username,int pass);

}
