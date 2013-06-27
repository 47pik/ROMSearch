package ca.on.rom.romsearch;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class SpinnerArrayAdapter extends ArrayAdapter<String> {
	public SpinnerArrayAdapter(Context context, int textViewResourceId, 
			String[] objects) {
		super(context, textViewResourceId, objects);
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		TextView v = (TextView) super.getView(position, convertView, parent);
		String[] parts = v.getText().toString().split(" - ");
		v.setText(parts[0]);
		return v;
	}
	
	//@Override
//	public View getDropDownView(int position, View convertView, ViewGroup parent) {
	//	return super.getView(position, convertView, parent);
	//}
}
