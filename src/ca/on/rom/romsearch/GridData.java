package ca.on.rom.romsearch;

import java.util.HashMap;

import android.content.Context;

public class GridData {
	
	public static HashMap<String, Integer[]> images = new HashMap<String, Integer[]>();
	public static HashMap<String, Integer[]> thumbs = new HashMap<String, Integer[]>();
	public static HashMap<String, String[]> names = new HashMap<String, String[]>();
	
	public static HashMap<String, Integer[]> getImages() {
		return images;
	}
	
	public static HashMap<String, Integer[]> getThumbs() {
		return thumbs;
	}
	
	public static HashMap<String, String[]> getNames() {
		return names;
	}
	
	public static void setupTables(Context c) {
		//set up images for exhibits
		Integer[] egypt_i = {R.drawable.egypt1, R.drawable.egypt2, R.drawable.egypt3, 
				R.drawable.egypt4, R.drawable.egypt5, R.drawable.egypt6,
				R.drawable.egypt7, R.drawable.egypt8, R.drawable.egypt9
				};
		Integer[] nubia_i = {R.drawable.placeholder, R.drawable.placeholder, R.drawable.placeholder, 
				R.drawable.placeholder, R.drawable.placeholder, R.drawable.placeholder,
				R.drawable.placeholder, R.drawable.placeholder, R.drawable.placeholder
				};
		Integer[] chinese_architecture_i = {R.drawable.placeholder, R.drawable.placeholder, R.drawable.placeholder, 
				R.drawable.placeholder, R.drawable.placeholder, R.drawable.placeholder,
				R.drawable.placeholder, R.drawable.placeholder, R.drawable.placeholder
				};
		Integer[] greece_i = {R.drawable.greece1, R.drawable.greece2, R.drawable.greece3, 
				R.drawable.greece4, R.drawable.greece5, R.drawable.greece6,
				R.drawable.greece7, R.drawable.greece8, R.drawable.greece9
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
		
		//set up thumbnails for exhibits
		Integer[] egypt_t = {R.drawable.egypt1s, R.drawable.egypt2s, R.drawable.egypt3s, 
				R.drawable.egypt4s, R.drawable.egypt5s, R.drawable.egypt6s,
				R.drawable.egypt7s, R.drawable.egypt8s, R.drawable.egypt9s
				};
		Integer[] nubia_t = {R.drawable.placeholder, R.drawable.placeholder, R.drawable.placeholder, 
				R.drawable.placeholder, R.drawable.placeholder, R.drawable.placeholder,
				R.drawable.placeholder, R.drawable.placeholder, R.drawable.placeholder
				};
		Integer[] chinese_architecture_t = {R.drawable.placeholder, R.drawable.placeholder, R.drawable.placeholder, 
				R.drawable.placeholder, R.drawable.placeholder, R.drawable.placeholder,
				R.drawable.placeholder, R.drawable.placeholder, R.drawable.placeholder
				};
		Integer[] greece_t = {R.drawable.greece1s, R.drawable.greece2s, R.drawable.greece3s, 
				R.drawable.greece4s, R.drawable.greece5s, R.drawable.greece6s,
				R.drawable.greece7s, R.drawable.greece8s, R.drawable.greece9s
				};
		Integer[] korea_t = {R.drawable.placeholder, R.drawable.placeholder, R.drawable.placeholder, 
				R.drawable.placeholder, R.drawable.placeholder, R.drawable.placeholder,
				R.drawable.placeholder, R.drawable.placeholder, R.drawable.placeholder
				};
		
		thumbs.put(c.getString(R.string.egypt), egypt_t);
		thumbs.put(c.getString(R.string.nubia), nubia_t);
		thumbs.put(c.getString(R.string.chinese_architecture), chinese_architecture_t);
		thumbs.put(c.getString(R.string.greece), greece_t);
		thumbs.put(c.getString(R.string.korea), korea_t);
		
		//set up names for exhibits
		String[] egypt_n = {"game board for senet", "offering table", "mummy-case of pedikhonsu",
				"temple relief of senwosret i", "statue of the goddess sakhmet", "queen hatshepsut as a sphinx",
				"hunting scene", "broad collar", "royal scribe bokennenife"
				};
		String[] nubia_n = {"name", "name", "name", "name", "name", "name", "name", "name", "name"};
		String[] chinese_architecture_n = {"name", "name", "name", "name", "name", "name", "name", "name", "name"};
		String[] greece_n = {"head of silenos", "greek-style leg armour", "etrusco-corinthian neck-amphora",
				"youthful dionysos", "kylix", "torso of aphrodite", "gold wreaths", "the athena parthenos",
				"head of young herakles"};
		String[] korea_n = {"name", "name", "name", "name", "name", "name", "name", "name", "name"};
		
		names.put(c.getString(R.string.egypt), egypt_n);
		names.put(c.getString(R.string.nubia), nubia_n);
		names.put(c.getString(R.string.chinese_architecture), chinese_architecture_n);
		names.put(c.getString(R.string.greece), greece_n);
		names.put(c.getString(R.string.korea), korea_n);
	}

}
