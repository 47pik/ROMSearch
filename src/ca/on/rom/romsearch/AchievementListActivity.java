package ca.on.rom.romsearch;

import java.util.ArrayList;

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
		//keep track of which achievements are complete
		ArrayList<Achievement> completeList = new ArrayList<Achievement>();
		ArrayList<Achievement> incompleteList = new ArrayList<Achievement>();
		SharedPreferences countPref = this.getSharedPreferences(ACHIEVEMENT, Context.MODE_PRIVATE);
		int item_total = countPref.getInt(ITEMS_COMPLETE, 0);
		int exhibit_total = countPref.getInt(EXHIBITS_COMPLETE, 0);
		//check all achievements
		for (int i = 0; i < achievements.length; i++) {
			Achievement achievement = achievements[i];
			boolean complete;
			if (achievement.getType().equals("e")){
				//check which exhibits completed
				complete = countPref.getBoolean(achievement.getExhibit(), false);
			} else if (achievement.getType().equals("ne")){
				//check number of completed exhibits
				complete = achievement.checkCompletion(exhibit_total);
			} else {
				// check number of completed items
				complete = achievement.checkCompletion(item_total);
				}
			completion[i] = complete;
			if (complete){
				completeList.add(achievement);
			} else {
				incompleteList.add(achievement);
			}
		}
		//concatenate to have complete achievements at the head
		ArrayList<Achievement> sortedList = new ArrayList<Achievement>();
		sortedList.addAll(completeList);
		sortedList.addAll(incompleteList);
		
		Achievement[] sorted = sortedList.toArray(new Achievement[sortedList.size()]);
		final AchievementListArrayAdapter adapter = new AchievementListArrayAdapter(getApplicationContext(),
				sorted, completeList.size(), item_total, exhibit_total);
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
