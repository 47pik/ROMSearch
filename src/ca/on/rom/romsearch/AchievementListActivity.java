package ca.on.rom.romsearch;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ListView;

public class AchievementListActivity extends Activity {

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
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.achievement_list, menu);
		return true;
	}

}
