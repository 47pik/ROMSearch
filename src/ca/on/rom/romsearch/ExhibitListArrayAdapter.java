package ca.on.rom.romsearch;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ExhibitListArrayAdapter extends ArrayAdapter<String> {
	
	Context context;
	String[] exhibitArray;
	Double[] completionArray;

	public ExhibitListArrayAdapter(Context context, String[] exhibitArray, Double[] completionArray) {
		super(context, R.layout.exhibit_row_layout, exhibitArray);
		this.context = context;
		this.exhibitArray = exhibitArray;
		this.completionArray = completionArray;
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		LayoutInflater inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View rowView = inflater.inflate(R.layout.exhibit_row_layout, parent, false);
		TextView nameview = (TextView) rowView.findViewById(R.id.exhibit_name);
		TextView compview = (TextView) rowView.findViewById(R.id.exhibit_completion);
		ImageView imageview = (ImageView) rowView.findViewById(R.id.exhibit_image);
		
		//Set the views to have the correct values
		String exhibit = exhibitArray[position];
		nameview.setText(exhibit);
		imageview.setImageResource(GridData.getThumbs().get(exhibit)[3]);
		String completion = Integer.toString((int) Math.round(completionArray[position] * 100));
		compview.setText(completion + "% Complete");
		
		
		
		return rowView;
	}
}
