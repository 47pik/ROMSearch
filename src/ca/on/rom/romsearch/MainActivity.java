package ca.on.rom.romsearch;

import java.util.Locale;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

public class MainActivity extends FragmentActivity {
	
	private int initialPaddingTop = 0;
	
	ProgressBar loading;
	
	@SuppressLint({ "NewApi", "InlinedApi" })
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		// Following line is for testing when there is no bottom nav-bar.
//		getWindow().getDecorView()
//        .setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
		setCorrectSpacing();
	}
	
	@Override
	protected void onResume() {
		super.onResume();
		//reload the save in case new savedata has been written
		setCorrectSpacing();
		//make progress bar invisible and give it colour
		loading = (ProgressBar) findViewById(R.id.loading);
		loading.getIndeterminateDrawable().setColorFilter(0xFFCDAD00, android.graphics.PorterDuff.Mode.MULTIPLY);
		loading.setVisibility(View.INVISIBLE);
		//enable buttons
		enableButtons(true);
	}
	
	public void goToExhibits(View view) {
		//if the first time running, add words to dictionary
		SharedPreferences sharedPref = getSharedPreferences("PREFERENCE", MODE_PRIVATE);
		boolean firstrun = sharedPref.getBoolean("firstrun_choose", true);
		if (firstrun) {
			//disable buttons while loading
			enableButtons(false);
			//set up the loading async task
			String[] exhibitArray = getResources().getStringArray(R.array.exhibit_array);
			Locale current = getResources().getConfiguration().locale;
			//display the progressbar and load new activity
			new Loading(loading, exhibitArray, current,
					getApplicationContext(), this).execute();
			//toggle off firstrun
			SharedPreferences.Editor editor = sharedPref.edit();
			editor.putBoolean("firstrun_choose", false);
			editor.commit();
		} else {
			startActivity(new Intent(this, ChooseExhibitActivity.class));
		}
	}
	
	public void setCorrectSpacing() {
		DisplayMetrics metrics = new DisplayMetrics();
		LinearLayout main = (LinearLayout) findViewById(R.id.mainmenu);
		getWindowManager().getDefaultDisplay().getMetrics(metrics);
		if (initialPaddingTop == 0){
			initialPaddingTop = main.getPaddingTop();
		}		
		if (metrics.heightPixels == 1280){
			// XHDPI device; no nav-bar
			main.setPadding(0, initialPaddingTop + 48, 0, main.getPaddingBottom());
		} else if (metrics.heightPixels == 1920){
			// XXHDPI device; no nav-bar
			main.setPadding(0, initialPaddingTop + 144, 0, main.getPaddingBottom());
		}
	}
	public void goToAchievements(View view) {
		startActivity(new Intent(this, AchievementListActivity.class));	
	}
	
	public void enableButtons(boolean enable) {
		View button1 = findViewById(R.id.exhibit_button);
		View button2 = findViewById(R.id.achievement_button);
		button1.setEnabled(enable);
		button2.setEnabled(enable);
	}
}
