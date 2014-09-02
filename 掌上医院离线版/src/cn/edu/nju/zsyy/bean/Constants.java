package cn.edu.nju.zsyy.bean;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import android.app.Activity;
import android.support.v4.app.Fragment;
import cn.edu.nju.zsyy.Fragments.*;
import cn.edu.nju.zsyy.Fragments.Feature.MingYiDaQuan;
import cn.edu.nju.zsyy.Fragments.Feature.ZhongDianZhuanKe;
import cn.edu.nju.zsyy.bean.*;

public class Constants 
{	
	//�������
	public static final int SHOUYE=00;//��ҳ
	
	
	public static final int JIANJIE=10;//ҽԺ���
	public static final int ZHONGDIANZHUANKE=11;//�ص�ר��
	public static final int MINGYIDAQUAN=12;//��ҽ��ȫ
	
	
	public static final int JIUYILIUCHENG=20;//��ҽ����
	public static final int GUAHAOYINDAO=21;//�Һ�����
	public static final int YIYUANDITU=22;//ҽԺ��ͼ
	
	
	public static final int PUTONGGUAHAO=30;//��ͨ�Һ�
	public static final int ZHUANJIAGUAHAO=31;//ר�ҹҺ�
	public static final int GAOJIZHUANJIAGUAHAO=32;//�߼�ר�ҹҺ�
	public static final int ZHUANBINGZHUANKEGUAHAO=33;//ר��ר�ƹҺ�
	
	public static final int YISHENGJIANJIE=34;//ҽ�����
	public static final int CHUZHENSHIJIAN=35;//����ʱ��
	
	public static final int HOUZHENSHI=40;//������
	public static final int DIANZIYIZHU=41;//����ҽ��
	public static final int DIANZIBINGLI=42;//���Ӳ���
	public static final int DIANZIJIANYANBAOGAO=43;//���Ӽ��鱨��
	public static final int SHOUJIJIANKANGYUANDI=45;//�ֻ�����԰��
	
	
	public static final int RUANJIANCAOZUOZHINAN=50;//�������ָ��
	public static final int SHOUJIGUAHAOLIUCHENG=51;//�ֻ��Һ�����
	public static final int SHIYONGBANGZHU=52;//ʹ�ð���

	public static final int WODEZHANGHAO=60;//�ҵ��˺�
	public static final int YINGYONGFENXIANG=61;//Ӧ�÷���
	public static final int BANBENXINXIJIGENGXIN=62;//�汾��Ϣ������
	public static final int RUANJIANYIJIANFANKUI=63;//����������
	
	
	public static final int RUANJIANSHEZHI=80;
	
	
	public static final int MAXNUM=100;
	
	//״̬���
	public static final int YISHENG=0x01;//ҽ��
	public static final int KESHI=0x02;//����
	public static final int WEIZHI=0x04;//λ��
	public static final int JIBING=0x08;//����
	public static final int ZHENGZHUANG=0x10;//֢״
	
	public static final int SEARCHTYPE_ALL=YISHENG | KESHI | WEIZHI | JIBING | ZHENGZHUANG;
	
	//����������֢״����������
	public static final int CHILD=0x100;//��ͯ
	public static final int OLD=0x200;//����
	public static final int AGE_ALL=CHILD | OLD;
	
	public static final int MALE=0x1000;//��
	public static final int FEMALE=0x2000;//Ů
	public static final int GENDER_ALL=MALE | FEMALE;
	
	public static final int SEARCHFILTER_ALL=AGE_ALL | GENDER_ALL;
	
	//��������
	public static final int NAME=0x100;
	public static final int BODYPART=0x200;
	
	public static int state=SHOUYE;//��ǰ״̬
	public static boolean initialed=false;
	
	public static String urlroot="";
	public static String yiyuanjianjiefile="";
	public static String zhongdianzhuankefile="";
	public static String mingyidaquanfile="";
	public static List<DoctorsInfo> doctorlist=new ArrayList<DoctorsInfo>();
	public static List<KeshiInfo> keshilist=new ArrayList<KeshiInfo>();
	public static List<PositionInfo> positionlist=new ArrayList<PositionInfo>();
}
