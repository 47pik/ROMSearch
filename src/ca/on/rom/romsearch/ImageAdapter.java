package ca.on.rom.romsearch;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;


/*for implementing the exhibit grid display*/
public class ImageAdapter extends BaseAdapter {
	private Context mContext;
	//references to image
	private Integer[] mThumbIds;
	private int sheight;
	private int swidth;
	
	public ImageAdapter(Context c, Integer[] a, int height, int width) {
		mContext = c;
		mThumbIds = a;
		sheight = height;
		swidth = width;
		
	}
	
	public int getCount() {
		return mThumbIds.length;
	}
	
	public Object getItem(int position) {
		return null;
	}
	
	public long getItemId(int poistion) {
		return 0;
	}
	
	public View getView(int position, View convertView, ViewGroup parent) {
		ImageView imageView;
		if (convertView == null) {
			imageView = new ImageView(mContext);
			// Get Screen Resolution
//			DisplayMetrics displaymetrics = new DisplayMetrics();
//			((WindowManager) mContext.getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay().getMetrics(displaymetrics);
//			int height = displaymetrics.heightPixels;
//			int width = displaymetrics.widthPixels;
			if (swidth == 0 && sheight == 0){
				imageView.setLayoutParams(new GridView.LayoutParams(200, 200));
			}
			else {
				int imageh = (int) (sheight/8.0);
				int imagew = (int) (swidth/4.8);
				imageView.setLayoutParams(new GridView.LayoutParams(imagew, imageh));
			}
			
			imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
			imageView.setPadding(8, 8, 8, 8);
		} else {
			imageView = (ImageView) convertView;
		}
		
		imageView.setImageResource(mThumbIds[position]);
		return imageView;
	}
			
}
