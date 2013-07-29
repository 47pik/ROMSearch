package ca.on.rom.romsearch;

import java.util.ArrayList;
import java.util.Locale;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.provider.UserDictionary;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ImageView;
import android.widget.Spinner;

public class MainActivity extends Activity implements OnItemSelectedListener{
	
	public static final String EXTRA_MESSAGE = "ca.on.rom.ROMSEARCH.MESSAGE";
	public static final String EXTRA_SAVEFILE = "ca.on.rom.ROMSEARCH.SAVEFILE";
	
	public String[] exhibitArray;
	public Double[] completionArray;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		GridData.setupTables(getApplicationContext());
		setContentView(R.layout.activity_main);
		loadSave();
		onCreateSpinner();
		//if the first time running, display the help and add words to dictionary
		boolean firstrun = getSharedPreferences("PREFERENCE", MODE_PRIVATE).getBoolean("firstrun", true);
		if (firstrun) {
			addDictionaryWords();
			//showHelp()
		}
	}
	
	@Override
	protected void onResume() {
		super.onResume();
		//reload the save in case new savedata has been written
		loadSave();
		onCreateSpinner();
	}
	
	public void onCreateSpinner() {
		Spinner spinner = (Spinner) findViewById(R.id.exhibit_spinner);
		String spinnerArray[] = makeSpinnerArray();
		SpinnerArrayAdapter adapter = new SpinnerArrayAdapter (this, 
				android.R.layout.simple_spinner_dropdown_item, spinnerArray);
		//Specify the layout to use when the list of choices appears
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		//Apply the adapter to the spinner
		spinner.setAdapter(adapter);
		//set an onClickListener
		spinner.setOnItemSelectedListener(this);
		//get the displayed item and display it's thumbnail
		String exhibit = ((String) spinner.getSelectedItem()).split(" - ")[0];
		updateImages(exhibit);
	}
	
	public void chooseExhibit(View view) {
		Intent intent = new Intent(this, DisplayExhibitActivity.class);
		//get name
		Spinner spinner = (Spinner) findViewById(R.id.exhibit_spinner);
		String exhibit = spinner.getSelectedItem().toString().split(" - ")[0]; //get name only
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
	
	public String[] makeSpinnerArray() {
		String[] spinnerArray = new String[exhibitArray.length];
		//combine exhibit name and completion for spinnerArray
		String exhibit;
		String completion;
		double val;
		for (int i = 0; i < exhibitArray.length; i++) {
			exhibit = exhibitArray[i];
			val = completionArray[i] * 100;
			completion = Integer.toString((int) Math.round(val));
			spinnerArray[i] = exhibit + " - " + completion + "%";
		}
		return spinnerArray;
	}
	
	private void updateImages(String spinnerEntry) {
		//Get just the name of the exhibit
		String exhibit = spinnerEntry.split(" - ")[0];
		//use the middle item of the 3x3 exhibit display
		int img1 = GridData.getThumbs().get(exhibit)[3];
		int img2 = GridData.getThumbs().get(exhibit)[4];
		int img3 = GridData.getThumbs().get(exhibit)[5];
		ImageView iv1 = (ImageView) findViewById(R.id.exhibit_image1);
		ImageView iv2 = (ImageView) findViewById(R.id.exhibit_image2);
		ImageView iv3 = (ImageView) findViewById(R.id.exhibit_image3);
		iv1.setImageResource(img1);
		iv2.setImageResource(img2);
		iv3.setImageResource(img3);
		
	}
	
	public void goToAchievements(View view) {
		startActivity(new Intent(this, AchievementListActivity.class));	
	}
	
	
//OnItemSelectedListener methods

	public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
		updateImages((String) parent.getItemAtPosition(pos));
	}
	
	public void onNothingSelected(AdapterView<?> parent) {
	}
	
//First run UserDictionary related methods
	
	public void addDictionaryWords() {
		for (String exhibit : exhibitArray) {
			String[] words = GridData.getDictWords(exhibit);
			for (String word : words) {
				Locale current = getResources().getConfiguration().locale;
				UserDictionary.Words.addWord(getApplicationContext(), word, 1, null, current);
			}
		}
	}
	
//	private void goTo(String exhibit) {
//		Intent intent = new Intent(this, DisplayExhibitActivity.class);
//		intent.putExtra(EXTRA_MESSAGE, exhibit);
//		startActivity(intent);
//	}
//	
//	public void gotoEgypt(View view) {
//		goTo(getString(R.string.egypt));
//	}
//	
//	public void gotoSouthAsia(View view) {
//		goTo(getString(R.string.south_asia));
//	}
//
//	public void gotoGreece(View view) {
//		goTo(getString(R.string.greece));
//	}
//	
//	public void gotoMiddleEast(View view) {
//		goTo(getString(R.string.middle_east));
//	}
}
