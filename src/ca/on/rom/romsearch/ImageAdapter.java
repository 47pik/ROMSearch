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
			// Nexus 4
			if (swidth == 768 && sheight == 1280){
				int imageh = (int) (sheight/6.8085106382978723404255319148936);
				int imagew = (int) (swidth/5.12);
				imageView.setLayoutParams(new GridView.LayoutParams(imagew, imageh));
			}
			// Nexus 1
			else if (swidth == 480 && sheight == 800){
				int imageh = (int) (sheight/4.2105263157894736842105263157895);
				int imagew = (int) (swidth/3.2);
				imageView.setLayoutParams(new GridView.LayoutParams(imagew, imageh));
			}
			else {
				int imageh = (int) (sheight/6.8085106382978723404255319148936);
				int imagew = (int) (swidth/5.12);
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
