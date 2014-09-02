package cn.edu.nju.zsyy;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import cn.edu.nju.zsyy.Activity.SearchActivity;
import cn.edu.nju.zsyy.drawer.NavigationDrawerFragment;
import cn.edu.nju.zsyy.safety.LoginActivity;

public class MainActivity extends ActionBarActivity
{
	private static final String TAG = "MainActivity";
	/**
	 * ������activity ����Framgment����
	 * @version 1.0
	 * @created 2014-3-25
	 */
	
	private static MainActivity instance=null;//ȫ��Activity��thisָ��
	private NavigationDrawerFragment navigationDrawerFragment=null;//�໬�ؼ���Fragment
	private ImageView loginButton=null;//��¼��ť
	private ImageView searchButton=null;//������ť
	private ImageView titleImage=null;//����ͼƬ
	private ImageView toggle=null;//�໬��ť
	private static OnSelfBack onSelfBackListener=null;//���ؼ�������
	
	@Override
	public void onResume()
	{
		super.onResume();
		Bundle bundle=getIntent().getExtras();
		if(bundle != null)
		{
			if(bundle.getString("intent").equals("AppointmentFragment"))
			{
				navigationDrawerFragment.gotoYUYUEGUAHAO();
			}
		}
	}
	
	//��ֹonResume��ȡ��������
	@Override
	protected void onNewIntent(Intent intent)
	{
		super.onNewIntent(intent);
		setIntent(intent);
	}
	
	@Override
	public void onRestart()
	{
		super.onRestart();
	}
	
	@Override
	public void onPause()
	{
		super.onPause();
	}

	/*
	 * ��ȡ�໬�˵���Fragment
	 */
	public NavigationDrawerFragment getDrawer() 
	{
		return navigationDrawerFragment;
	}

	/*
	 * ����Ӳ�����ؼ�
	 */
	@Override
	public void onBackPressed() 
	{
		Log.i(TAG,"onBackPressed");
		onSelfBack();
	}
	
	@Override
	public boolean onKeyDown(int keyCode,KeyEvent event)
	{
		if(keyCode == KeyEvent.KEYCODE_BACK)
		{
			Log.i(TAG,"onBackPressed");
			onSelfBack();
			return true;
		}
		return super.onKeyDown(keyCode, event);
	}

	@Override
	protected void onCreate(Bundle paramBundle) 
	{
		Log.i(TAG,"onCreate");
		super.onCreate(paramBundle);

		setContentView(R.layout.activity_main);
		instance = this;
		navigationDrawerFragment = ((NavigationDrawerFragment) getSupportFragmentManager().findFragmentById(R.id.navigation_drawer));
		getSupportActionBar().hide();
		toggle = (ImageView)findViewById(R.id.main_head_logo);
		titleImage = (ImageView)findViewById(R.id.main_head_title);
		loginButton = (ImageView)findViewById(R.id.main_head_loginbutton);
		searchButton = (ImageView)findViewById(R.id.main_head_searchbutton);
		
		searchButton.setOnClickListener(new OnClickListener()
		{
			@Override
			public void onClick(View v) 
			{
				Log.i(TAG,"searchButton.onClick");
				Intent intent = new Intent(MainActivity.this,SearchActivity.class);
				startActivity(intent);
			}
		});
		
		toggle.setOnClickListener(new View.OnClickListener() 
		{
			@Override
			public void onClick(View paramAnonymousView) 
			{
				Log.i(TAG,"toggle.onClick");
				navigationDrawerFragment.toggleDrawer();
			}
		});
		navigationDrawerFragment.setUp(R.id.navigation_drawer,(DrawerLayout) findViewById(R.id.drawer_layout));
	}

	/**
	 * @param goback true:����Ϊ���� false:����Ϊ�໬ 
	 * ���ò໬��ť����Ϊ�����ϸ�Fragment��򿪲߻��˵�
	 */
	public void setToggleIcon(boolean goback) 
	{
		if (!goback) 
		{//������
			Log.i(TAG,"ToggleIcon set to toggle");
			toggle.setImageResource(R.drawable.drawer_toggle);
			toggle.setOnClickListener(new View.OnClickListener() 
			{
				public void onClick(View v) 
				{//�򿪲˵�
					navigationDrawerFragment.toggleDrawer();
				}
			});
		}
		else
		{//����
			Log.i(TAG,"ToggleIcon set to back");
			toggle.setImageResource(R.drawable.back);
			toggle.setOnClickListener(new View.OnClickListener() 
			{
				public void onClick(View v)
				{
					navigationDrawerFragment.goToMain();
					setToggleIcon(false);
				}
			});		
		}
	}

	/**
	 * ���õ�¼��ť״̬
	 * @param imgid ����ͼƬid
	 * @param onClickListener ����ͼƬ������
	 */
	public void setloginButton(int imgid,View.OnClickListener onClickListener) 
	{
		Log.i(TAG,"loginbutton set!");
		loginButton.setImageResource(imgid);
		loginButton.setOnClickListener(onClickListener);
	}

	/**
	 * ���ñ���ͼƬ
	 * @param imgid ����ͼƬid
	 */
	public void setTitle(int imgid)
	{
		Log.i(TAG,"title set!");
		titleImage.setImageResource(imgid);
	}
	
	public static abstract interface OnSelfBack
	{
		public void onSelfBack();
	}
	
	/**
	 * ���÷��ذ�ť����
	 * ����ҵ������б����Ϊ��ǰ������ҳ
	 * ������ҳʱ���·��ؼ�������ȷ���˳��Ի��򣬷��򷵻ص��ϸ�Fragment
	 */
	public void onSelfBack()
	{
		if(onSelfBackListener == null)
		{
			if(null != findViewById(R.id.functable))
			{
				Log.i(TAG,"quit from MainActivity");
				AlertDialog.Builder dialog=new AlertDialog.Builder(this);
				dialog.setTitle("�뿪����");
				dialog.setTitle("��ȷ��Ҫ�˳���?");
				dialog.setIcon(R.drawable.ic_launcher);
				dialog.setPositiveButton("ȷ��",new DialogInterface.OnClickListener()
				{
					@Override
					public void onClick(DialogInterface dialog, int which) 
					{
						finish();
						System.exit(0);
					}
				});
				dialog.setNegativeButton("ȡ��",new DialogInterface.OnClickListener() 
				{
					@Override
					public void onClick(DialogInterface dialog, int which)
					{
						return;
					}
				});
				dialog.show();
			}
			else
			{
				Log.i(TAG,"go back from other fragment");
				super.onBackPressed();
			}
		}
		else
		{
			Log.i(TAG,"go back from other fragment use other listener");
			onSelfBackListener.onSelfBack();
			onSelfBackListener=null;//ֻ����һ��
		}
	}
	
	/**
	 * ���÷��ذ�ť�ⲿ������
	 * @param listener Ŀ�������
	 */
	public void setOnSelfBackListener(OnSelfBack listener)
	{
		this.onSelfBackListener=listener;
	}
}
