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

public class VersionInfoActivity extends Activity
{
	/* (non-Javadoc)
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_versioninfo);
		Button bt=(Button)findViewById(R.id.detectnewversion);
		bt.setOnClickListener(new OnClickListener()
		{
			@Override
			public void onClick(View v) 
			{
				//�������
				if(Math.random() > 0.5)
				{
					AlertDialog.Builder builder=new AlertDialog.Builder(VersionInfoActivity.this);
					builder.setTitle("�°汾˵��");
					builder.setMessage("[����]����ȫ����������\n[�Ż�]�Ż����ֽ���\n[�޸�]�޸��˲����ֻ��޷����������");
					builder.setPositiveButton("��������",new AlertDialog.OnClickListener()
					{
						@Override
						public void onClick(DialogInterface dialog, int which) 
						{
							//���������˳�
							Toast.makeText(VersionInfoActivity.this, "�����ɹ�",Toast.LENGTH_LONG).show();
							finish();
						}
						
					});
					builder.setNegativeButton("ȡ��",new AlertDialog.OnClickListener()
					{
						@Override
						public void onClick(DialogInterface dialog, int which) 
						{
						}
					});
					
					builder.show();
				}
				else
				{
					Toast.makeText(VersionInfoActivity.this, "�Ѿ������°汾",Toast.LENGTH_LONG).show();
				}
			}
		});
		
		ImageView back=(ImageView)findViewById(R.id.main_head_logo);
		back.setOnClickListener(new OnClickListener()
		{
			@Override
			public void onClick(View v) 
			{
				finish();
			}
		});
	}
}
