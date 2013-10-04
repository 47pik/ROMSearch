package ca.on.rom.romsearch;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


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
	
	@SuppressLint("NewApi")
	public View getView(int position, View convertView, ViewGroup parent) {
		ImageView imageView;
		if (convertView == null) {
			// To determine if there is a nav-bar.
			imageView = new ImageView(mContext);
			// Really need to figure out a function to do this instead...
			// Nexus 4 / Extra-High Density Phones
			if (swidth > 1200 && swidth < 1300 && sheight > 700 && sheight < 800){
				int imageh = (int) (swidth/6.8085106382978723404255319148936); // ~150 pixels
				int imagew = (int) (sheight/5.12); // ~190 pixels
				imageView.setLayoutParams(new GridView.LayoutParams(imagew, imageh));
			}
			// Nexus 1 / High Density Phones
			else if (swidth > 750 && swidth < 850 && sheight > 400 && sheight < 500){
				int imageh = (int) (swidth/6.7226890756302521008403361344538); // ~95 Px
				int imagew = (int) (sheight/5.0526315789473684210526315789474); // ~117 Px
				imageView.setLayoutParams(new GridView.LayoutParams(imagew, imageh));
			}
			// HTC One / 1080p Phones / Extra-Extra High Density Phones
			else if (swidth > 1900 && swidth < 2000 && sheight > 1000 && sheight < 1201){
				int imageh = (int) (swidth/7.2) + 3; // ~190 pixels
				int imagew = (int) (sheight/5.12); // ~150 pixels
				imageView.setLayoutParams(new GridView.LayoutParams(imagew, imageh));
			}
			else {
				int imageh = (int) (swidth/6.8085106382978723404255319148936);
				int imagew = (int) (sheight/5.12);
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
