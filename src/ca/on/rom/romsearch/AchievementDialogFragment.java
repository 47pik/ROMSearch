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

public class AchievementDialogFragment extends DialogFragment {	
	
	public static AchievementDialogFragment newInstance(Achievement a, Boolean unlock) {
		AchievementDialogFragment frag = new AchievementDialogFragment();
		
		Bundle args = new Bundle();
		args.putInt("img", a.getImage());
		args.putString("name", a.getName());
		args.putBoolean("unlock", unlock);
		
		String desc;
		if (a.getType().equals("i")) {
			desc = "Find " + Integer.toString(a.getRequirement()) + " items";
		} else if (a.getType().equals("ne")) {
			desc = "Complete " + Integer.toString(a.getRequirement()) + " exhibits";
		} else {
			desc = "Complete the " + a.getExhibit() + " exhibit";
		}
		args.putString("desc", desc);
		
		frag.setArguments(args);
		
		return frag;
		
	}
	
	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		//use the builder class for convenient dialog construction
		AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
		
		//get layout inflater and set layout for dialog
		boolean unlock = getArguments().getBoolean("unlock");
		LayoutInflater inflater = getActivity().getLayoutInflater();
		View v;
		if (unlock) {
			v = inflater.inflate(R.layout.achievement_unlocked, null);
		} else {
			v = inflater.inflate(R.layout.achievement_display, null);
		}
		builder.setView(v)
				//add action buttons
				.setPositiveButton(R.string.button_ok, new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int id) {
						//User pressed OK -> send positive button event back to host activity
					}
				});
		int img = getArguments().getInt("img");
		String name = getArguments().getString("name");
		String desc = getArguments().getString("desc");
		
		ImageView achievement_image = (ImageView) v.findViewById(R.id.achievement_image);
		achievement_image.setImageResource(img);
		TextView achievement_name = (TextView) v.findViewById(R.id.achievement_name);
		achievement_name.setText(name);
		TextView achievement_description = (TextView) v.findViewById(R.id.achievement_description);
		achievement_description.setText(desc);
		
		//Create the AlertDialog object and return it
		return builder.create();

	}
	
}
