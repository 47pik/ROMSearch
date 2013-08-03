package ca.on.rom.romsearch;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity{
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}
	
	@Override
	protected void onResume() {
		super.onResume();
		//reload the save in case new savedata has been written
	}
	
	public void goToExhibits(View view) {
		startActivity(new Intent(this, ChooseExhibitActivity.class));
	}
	
	public void goToAchievements(View view) {
		startActivity(new Intent(this, AchievementListActivity.class));	
	}
}
