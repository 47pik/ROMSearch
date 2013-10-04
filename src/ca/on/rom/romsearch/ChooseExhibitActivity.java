package ca.on.rom.romsearch;

import java.util.ArrayList;
import java.util.Locale;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.provider.UserDictionary;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class ChooseExhibitActivity extends FragmentActivity {
	public static final String EXTRA_MESSAGE = "ca.on.rom.ROMSEARCH.MESSAGE";
	public static final String EXTRA_SAVEFILE = "ca.on.rom.ROMSEARCH.SAVEFILE";
	
	public String[] exhibitArray;
	public Double[] completionArray;
	
	public DialogFragment dialog;
	
	@Override
	protected void onPause() {
		super.onPause();
		if (dialog != null) {
			dialog.dismiss();
		}
	}

	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_choose_exhibit);
		GridData.setupTables(getApplicationContext());
		
		//ensure Honeycomb or higher to use ActionBar APIs
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
			//show the up button in the action bar
			getActionBar().setDisplayHomeAsUpEnabled(true);
		}
		
	}
	
	public void onCreateListView() {
		final ListView listview = (ListView) findViewById(R.id.exhibit_list);			
		final ExhibitListArrayAdapter adapter = new ExhibitListArrayAdapter(getApplicationContext(),
			exhibitArray, completionArray);
		listview.setAdapter(adapter);
	
		listview.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View v, int position, long id){
				//on click, go to exhibit selected
				chooseExhibit(exhibitArray[position]);
			
			}
		});
	}

	
	@Override
	protected void onResume() {
		super.onResume();
		//reload the save in case new savedata has been written
		loadSave();
		onCreateListView();
		
		//if the first time running, display the help and add words to dictionary
		SharedPreferences sharedPref = getSharedPreferences("PREFERENCE", MODE_PRIVATE);
		boolean firstrun = sharedPref.getBoolean("firstrun_choose", true);
		if (firstrun) {
			addDictionaryWords();
			//showHelp()
			SharedPreferences.Editor editor = sharedPref.edit();
			editor.putBoolean("firstrun_choose", false);
			editor.commit();
		}
	}

	public void chooseExhibit(String exhibit) {
		Intent intent = new Intent(this, DisplayExhibitActivity.class);
		//get save data
		SharedPreferences sharedPref = this.getSharedPreferences(exhibit, Context.MODE_PRIVATE);
		String savedata = sharedPref.getString(exhibit, "000000000");
		//send name and save data
		intent.putExtra(EXTRA_MESSAGE, exhibit);
		intent.putExtra(EXTRA_SAVEFILE, savedata);
		startActivity(intent);
		
	}

	public void loadSave() {
		ExhibitData eData; //exhibit data structure
		SharedPreferences sData; //exhibit save data string from sharedpref
		Double completion; //% completion
		ArrayList<Double> completionList = new ArrayList<Double>();
		exhibitArray = getResources().getStringArray(R.array.exhibit_array);
		//get all completion values
		for (int i = 0; i < exhibitArray.length; i++) {
			sData = this.getSharedPreferences(exhibitArray[i], Context.MODE_PRIVATE);
			eData = new ExhibitData(sData.getString(exhibitArray[i], "000000000"));
			completion = eData.getCompletion();
			completionList.add(completion);
		}
		Double[] completionArray = new Double[completionList.size()];
		completionArray = completionList.toArray(completionArray);
		this.completionArray = completionArray;
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.choose_exhibit, menu);
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
	    // Handle item selection
	    switch (item.getItemId()) {
	        case R.id.action_achievements:
	        	startActivity(new Intent(this, AchievementListActivity.class));
	        	return true;
	        case R.id.action_about:
	        	showAbout();
	        	return true;
	        default:
	            //return super.onOptionsItemSelected(item);
	        	startActivity(new Intent(this, MainActivity.class));
	        	return true;
	    }
	}
	
	public void showAbout() {
		dialog = new DisplayAppInfoDialogFragment();
		FragmentManager fm = getSupportFragmentManager();
		dialog.show(fm, "app info");
		
	}
	
	public void addDictionaryWords() {
		for (String exhibit : exhibitArray) {
			String[] words = GridData.getDictWords(exhibit);
			for (String word : words) {
				Locale current = getResources().getConfiguration().locale;
				UserDictionary.Words.addWord(getApplicationContext(), word, 1, null, current);
			}
		}
	}
}