package cn.edu.nju.zsyy.bean;

public class KeshiInfo 
{
	private int id;//ȫ��Ψһ���
	private String keshiname="";
	private String summary="";
	private String detailurl="";
	private KeshiInfo father=null;//���������
	private boolean isRootClass=false;//�Ƿ�Ϊ�����
	private boolean hasChildren=false;//�Ƿ����ӽڵ�
	private int firstindex=-1;//�ÿ��Ҷ�Ӧҽ���б�ĵ�һ��ҽ��/�ӿ���	hasChildren=false/true
	private int lastindex=-1;//�ÿ��Ҷ�Ӧҽ���б�����һ��ҽ��/�ӿ���	hasChildren=false/true
	
	public String getKeshiname() 
	{
		return keshiname;
	}
	
	public void setKeshiname(String keshiname) 
	{
		this.keshiname = keshiname;
	}
	
	public String getSummary()
	{
		return summary;
	}
	
	public void setSummary(String summary) 
	{
		this.summary = summary;
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

	public KeshiInfo getFather() 
	{
		return father;
	}

	public void setFather(KeshiInfo father) 
	{
		this.father = father;
	}

	public boolean isRootClass() 
	{
		return isRootClass;
	}

	public void setRootClass(boolean isRootClass) 
	{
		this.isRootClass = isRootClass;
	}

	public int getFirstindex() 
	{
		return firstindex;
	}

	public void setFirstindex(int firstindex) 
	{
		this.firstindex = firstindex;
	}

	public int getLastindex()
	{
		return lastindex;
	}

	public void setLastindex(int lastindex) 
	{
		this.lastindex = lastindex;
	}

	public boolean isHasChildren() 
	{
		return hasChildren;
	}

	public void setHasChildren(boolean hasChildren) 
	{
		this.hasChildren = hasChildren;
	}
}
