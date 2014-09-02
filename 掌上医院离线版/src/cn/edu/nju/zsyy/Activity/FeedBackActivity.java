package cn.edu.nju.zsyy.Activity;

import cn.edu.nju.zsyy.R;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class FeedBackActivity extends Activity
{
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_feedback);
		
		ImageView back=(ImageView)findViewById(R.id.main_head_logo);
		back.setOnClickListener(new OnClickListener()
		{
			@Override
			public void onClick(View v) 
			{
				onBackPressed();
			}
		});
		
		Button bt=(Button)findViewById(R.id.sendfeedback);
		bt.setOnClickListener(new OnClickListener()
		{
			@Override
			public void onClick(View v) 
			{
				Toast.makeText(FeedBackActivity.this, "���ͳɹ�", Toast.LENGTH_LONG).show();
				finish();
			}
		});
	}

	@Override
	public void onBackPressed() 
	{
		Button sendfeedback=(Button)findViewById(R.id.sendfeedback);
		sendfeedback.setOnClickListener(new OnClickListener()
		{
			@Override
			public void onClick(View v) 
			{
				AlertDialog.Builder builder=new AlertDialog.Builder(FeedBackActivity.this);
				builder.setTitle("����������");
				builder.setMessage("�����˴α༭?");
				builder.setPositiveButton("ȷ��",new AlertDialog.OnClickListener()
				{
					@Override
					public void onClick(DialogInterface dialog, int which) 
					{
						finish();
					}
				});
				builder.setNegativeButton("ȡ��",null);
				builder.show();
			}
		});
	}
}
