package ca.on.rom.romsearch;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ListView;

public class AchievementListActivity extends Activity {
	
	public final static String ACHIEVEMENT = "achievement";
	public final static String EXHIBITS_COMPLETE = "exhibits_complete";
	public final static String ITEMS_COMPLETE = "items_complete";

	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_achievement_list);
		
		final ListView listview = (ListView) findViewById(R.id.achievement_list);
		AchievementData data = new AchievementData();
		data.setupAchievements(getApplicationContext());
		Achievement[] achievements = data.getAllAchievements();
		//determine completion
		boolean[] completion = new boolean[achievements.length];
		SharedPreferences countPref = this.getSharedPreferences(ACHIEVEMENT, Context.MODE_PRIVATE);
		int item_total = countPref.getInt(ITEMS_COMPLETE, 0);
		int exhibit_total = countPref.getInt(EXHIBITS_COMPLETE, 0);
		for (int i = 0; i < achievements.length; i++) {
			Achievement achievement = achievements[i];
			if (achievement.getType().equals("e")){
				//check which exhibits completed
				if (countPref.getBoolean(achievement.getExhibit(), false)) {
					completion[i] = true;
				} else {
					completion[i] = false;
				}
			} else if (achievement.getType().equals("ne")){
				//check number of completed exhibits
				if (achievement.checkCompletion(exhibit_total)) {
					completion[i] = true;
				} else {
					completion[i] = false;
				}
			} else {
				// check number of completed items
				if (achievement.checkCompletion(item_total)) {
					completion[i] = true;
				} else {
					completion[i] = false;
				}
			}
		}
		final AchievementListArrayAdapter adapter = new AchievementListArrayAdapter(getApplicationContext(),
				achievements, completion);
		listview.setAdapter(adapter);
		
		getActionBar().setDisplayHomeAsUpEnabled(true);
		//ensure Honeycomb or higher to use ActionBar APIs
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
			//show the up button in the action bar
			getActionBar().setDisplayHomeAsUpEnabled(true);
		}
	}
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		startActivity(new Intent(this, MainActivity.class));
		return true;
	}
}
