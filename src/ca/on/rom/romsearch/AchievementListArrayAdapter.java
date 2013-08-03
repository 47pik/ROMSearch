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
	private final boolean[] completion;
	
	public AchievementListArrayAdapter(Context context, Achievement[] achievements, boolean[] completion) {
		super(context, R.layout.achievement_row_layout, achievements);
		this.context = context;
		this.achievements = achievements;
		this.completion = completion;
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		LayoutInflater inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View rowView = inflater.inflate(R.layout.achievement_row_layout, parent, false);
		TextView nameview = (TextView) rowView.findViewById(R.id.achievement_name);
		TextView descview = (TextView) rowView.findViewById(R.id.achievement_description);
		ImageView imageview = (ImageView) rowView.findViewById(R.id.achievement_image);
		//set the views to have the correct values
		Achievement achievement = achievements[position];
		String name = achievement.getName();
		nameview.setText(name);
		if (completion[position]) {
			imageview.setImageResource(achievement.getImage());
		} else {
			imageview.setImageResource(R.drawable.achievement_locked);
		}
		//set the description of the achievement
		String desc;
		if (achievement.getType().equals("i")) {
			desc = "Find " + Integer.toString(achievement.getRequirement()) + " items";
		} else if (achievement.getType().equals("ne")) {
			desc = "Complete " + Integer.toString(achievement.getRequirement()) + " exhibits";
		} else {
			desc = "Complete the " + achievement.getExhibit() + " exhibit";
		}
		//drop "exhibit" from the end if too long
		if (desc.length() > 50) {
			desc = desc.split(" exhibit")[0];
		}
		descview.setText(desc);
		
		return rowView;
	}
	
	@Override
	public boolean isEnabled(int position) {
	    return false;
	}
}
