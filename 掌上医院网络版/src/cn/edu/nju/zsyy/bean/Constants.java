package cn.edu.nju.zsyy.bean;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import android.support.v4.app.Fragment;
import cn.edu.nju.zsyy.Fragments.*;
import cn.edu.nju.zsyy.bean.*;

public class Constants 
{	
	//�������
	public static final int SHOUYE=00;//��ҳ
	public static final int JIANJIE=10;//ҽԺ���
	public static final int ZHONGDIANZHUANKE=11;//�ص�ר��
	public static final int MINGYIDAQUAN=12;//��ҽ��ȫ
//	public static final int YIYUANSHESHI=13;//ҽԺ��ʩ
	public static final int JIUYILIUCHENG=20;//��ҽ����
	public static final int GUAHAOYINDAO=21;//�Һ�����
	public static final int YIYUANDITU=22;//ҽԺ��ͼ
	public static final int PUTONGGUAHAO=30;//��ͨ�Һ�
	public static final int ZHUANJIAGUAHAO=31;//ר�ҹҺ�
	public static final int GAOJIZHUANJIAGUAHAO=32;//�߼�ר�ҹҺ�
	public static final int ZHUANBINGZHUANKEGUAHAO=33;//ר��ר�ƹҺ�
	public static final int YISHENGJIANJIE=34;//ҽ�����
	public static final int CHUZHENSHIJIAN=35;//����ʱ��
//	public static final int PINGJIA=36;//����
	public static final int HOUZHENSHI=40;//������
	public static final int DIANZIYIZHU=41;//����ҽ��
	public static final int CHAKANDIANZIBINGLI=42;//�鿴���Ӳ���
	public static final int DIANZIJIANYANBAOGAO=43;//���Ӽ��鱨��
	public static final int YIHUANHUDONG=44;//ҽ������
	public static final int SHOUJIJIANKANGGUWEN=45;//�ֻ���������
	public static final int WODEFUWU=46;//�ҵķ���
	public static final int GUAHAOLIUCHENGTU=50;//�Һ�����
	public static final int GUAHAOGUIZE=51;
	public static final int SHIYONGBANGZHU=52;
	public static final int GENGDUO=60;
	public static final int LIANXIWOMEN=70;
	public static final int RUANJIANSHEZHI=80;
	
//	public static final int WEB=90;
	public static final int MAXNUM=100;
	
	//״̬���
	public static final int YISHENG=00;//��ҽ��
	public static final int KESHI=01;//�ѿ���
	public static final int WEIZHI=02;//��λ��
	public static final int JIBING=10;//�Ѽ���
	public static final int ZHENGZHUANG=11;//��֢״
	
	public static int state=SHOUYE;//��ǰ״̬
	public static boolean initialed=false;
	
	public static String urlroot="";
	public static String yiyuanjianjiefile="";
	public static String zhongdianzhuankefile="";
	public static String mingyidaquanfile="";
	public static List<DoctorsInfo> doctorlist=new ArrayList<DoctorsInfo>();
	public static List<KeshiInfo> keshilist=new ArrayList<KeshiInfo>();
	
	public static Stack<Fragment> fstack=new Stack<Fragment>();//��¼Fragment��ת����
	
	private static Fragment globalFragment[]=null;
	
	public Constants()
	{
		globalFragment=new Fragment[MAXNUM];
		for(int i=0;i<MAXNUM;i++)
		{
			globalFragment[i]=null;
		}
		
		globalFragment[SHOUYE]=new MainFragment().SetType(SHOUYE);
		globalFragment[JIANJIE]=new FeatureFragment().SetType(JIANJIE);
		globalFragment[ZHONGDIANZHUANKE]=new FeatureFragment().SetType(ZHONGDIANZHUANKE);
		globalFragment[MINGYIDAQUAN]=new FeatureFragment().SetType(MINGYIDAQUAN);
//		globalFragment[YIYUANSHESHI]=new FeatureFragment().SetType(YIYUANSHESHI);
		globalFragment[JIUYILIUCHENG]=new NavigationFragment().SetType(JIUYILIUCHENG);
		globalFragment[GUAHAOYINDAO]=new NavigationFragment().SetType(GUAHAOYINDAO);
		globalFragment[YIYUANDITU]=new NavigationFragment().SetType(YIYUANDITU);
		globalFragment[PUTONGGUAHAO]=new AppointmentFragment().SetType(PUTONGGUAHAO);
		globalFragment[ZHUANJIAGUAHAO]=new AppointmentFragment().SetType(ZHUANJIAGUAHAO);
		globalFragment[GAOJIZHUANJIAGUAHAO]=new AppointmentFragment().SetType(GAOJIZHUANJIAGUAHAO);
		globalFragment[ZHUANBINGZHUANKEGUAHAO]=new AppointmentFragment().SetType(ZHUANBINGZHUANKEGUAHAO);
		globalFragment[HOUZHENSHI]=new WaitingRoomFragment().SetType(HOUZHENSHI);
		globalFragment[DIANZIYIZHU]=new MedicalOrderFragment().SetType(DIANZIYIZHU);
		globalFragment[CHAKANDIANZIBINGLI]=new MedicalRecordFragment().SetType(CHAKANDIANZIBINGLI);
		globalFragment[DIANZIJIANYANBAOGAO]=new InspectionReportFragment().SetType(DIANZIJIANYANBAOGAO);
		globalFragment[YIHUANHUDONG]=new InteractionFragment().SetType(YIHUANHUDONG);
		globalFragment[SHOUJIJIANKANGGUWEN]=new HealthConsultantFragment().SetType(SHOUJIJIANKANGGUWEN);
		globalFragment[WODEFUWU]=new ServiceFragment();
		globalFragment[GUAHAOLIUCHENGTU]=new HelpFragment().SetType(GUAHAOLIUCHENGTU);
		globalFragment[GUAHAOGUIZE]=new HelpFragment().SetType(GUAHAOGUIZE);
		globalFragment[SHIYONGBANGZHU]=new HelpFragment().SetType(SHIYONGBANGZHU);
		globalFragment[GENGDUO]=new MoreFragment().SetType(GENGDUO);
		globalFragment[LIANXIWOMEN]=new ContactusFragment().SetType(LIANXIWOMEN);
		globalFragment[RUANJIANSHEZHI]=new SettingsFragment();
	}
	
	public static Fragment get(int index)
	{
		return globalFragment[index];
	}
	
	public static void set(int index,Fragment fragment)
	{
		globalFragment[index]=fragment;
	}
}
