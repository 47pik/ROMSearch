package ca.on.rom.romsearch;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class AchievementListArrayAdapter extends ArrayAdapter<Achievement> {
	private final Context context;
	private final Achievement[] achievements;
	
	public AchievementListArrayAdapter(Context context, Achievement[] achievements) {
		super(context, R.layout.achievement_row_layout, achievements);
		this.context = context;
		this.achievements = achievements;
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		LayoutInflater inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View rowView = inflater.inflate(R.layout.achievement_row_layout, parent, false);
		TextView textview = (TextView) rowView.findViewById(R.id.achievement_name);
		ImageView imageview = (ImageView) rowView.findViewById(R.id.achievement_image);
		//set the views to have the correct values
		String name = achievements[position].getName();
		textview.setText(name);
		imageview.setImageResource(achievements[position].getImage());
		return rowView;
	}
}
