package cn.edu.nju.zsyy.bean;

import java.util.ArrayList;
import java.util.List;

public class DoctorsInfo 
{
	private int id;//ȫ��Ψһ���
	private String doctorname="";
	private String father="";//����С����
	private String summary="";
	private String smallpicurl="";
	private String detailurl="";
	private String usefulinfo="";
	
	public String getDoctorname() 
	{
		return doctorname;
	}
	
	public void setDoctorname(String doctorname) 
	{
		this.doctorname = doctorname;
	}
	
	public String getSummary() 
	{
		return summary;
	}
	
	public void setSummary(String summary) 
	{
		this.summary = summary;
	}
	
	public String getSmallpicurl() 
	{
		return smallpicurl;
	}
	
	public void setSmallpicurl(String smallpicurl) 
	{
		this.smallpicurl = smallpicurl;
	}
	
	public String getDetailurl()
	{
		return detailurl;
	}
	
	public void setDetailurl(String detailurl) 
	{
		this.detailurl = detailurl;
	}

	public int getId() 
	{
		return id;
	}

	public void setId(int id) 
	{
		this.id = id;
	}

	public String getFather() 
	{
		return father;
	}

	public void setFather(String father) 
	{
		this.father = father;
	}

	public String getUsefulinfo() 
	{
		return usefulinfo;
	}

	public void setUsefulinfo(String usefulinfo) 
	{
		this.usefulinfo = usefulinfo;
	}
}
