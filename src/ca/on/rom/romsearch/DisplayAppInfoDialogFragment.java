package ca.on.rom.romsearch;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;

public class DisplayAppInfoDialogFragment extends DialogFragment {
	
	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		//use the builder class for convenient dialog construction
		AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
		
		//get layout inflater and set layout for dialog
		LayoutInflater inflater = getActivity().getLayoutInflater();
		View v = inflater.inflate(R.layout.app_info_view, null);
		builder.setView(v);
		
		//create and return
		AlertDialog alert = builder.create();
		alert.show();
		return alert;
	}
}
