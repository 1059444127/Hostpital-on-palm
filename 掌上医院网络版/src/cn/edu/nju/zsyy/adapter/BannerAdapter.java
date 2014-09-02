package cn.edu.nju.zsyy.adapter;

import cn.edu.nju.zsyy.R;
import cn.edu.nju.zsyy.R.drawable;
import cn.edu.nju.zsyy.R.id;
import cn.edu.nju.zsyy.bean.Constants;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * ����������
 * @version 1.0
 * @created 2014-3-25
 */
public class BannerAdapter extends PagerAdapter
{//����������
	private final static String TAG = "BannerAdapter"; 
	
	//ҳ��
	private static final int PAGE_COUNT = 5;
	private Activity activity=null;
	private Bitmap[] bitmaps=new Bitmap[PAGE_COUNT];
	private ImageView[] images=new ImageView[PAGE_COUNT];
	private Fragment mainFragment=null;
	
	public BannerAdapter(Activity activity,Fragment mainFragment)
	{
		this.mainFragment=mainFragment;
		for(int i=0;i<PAGE_COUNT;i++)
		{
			bitmaps[i]=null;
		}
		
		for(int i=0;i<PAGE_COUNT;i++)
		{
			images[i]=null;
		}
		
		this.activity=activity;
		bitmaps[0]=BitmapFactory.decodeResource(activity.getResources(),R.drawable.show1);
		bitmaps[1]=BitmapFactory.decodeResource(activity.getResources(),R.drawable.show2);
		bitmaps[2]=BitmapFactory.decodeResource(activity.getResources(),R.drawable.show3);
		bitmaps[3]=BitmapFactory.decodeResource(activity.getResources(),R.drawable.show4);
		bitmaps[4]=BitmapFactory.decodeResource(activity.getResources(),R.drawable.show5);
		
		class MyOnClickListener implements View.OnClickListener
		{
			private Fragment mainFragment=null;
			int index=0;
			
			public MyOnClickListener(Fragment f,int index)
			{
				this.index=index;
				this.mainFragment=f;
			}
			
			@Override
			public void onClick(View v) 
			{
				int type=Constants.SHOUYE;
				switch(index)
				{
					case 0://ҽԺ��ɫ
						type=Constants.JIANJIE;
						break;
						
					case 1://��ҽ����
						type=Constants.JIUYILIUCHENG;
						break;
						
					case 2://ԤԼ�Һ�
						type=Constants.PUTONGGUAHAO;
						break;
						
					case 3://�ҵķ���
						type=Constants.HOUZHENSHI;
						break;
						
					case 4://����ָ��
						type=Constants.SHIYONGBANGZHU;
						break;
						
					case 5://����`
						type=Constants.GENGDUO;
						break;
				}
				
				//�����¼�
		        FragmentTransaction fragmentTransaction = mainFragment.getFragmentManager().beginTransaction();
		        fragmentTransaction.replace(R.id.container,Constants.get(type));
		        fragmentTransaction.addToBackStack(null);            
		        fragmentTransaction.commit();
		        Constants.state=type;
		        Constants.fstack.push(Constants.get(type));
			}
			
		}
		
		for(int i=0;i<PAGE_COUNT;i++)
		{
			images[i]=new ImageView(activity);
			images[i].setImageBitmap(bitmaps[i]);
			images[i].setScaleType(ImageView.ScaleType.FIT_CENTER);
			images[i].setOnClickListener(new MyOnClickListener(mainFragment,i));
		}
	}
	
	@Override
	public int getCount() 
	{
		return PAGE_COUNT;
	}

	@Override
	public boolean isViewFromObject(View view, Object obj) 
	{
		return view == obj;
	}

	@Override
	public void destroyItem(ViewGroup container,int position,Object object)
	{
		container.removeView((View)object);
		object=null;
	}
	
	@Override
	public Object instantiateItem (ViewGroup container, final int position)
	{
		container.addView(images[position]);
		return images[position];
	}
}
