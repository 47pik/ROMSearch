package ca.on.rom.romsearch;

import java.util.HashMap;

import android.content.Context;

public class GridData {
	
	public static HashMap<String, Integer[]> images = new HashMap<String, Integer[]>();
	public static HashMap<String, String[]> names = new HashMap<String, String[]>();
	
	public static HashMap<String, Integer[]> getImages() {
		return images;
	}
	
	public static HashMap<String, String[]> getNames() {
		return names;
	}
	
	public static void setupTables(Context c) {
		//set up images for exhibits
		Integer[] egypt_i = {R.drawable.placeholder, R.drawable.placeholder, R.drawable.placeholder, 
				R.drawable.placeholder, R.drawable.placeholder, R.drawable.placeholder,
				R.drawable.placeholder, R.drawable.placeholder, R.drawable.placeholder
				};
		Integer[] nubia_i = {R.drawable.placeholder, R.drawable.placeholder, R.drawable.placeholder, 
				R.drawable.placeholder, R.drawable.placeholder, R.drawable.placeholder,
				R.drawable.placeholder, R.drawable.placeholder, R.drawable.placeholder
				};
		Integer[] chinese_architecture_i = {R.drawable.placeholder, R.drawable.placeholder, R.drawable.placeholder, 
				R.drawable.placeholder, R.drawable.placeholder, R.drawable.placeholder,
				R.drawable.placeholder, R.drawable.placeholder, R.drawable.placeholder
				};
		Integer[] greece_i = {R.drawable.placeholder, R.drawable.placeholder, R.drawable.placeholder, 
				R.drawable.placeholder, R.drawable.placeholder, R.drawable.placeholder,
				R.drawable.placeholder, R.drawable.placeholder, R.drawable.placeholder
				};
		Integer[] korea_i = {R.drawable.placeholder, R.drawable.placeholder, R.drawable.placeholder, 
				R.drawable.placeholder, R.drawable.placeholder, R.drawable.placeholder,
				R.drawable.placeholder, R.drawable.placeholder, R.drawable.placeholder
				};
		
		images.put(c.getString(R.string.egypt), egypt_i);
		images.put(c.getString(R.string.nubia), nubia_i);
		images.put(c.getString(R.string.chinese_architecture), chinese_architecture_i);
		images.put(c.getString(R.string.greece), greece_i);
		images.put(c.getString(R.string.korea), korea_i);
		
		//set up names for exhibits
		String[] egypt_n = {"name", "name", "name", "name", "name", "name", "name", "name", "name"};
		String[] nubia_n = {"name", "name", "name", "name", "name", "name", "name", "name", "name"};
		String[] chinese_architecture_n = {"name", "name", "name", "name", "name", "name", "name", "name", "name"};
		String[] greece_n = {"name", "name", "name", "name", "name", "name", "name", "name", "name"};
		String[] korea_n = {"name", "name", "name", "name", "name", "name", "name", "name", "name"};
		
		names.put(c.getString(R.string.egypt), egypt_n);
		names.put(c.getString(R.string.nubia), nubia_n);
		names.put(c.getString(R.string.chinese_architecture), chinese_architecture_n);
		names.put(c.getString(R.string.greece), greece_n);
		names.put(c.getString(R.string.korea), korea_n);
	}

}
