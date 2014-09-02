package cn.edu.nju.zsyy;

import cn.edu.nju.zsyy.bean.Constants;
import cn.edu.nju.zsyy.bean.UpdateInfo;
import cn.edu.nju.zsyy.engine.DoctorParser;
import cn.edu.nju.zsyy.engine.DownloadFileTask;
import cn.edu.nju.zsyy.engine.KeshiInfoParser;
import cn.edu.nju.zsyy.engine.UpdateInfoParser;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Toast;

public class SplashActivity extends Activity 
{
	private static final int SPLASH_DISPLAY_LENGTH = 2000;
	private static final String TAG = "SplashActivity";
	private static UpdateInfo info=null;	
	
	@Override
	public void onCreate(Bundle bundle) 
	{
		super.onCreate(bundle);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_splash);
		
		final Handler handler=new Handler()
		{
			@Override
			public void handleMessage(Message msg)
			{
				if(!Constants.initialed || DoctorParser.initialstate == 0 || KeshiInfoParser.initialstate == 0)
				{
					new Thread()
					{
						@Override
						public void run()
						{
							try 
							{
								UpdateInfoParser.getUpdateInfo(getResources().getString(R.string.updateurl));
								new KeshiInfoParser(new Handler()).getInfo();
								new DoctorParser(new Handler()).getInfo();
							} 
							catch (Exception e) 
							{
								e.printStackTrace();
								KeshiInfoParser.initialstate=0;
								DoctorParser.initialstate=0;
							}
						}
					}.start();
				}
			}
		};
		
		final Runnable runnable=new Runnable()
		{
			@Override
			public void run()
			{
				handler.postDelayed(this,1000);
			}
		};
		
		handler.postDelayed(runnable, 1000);
		
		Animation splashAnimation = AnimationUtils.loadAnimation(this,R.anim.splash_animation);
		View img = findViewById(R.id.logo_building);
		
		final String versiontext=getVersion();
		
		if (splashAnimation != null) 
		{
			splashAnimation.setAnimationListener(new Animation.AnimationListener() 
			{
				@Override
				public void onAnimationEnd(Animation paramAnonymousAnimation) 
				{//ˢ��ҳ
					new Thread()
					{
						@Override
						public void run()
						{
							if(isNeedUpdate(versiontext))
							{
								Log.i(TAG,"�����������Ի���");
								showUpdateDialog();
							}
						}
					}.start();
					Intent intent = new Intent(SplashActivity.this,MainActivity.class);
					startActivity(intent);
					finish();
				}
	
				@Override
				public void onAnimationRepeat(Animation paramAnonymousAnimation) 
				{
				}
	
				@Override
				public void onAnimationStart(Animation paramAnonymousAnimation) 
				{
				}
			});
			img.startAnimation(splashAnimation);
			new Constants();
		}
	}
	
	private void showUpdateDialog() 
	{
		AlertDialog.Builder builder=new Builder(this);
		builder.setIcon(R.drawable.ic_launcher);
		builder.setTitle("��������");
		builder.setMessage(info.getDescription());
		builder.setPositiveButton("ȷ��",new OnClickListener()
		{
			@Override
			public void onClick(DialogInterface dialog, int which) 
			{
				Log.i(TAG,"����API�ļ�"+info.getApkurl());
				if(Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED))
				{
					
				}
				else
				{
					Toast.makeText(getApplicationContext(), "sd��������", 1).show();
					
				}
			}
		});
		
		builder.setNegativeButton("ȡ��",new OnClickListener()
		{
			@Override
			public void onClick(DialogInterface dialog, int which)
			{
				Log.i(TAG,"�û�ȡ������");
			}
		});
	}

	private class DownloadFiletask implements Runnable
	{
		private String path;//������·��
		private String filepath;//�����ļ�·��
		
		public DownloadFiletask(String path,String filepath)
		{
			this.path=path;
			this.filepath=filepath;
		}
		
		@Override
		public void run() 
		{
			try 
			{
				DownloadFileTask.getFile(path,filepath);
			} 
			catch (Exception e) 
			{
				e.printStackTrace();
				Toast.makeText(getApplicationContext(), "�����ļ�ʧ��",0).show();
			}
		}
		
	}
	
	private boolean isNeedUpdate(String versiontext) 
	{
		Looper.prepare();
		Handler handler=new Handler()
		{
			@Override
			public void handleMessage(Message msg)
			{
				if(msg.what == 0)
				{
					Toast.makeText(SplashActivity.this, "��ȡ����ʧ��", 0).show();
				}
			}
		};
		
		try 
		{
			info=UpdateInfoParser.getUpdateInfo(getResources().getString(R.string.updateurl));
			String version=info.getVersion();
			
			new KeshiInfoParser(new Handler()).getInfo();
			new DoctorParser(new Handler()).getInfo();
			
			if(versiontext.equals(version))
			{
				Log.i(TAG,"�汾��ͬ��������");
				return false;
			}
			else
			{
				Log.i(TAG,"�汾��ͬ��Ҫ����");
				return true;
			}
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			handler.sendEmptyMessage(0);
			Log.i(TAG,"��ȡ������Ϣ�쳣������������");
			DoctorParser.initialstate=0;
			KeshiInfoParser.initialstate=0;
		}
		return false;
	}

	private String getVersion()
	{
		try
		{
			PackageManager manager=getPackageManager();
			PackageInfo info=manager.getPackageInfo(getPackageName(), 0);
			return info.versionName;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return "�汾��δ֪";
		}
	}
}