package ca.on.rom.romsearch;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class MainActivity extends Activity {
	
	public static final String EXTRA_MESSAGE = "ca.on.rom.ROMSEARCH.MESSAGE";
	public static final String EXTRA_SAVEFILE = "ca.on.rom.ROMSEARCH.SAVEFILE";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		GridData.setupTables(getApplicationContext());
		setContentView(R.layout.activity_main);
		onCreateSpinner();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public void onCreateSpinner() {
		Spinner spinner = (Spinner) findViewById(R.id.exhibit_spinner);
		//Create an ArrayAdapter using the string array and a default spinner layout
		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
				R.array.exhibit_array, android.R.layout.simple_spinner_dropdown_item);
		//Specify the layout to use when the list of choices appears
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		//Apply the adapter to the spinner
		spinner.setAdapter(adapter);
	}
	
	public void chooseExhibit(View view) {
		Intent intent = new Intent(this, DisplayExhibitActivity.class);
		//get name
		Spinner spinner = (Spinner) findViewById(R.id.exhibit_spinner);
		String exhibit = spinner.getSelectedItem().toString();
		//get save data
		SharedPreferences sharedPref = this.getSharedPreferences(exhibit, Context.MODE_PRIVATE);
		String savedata = sharedPref.getString(exhibit, "000000000");
		//send name and save data
		intent.putExtra(EXTRA_MESSAGE, exhibit);
		intent.putExtra(EXTRA_SAVEFILE, savedata);
		startActivity(intent);
		
	}

}
