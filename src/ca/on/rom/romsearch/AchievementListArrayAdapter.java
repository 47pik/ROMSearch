package ca.on.rom.romsearch;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.TextView;

public class AchievementListArrayAdapter extends ArrayAdapter<Achievement> {
	private final Context context;
	private final Achievement[] achievements;
	private final int completed;
	private final int items_complete;
	private final int exhibits_complete;
	
	public AchievementListArrayAdapter(Context context, Achievement[] achievements,
			int completed, int items_complete, int exhibits_complete) {
		super(context, R.layout.achievement_row_layout, achievements);
		this.context = context;
		this.achievements = achievements;
		this.completed = completed; //number of completed achievements
		this.items_complete = items_complete;
		this.exhibits_complete = exhibits_complete;
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		LayoutInflater inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View rowView = inflater.inflate(R.layout.achievement_row_layout, parent, false);
		TextView nameview = (TextView) rowView.findViewById(R.id.achievement_name);
		TextView descview = (TextView) rowView.findViewById(R.id.achievement_description);
		ImageView imageview = (ImageView) rowView.findViewById(R.id.achievement_image);
		ProgressBar progress = (ProgressBar) rowView.findViewById(R.id.achievement_progress);
		TextView completion = (TextView) rowView.findViewById(R.id.achievement_completion);
		//set the views to have the correct values
		Achievement achievement = achievements[position];
		String name = achievement.getName();
		nameview.setText(name);
		progress.setMax(achievement.getRequirement());
		//Since completed items are at head of list, completed if position < completed
		if (position < completed) {
			imageview.setImageResource(achievement.getImage());
			//remove the progress bar and completion
			progress.setVisibility(View.GONE);
			completion.setVisibility(View.GONE);
		} else {
			imageview.setImageResource(R.drawable.achievement_locked);
		}
		//set the description of the achievement
		String desc;
		if (achievement.getType().equals("i")) {
			desc = "Find " + Integer.toString(achievement.getRequirement()) + " items";
			completion.setText(items_complete + "/" + achievement.getRequirement());
			progress.setProgress(items_complete);
		} else if (achievement.getType().equals("ne")) {
			//special case for ROM Master
			if (achievement.getRequirement() == 24) {
				desc = "Complete all galleries";
			} else {
				desc = "Complete " + Integer.toString(achievement.getRequirement()) + " galleries";
			}
			completion.setText(exhibits_complete + "/" + achievement.getRequirement());
			progress.setProgress(exhibits_complete);
		} else {
			String exhibit = achievement.getExhibit();
			//format exhibits with really long names
			if (exhibit.contains("Joey and Toby")) {
				exhibit = exhibit.replace("Joey and Toby ", "");	
			} else if (exhibit.contains("A.G. Leventis Foundation")) {
				exhibit = exhibit.replace("Foundation ", "");
			} else if (exhibit.contains("Shreyas and Mina Amjera ")) {
				exhibit = exhibit.replace("Shreyas and Mina Amjera ", "");
			} else if (exhibit.contains("The Samuel European")) {
				exhibit = exhibit.replace("The Samuel ", "");
			} else if (exhibit.contains("James and Louise")) {
				exhibit = exhibit.replace("James and Louise ", "");
			}
			//format description
			if (exhibit.contains("Gallery")) {
				desc = "Complete the " + exhibit;
			} else {
				desc = "Complete the " + exhibit + " gallery";
			}
			//remove the progress bar and completion
			progress.setVisibility(View.GONE);
			completion.setVisibility(View.GONE);
			//adjust margins
			 LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
			 lp.setMargins(0, -3, 0, -2);
			 descview.setLayoutParams(lp);
		}
		//drop "exhibit" from the end if too long
		if (desc.length() > 60) {
			desc = desc.split(" gallery")[0];
		}
		descview.setText(desc);
		
		return rowView;
	}

	//comment if want to enable click for achievements again
	@Override
	public boolean isEnabled(int position) {
	    return false;
	}
}
