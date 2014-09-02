package cn.edu.nju.zsyy.safety;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;

public class AccountInfo 
{
	public static final int FEMALE = 1;
	public static final int MALE = 0;
	public static String RealName = null;
	public static int Gender = MALE;
	public static String IDNumber = null;
	public static String PhoneNumber = null;
	public static String Password = null;// �Ȳ����ܣ������̶��������Ժ���취����
	public static String Email = null;
	public static boolean SignedIn = false;
	public static double moneyleft=0;//���
	
	private static OnSignInStatusChangedListener listener = null;

	public static void setOnSignInStatusChangedListener(OnSignInStatusChangedListener changedListener)
	{
		listener = changedListener;
	}

	public static boolean signIn(Context context) 
	{		
		if(Math.random() > 0.5)
		{
			SharedPreferences.Editor editor = context.getSharedPreferences("pocket_hospital", 0).edit();
			//�����������������½
			
			//�Ժ�������ݿ���ܴ洢
			SignedIn = true;
			listener.onSignInStatusChanged(true);
			return true;
		}
		else
		{
			return false;
		}
	}

	public static void signOut(Context paramContext)
	{
		if(SignedIn)
		{
			SignedIn = false;
			SharedPreferences.Editor editor = paramContext.getSharedPreferences("pocket_hospital", 0).edit();
			editor.remove("RealName");
			editor.remove("Gender");
			editor.remove("IDNumber");
			editor.remove("PhoneNumber");
			editor.remove("Email");
			editor.commit();
			if (listener != null)
				listener.onSignInStatusChanged(false);
		}
	}

	public static abstract interface OnSignInStatusChangedListener 
	{
		public abstract void onSignInStatusChanged(boolean paramBoolean);
	}
}
