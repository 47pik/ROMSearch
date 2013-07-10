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
		Integer[] south_asia_i = {R.drawable.southasia1, R.drawable.southasia2, R.drawable.southasia3, 
				R.drawable.southasia4, R.drawable.southasia5, R.drawable.southasia6,
				R.drawable.southasia7, R.drawable.southasia8, R.drawable.southasia9
				};
		Integer[] greece_i = {R.drawable.greece1, R.drawable.greece2, R.drawable.greece3, 
				R.drawable.greece4, R.drawable.greece5, R.drawable.greece6,
				R.drawable.greece7, R.drawable.greece8, R.drawable.greece9
				};
		Integer[] middle_east_i = {R.drawable.mideast1, R.drawable.mideast2, R.drawable.mideast3, 
				R.drawable.mideast4, R.drawable.mideast5, R.drawable.mideast6,
				R.drawable.mideast7, R.drawable.mideast8, R.drawable.mideast9
				};
		
		images.put(c.getString(R.string.egypt), egypt_i);
		images.put(c.getString(R.string.south_asia), south_asia_i);
		images.put(c.getString(R.string.greece), greece_i);
		images.put(c.getString(R.string.middle_east), middle_east_i);
		
		//set up thumbnails for exhibits
		Integer[] egypt_t = {R.drawable.egypt1s, R.drawable.egypt2s, R.drawable.egypt3s, 
				R.drawable.egypt4s, R.drawable.egypt5s, R.drawable.egypt6s,
				R.drawable.egypt7s, R.drawable.egypt8s, R.drawable.egypt9s
				};
		Integer[] south_asia_t = {R.drawable.southasia1s, R.drawable.southasia2s, R.drawable.southasia3s, 
				R.drawable.southasia4s, R.drawable.southasia5s, R.drawable.southasia6s,
				R.drawable.southasia7s, R.drawable.southasia8s, R.drawable.southasia9s
				};
		Integer[] greece_t = {R.drawable.greece1s, R.drawable.greece2s, R.drawable.greece3s, 
				R.drawable.greece4s, R.drawable.greece5s, R.drawable.greece6s,
				R.drawable.greece7s, R.drawable.greece8s, R.drawable.greece9s
				};
		Integer[] middle_east_t = {R.drawable.mideast1s, R.drawable.mideast2s, R.drawable.mideast3s, 
				R.drawable.mideast4s, R.drawable.mideast5s, R.drawable.mideast6s,
				R.drawable.mideast7s, R.drawable.mideast8s, R.drawable.mideast9s
				};
		
		thumbs.put(c.getString(R.string.egypt), egypt_t);
		thumbs.put(c.getString(R.string.south_asia), south_asia_t);
		thumbs.put(c.getString(R.string.greece), greece_t);
		thumbs.put(c.getString(R.string.middle_east), middle_east_t);
		
		//set up names for exhibits
		String[] egypt_n = {"Game Board for Senet", "Offering Table", "Mummy-case of Pedikhonsu",
				"Temple Relief of Senwosret I", "Statue of the Goddess Sakhmet", "Queen Hatshepsut as a Sphinx",
				"Hunting Scene", "Broad Collar", "Royal Scribe Bokennenife"
				};
		String[] south_asia_n = {"Untitled", "Seated Buddha", "Album Drawings of Life in the Punjab", 
				"Model of a South Indian temple as an Address Casket", "Hanging (Palampore)", "Yamantaka Vajrabhairava",
				"Scenes from the Life of Buddha", "Tea and Coffee Service", "Bhuj (elephant knife) and sheath"
				};
		String[] greece_n = {"Head of Silenos", "Greek-style leg Armour", "Etrusco-corinthian Neck-amphora",
				"Youthful Dionysos", "Kylix", "Torso of Aphrodite", "Gold Wreaths", "The Athena Parthenos",
				"Head of Young Herakles"
				};
		String[] middle_east_n = {"Amlash-style Mother Goddesses", "Ceremonial Suit of Armour", "Qur'ran",
				"Storage Vessel for Wine", "Vessel in the Form of a Bull", "Pair of Painted Cupboard Doors",
				"Torah Scroll and Case", "Axe-adze Combination Tool", "Parade Scene"
				};
		
		names.put(c.getString(R.string.egypt), egypt_n);
		names.put(c.getString(R.string.south_asia), south_asia_n);
		names.put(c.getString(R.string.greece), greece_n);
		names.put(c.getString(R.string.middle_east), middle_east_n);
	}

}
