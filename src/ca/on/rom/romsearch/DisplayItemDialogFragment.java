package ca.on.rom.romsearch;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class DisplayItemDialogFragment extends DialogFragment {
	
	public static int img;
	public static String name;
	
	
	public static DisplayItemDialogFragment newInstance(int id, String item) {
		DisplayItemDialogFragment frag = new DisplayItemDialogFragment();
		img = id;
		name = item;
		return frag;
		
	}
	
	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		//use the builder class for convenient dialog construction
		AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
		
		//get layout inflater and set layout for dialog
		LayoutInflater inflater = getActivity().getLayoutInflater();
		View v = inflater.inflate(R.layout.item_info_view, null);
		builder.setView(v)
				//add action buttons
				.setPositiveButton(R.string.button_ok, new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int id) {
						//User pressed OK -> send positive button event back to host activity
					}
				});
		
		ImageView iv = (ImageView) v.findViewById(R.id.selected_item);
		iv.setImageResource(img);
		TextView tv = (TextView) v.findViewById(R.id.item_name);
		tv.setText(name);
		
		//Create the AlertDialog object and return it
		return builder.create();

	}
	
}
