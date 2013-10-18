package ca.on.rom.romsearch;

import java.util.Locale;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.provider.UserDictionary;
import android.view.View;
import android.widget.ProgressBar;

public class Loading extends AsyncTask<Void, Void, Void> {
	
	ProgressBar progress;
	String[] exhibitArray;
	Locale locale;
	Context context;
	Activity activity;
	
	public Loading(ProgressBar progress, String[] exhibitArray, Locale locale, Context context, Activity activity) {
		this.progress = progress;
		this.exhibitArray = exhibitArray;
		this.locale = locale;
		this.context = context;
		this.activity = activity;
	}
	
	public void onPreExecute() {
		progress.setVisibility(View.VISIBLE);
		GridData.setupTables(context);
	}
	
	public Void doInBackground(Void... unused) {
		for (String exhibit : exhibitArray) {
			String[] words = GridData.getDictWords(exhibit);
			for (String word : words) {
				UserDictionary.Words.addWord(context, word, 1, null, locale);
			}
		}
		return null;
	}
	
	public void onPostExecute(Void unused) {
		progress.setVisibility(View.INVISIBLE);
		activity.startActivity(new Intent(activity, ChooseExhibitActivity.class));
	}
	

}
