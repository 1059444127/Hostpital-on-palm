package cn.edu.nju.zsyy.bean;

public class SearchData extends BaseData
{
	private String name="";//����
	private String keshi="";//�ü�������
	private String detailinfo="";//֢״/���� ��ϸ����
	private String detaildata="";//����:WithSymptom/֢״:PossibleIll

	public SearchData()
	{
		type=Constants.JIBING;
	}
	
	public String getName() 
	{
		return name;
	}
	
	public void setName(String name) 
	{
		this.name = name;
	}
	
	public String getKeshi() 
	{
		return keshi;
	}
	
	public void setKeshi(String keshi) 
	{
		this.keshi = keshi;
	}
	
	public String getDetailinfo() 
	{
		return detailinfo;
	}
	
	public void setDetailinfo(String detailinfo) 
	{
		this.detailinfo = detailinfo;
	}

	public int getType()
	{
		return type;
	}

	public void setType(int type) 
	{
		this.type = type;
	}

	public String getDetaildata()
	{
		return detaildata;
	}

	public void setDetaildata(String detaildata) 
	{
		this.detaildata = detaildata;
	}
}
