package ca.on.rom.romsearch;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ListView;

public class AchievementListActivity extends Activity {

	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_achievement_list);
		
		final ListView listview = (ListView) findViewById(R.id.achievement_list);
		AchievementData data = new AchievementData();
		data.setupAchievements(getApplicationContext());
		Achievement[] achievements = data.getAllAchievements();
		
		final AchievementListArrayAdapter adapter = new AchievementListArrayAdapter(getApplicationContext(),
				achievements);
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
