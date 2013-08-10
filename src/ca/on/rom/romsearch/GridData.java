package ca.on.rom.romsearch;

import java.util.HashMap;

import android.content.Context;

public class GridData {
	
	public static HashMap<String, Integer[]> images = new HashMap<String, Integer[]>();
	public static HashMap<String, Integer[]> thumbs = new HashMap<String, Integer[]>();
	public static HashMap<String, String[]> names = new HashMap<String, String[]>();
	public static HashMap<String, Integer> titles = new HashMap<String, Integer>();
	public static HashMap<String, Integer> covers = new HashMap<String, Integer>();
	public static HashMap<String, String[]> words = new HashMap<String, String[]>(); //for dict
	
	public static Integer[] getImages(String exhibit) {
		return images.get(exhibit);
	}
	
	public static Integer[] getThumbs(String exhibit) {
		return thumbs.get(exhibit);
	}
	
	public static String[] getNames(String exhibit) {
		return names.get(exhibit);
	}
	
	public static int getTitle(String exhibit) {
		return titles.get(exhibit);
	}
	
	public static int getCover(String exhibit) {
		return covers.get(exhibit);
	}
	
	public static String[] getDictWords(String exhibit) {
		return words.get(exhibit);
	}
	
	public static void setupTables(Context c) {
		setupTitles(c);
		setupImages(c);
		setupThumbs(c);
		setupNames(c);
		setupCovers(c);
		setupWords(c);
	}
	
	private static void setupTitles(Context c) {
		titles.put(c.getString(R.string.egypt), R.drawable.titleegypt);
		titles.put(c.getString(R.string.south_asia), R.drawable.titlesouthasia);
		titles.put(c.getString(R.string.greece), R.drawable.titlegreece);
		titles.put(c.getString(R.string.middle_east), R.drawable.titlemiddleeast);
		titles.put(c.getString(R.string.korea), R.drawable.titlekorea);
		titles.put(c.getString(R.string.chinese_architecture), R.drawable.titlechinese_arch);
		titles.put(c.getString(R.string.nubia), R.drawable.titlenubia);
		titles.put(c.getString(R.string.china), R.drawable.titlechina);
		titles.put(c.getString(R.string.japan), R.drawable.titlejapan);
		titles.put(c.getString(R.string.chinese_sculpture), R.drawable.titlechinese_sculp);
		titles.put(c.getString(R.string.rome), R.drawable.titlerome);
		titles.put(c.getString(R.string.rome_and_near_east), R.drawable.titlerome_ne);
	}
	
	private static void setupImages(Context c) {
		Integer[] egypt = {R.drawable.egypt1, R.drawable.egypt2, R.drawable.egypt3, 
				R.drawable.egypt4, R.drawable.egypt5, R.drawable.egypt6,
				R.drawable.egypt7, R.drawable.egypt8, R.drawable.egypt9
				};
		Integer[] south_asia = {R.drawable.southasia1, R.drawable.southasia2, R.drawable.southasia3, 
				R.drawable.southasia4, R.drawable.southasia5, R.drawable.southasia6,
				R.drawable.southasia7, R.drawable.southasia8, R.drawable.southasia9
				};
		Integer[] greece = {R.drawable.greece1, R.drawable.greece2, R.drawable.greece3, 
				R.drawable.greece4, R.drawable.greece5, R.drawable.greece6,
				R.drawable.greece7, R.drawable.greece8, R.drawable.greece9
				};
		Integer[] middle_east = {R.drawable.mideast1, R.drawable.mideast2, R.drawable.mideast3, 
				R.drawable.mideast4, R.drawable.mideast5, R.drawable.mideast6,
				R.drawable.mideast7, R.drawable.mideast8, R.drawable.mideast9
				};
		Integer[] korea = {R.drawable.korea1, R.drawable.korea2, R.drawable.korea3,
				R.drawable.korea4, R.drawable.korea5, R.drawable.korea6,
				R.drawable.korea7, R.drawable.korea8, R.drawable.korea9
				};
		Integer[] chinese_architecture = {R.drawable.chinese_arch1, R.drawable.chinese_arch2, R.drawable.chinese_arch3,
				R.drawable.chinese_arch4, R.drawable.chinese_arch5, R.drawable.chinese_arch6,
				R.drawable.chinese_arch7, R.drawable.chinese_arch8, R.drawable.chinese_arch9
				};
		Integer[] nubia = {R.drawable.nubia1, R.drawable.nubia2, R.drawable.nubia3,
				R.drawable.nubia4, R.drawable.nubia5, R.drawable.nubia6, 
				R.drawable.nubia7, R.drawable.nubia8, R.drawable.nubia9
				};
		Integer[] china = {R.drawable.china1, R.drawable.china2, R.drawable.china3,
				R.drawable.china4, R.drawable.china5, R.drawable.china6, 
				R.drawable.china7, R.drawable.china8, R.drawable.china9
				};
		Integer[] japan = {R.drawable.japan1, R.drawable.japan2, R.drawable.japan3,
				R.drawable.japan4, R.drawable.japan5, R.drawable.japan6, 
				R.drawable.japan7, R.drawable.japan8, R.drawable.japan9
				};
		Integer[] chinese_sculpture = {R.drawable.chinese_sculp1, R.drawable.chinese_sculp2, R.drawable.chinese_sculp3,
				R.drawable.chinese_sculp4, R.drawable.chinese_sculp5, R.drawable.chinese_sculp6, 
				R.drawable.chinese_sculp7, R.drawable.chinese_sculp8, R.drawable.chinese_sculp9
				};
		Integer[] rome = {R.drawable.rome1, R.drawable.rome2, R.drawable.rome3,
				R.drawable.rome4, R.drawable.rome5, R.drawable.rome6, 
				R.drawable.rome7, R.drawable.rome8, R.drawable.rome9
				};
		Integer[] rome_and_near_east = {R.drawable.rome_ne1, R.drawable.rome_ne2, R.drawable.rome_ne3,
				R.drawable.rome_ne4, R.drawable.rome_ne5, R.drawable.rome_ne6, 
				R.drawable.rome_ne7, R.drawable.rome_ne8, R.drawable.rome_ne9
				};
		
		images.put(c.getString(R.string.egypt), egypt);
		images.put(c.getString(R.string.south_asia), south_asia);
		images.put(c.getString(R.string.greece), greece);
		images.put(c.getString(R.string.middle_east), middle_east);
		images.put(c.getString(R.string.korea), korea);
		images.put(c.getString(R.string.chinese_architecture), chinese_architecture);
		images.put(c.getString(R.string.nubia), nubia);
		images.put(c.getString(R.string.china), china);
		images.put(c.getString(R.string.japan), japan);
		images.put(c.getString(R.string.chinese_sculpture), chinese_sculpture);
		images.put(c.getString(R.string.rome), rome);
		images.put(c.getString(R.string.rome_and_near_east), rome_and_near_east);
		
	}
	
	private static void setupThumbs(Context c) {
		Integer[] egypt = {R.drawable.egypt1s, R.drawable.egypt2s, R.drawable.egypt3s, 
				R.drawable.egypt4s, R.drawable.egypt5s, R.drawable.egypt6s,
				R.drawable.egypt7s, R.drawable.egypt8s, R.drawable.egypt9s
				};
		Integer[] south_asia = {R.drawable.southasia1s, R.drawable.southasia2s, R.drawable.southasia3s, 
				R.drawable.southasia4s, R.drawable.southasia5s, R.drawable.southasia6s,
				R.drawable.southasia7s, R.drawable.southasia8s, R.drawable.southasia9s
				};
		Integer[] greece = {R.drawable.greece1s, R.drawable.greece2s, R.drawable.greece3s, 
				R.drawable.greece4s, R.drawable.greece5s, R.drawable.greece6s,
				R.drawable.greece7s, R.drawable.greece8s, R.drawable.greece9s
				};
		Integer[] middle_east = {R.drawable.mideast1s, R.drawable.mideast2s, R.drawable.mideast3s, 
				R.drawable.mideast4s, R.drawable.mideast5s, R.drawable.mideast6s,
				R.drawable.mideast7s, R.drawable.mideast8s, R.drawable.mideast9s
				};
		Integer[] korea = {R.drawable.korea1s, R.drawable.korea2s, R.drawable.korea3s,
				R.drawable.korea4s, R.drawable.korea5s, R.drawable.korea6s,
				R.drawable.korea7s, R.drawable.korea8s, R.drawable.korea9s
				};
		Integer[] chinese_architecture = {R.drawable.chinese_arch1s, R.drawable.chinese_arch2s, R.drawable.chinese_arch3s,
				R.drawable.chinese_arch4s, R.drawable.chinese_arch5s, R.drawable.chinese_arch6s,
				R.drawable.chinese_arch7s, R.drawable.chinese_arch8s, R.drawable.chinese_arch9s
				};
		Integer[] nubia = {R.drawable.nubia1s, R.drawable.nubia2s, R.drawable.nubia3s,
				R.drawable.nubia4s, R.drawable.nubia5s, R.drawable.nubia6s, 
				R.drawable.nubia7s, R.drawable.nubia8s, R.drawable.nubia9s
				};
		Integer[] china = {R.drawable.china1s, R.drawable.china2s, R.drawable.china3s,
				R.drawable.china4s, R.drawable.china5s, R.drawable.china6s, 
				R.drawable.china7s, R.drawable.china8s, R.drawable.china9s
				};
		Integer[] japan = {R.drawable.japan1s, R.drawable.japan2s, R.drawable.japan3s,
				R.drawable.japan4s, R.drawable.japan5s, R.drawable.japan6s, 
				R.drawable.japan7s, R.drawable.japan8s, R.drawable.japan9s
				};
		Integer[] chinese_sculpture = {R.drawable.chinese_sculp1s, R.drawable.chinese_sculp2s, R.drawable.chinese_sculp3s,
				R.drawable.chinese_sculp4s, R.drawable.chinese_sculp5s, R.drawable.chinese_sculp6s, 
				R.drawable.chinese_sculp7s, R.drawable.chinese_sculp8s, R.drawable.chinese_sculp9s
				};
		Integer[] rome = {R.drawable.rome1s, R.drawable.rome2s, R.drawable.rome3s,
				R.drawable.rome4s, R.drawable.rome5s, R.drawable.rome6s, 
				R.drawable.rome7s, R.drawable.rome8s, R.drawable.rome9s
				};
		Integer[] rome_and_near_east = {R.drawable.rome_ne1s, R.drawable.rome_ne2s, R.drawable.rome_ne3s,
				R.drawable.rome_ne4s, R.drawable.rome_ne5s, R.drawable.rome_ne6s, 
				R.drawable.rome_ne7s, R.drawable.rome_ne8s, R.drawable.rome_ne9s
				};
		
		thumbs.put(c.getString(R.string.egypt), egypt);
		thumbs.put(c.getString(R.string.south_asia), south_asia);
		thumbs.put(c.getString(R.string.greece), greece);
		thumbs.put(c.getString(R.string.middle_east), middle_east);
		thumbs.put(c.getString(R.string.korea), korea);
		thumbs.put(c.getString(R.string.chinese_architecture), chinese_architecture);
		thumbs.put(c.getString(R.string.nubia), nubia);
		thumbs.put(c.getString(R.string.china), china);
		thumbs.put(c.getString(R.string.japan), japan);
		thumbs.put(c.getString(R.string.chinese_sculpture), chinese_sculpture);
		thumbs.put(c.getString(R.string.rome), rome);
		thumbs.put(c.getString(R.string.rome_and_near_east), rome_and_near_east);
	}
	
	private static void setupNames(Context c) {
		String[] egypt = {"Game Board for Senet", "Offering Table", "Mummy-case of Pedikhonsu",
				"Temple Relief of Senwosret I ((?))", "Statue of the Goddess Sakhmet", "Queen Hatshepsut as a Sphinx",
				"Hunting Scene", "Broad Collar", "Royal Scribe Bokennenife"
				};
		String[] south_asia = {"Untitled", "Seated Buddha", "Album Drawing<s> of Life in the Punjab", 
				"Model of a South Indian temple as an Address Casket", "Hanging/Palampore", "Yamantaka Vajrabhairava",
				"Scene<s> from the Life of Buddha", "Tea and Coffee Service", "Bhuj/elephant_knife and sheath"
				};
		String[] greece = {"Head of Silenos", "Greek-style leg Armour", "Etrusco-corinthian Neck-amphora",
				"Youthful Dionysos", "Kylix", "Torso of Aphrodite", "Gold Wreath<s>", "The Athena Parthenos",
				"Head of Young Herakles"
				};
		String[] middle_east = {"Amlash-style Mother Goddess<es>", "Ceremonial Suit of Armour", "Qur'ran",
				"Storage Vessel for Wine", "Vessel in the Form of a Bull", "Pair of Painted Cupboard Door<s>",
				"Torah Scroll and Case", "Axe-adze Combination Tool", "Parade Scene"
				};
		String[] korea = {"Bronze Mirror<s>", "Memorial inscription for Yi Sim-Won",
				"Printing block for Namjaego/\"Writings_by_Namjae\"", "Pedestalled globular jar",
				"Kim Ki Moon ((artist name Baik Ha, 1906-1989))", "Standing Buddha on a lotus dais", "Jwagyeong/cosmetic_box",
				"Jar and Cover, titled \"Happy Jump\"", "Faceted folk tradition jar"
				};
		String[] chinese_architecture = {"(Five) tiles from Xiuding Monastery, (Anyang)", "Tomb of Zuo Biao",
				"Decorated ridge tile", "Military official", "House with three courtyards", "Procession of tomb figure<s>",
				"Yanluo, King of Hell", "Carved panels of tomb gate", "Granary"
				};
		String[] nubia = {"Enigmatic Object", "Nubian Neolithic Culture artifact<s>", "Front Panel of a decorated Wooden Box",
				"Faience Column Base", "Broken Stela inscribed in Meroitic", "Beer Jar", "Bead Necklace", "Religious symbol<s>",
				"Statue of the god Nefertem"
				};
		String[] china = {"Tomb tile: winged guardian", "Swatow ware basin", "Tomb figures",
				"Camel and rider", "Mirror with four mythical animals", "Cizhou ware pillow", "Throne",
				"Vairochana Buddha", "Yongzhong-type bell"
				};
		String[] japan = {"Album of paintings", "Ko-Imari style lidded jar", "Helmet with frontal kuwagata",
				"Shinto male diety", "Miroku_Boatsu/Maitreya_Bodhisattva", "Suit of armour", "Negoro-type ewer",
				"Unit 88-9", "Female Ghost"
				};
		String[] chinese_sculpture = {"Luohan", "(Two) Luohans", "Head of a monk", "Buddhist stele",
				"Buddha and attendants", "Amitabha Buddha", "Guardian lion", "Guanyin on a dragon throne",
				"Tablet with 153 Buddhas"
				};
		String[] rome = {"Coin Hoard from Egypt", "Co-Emperor Lucius Versus", "(Small) Fragmentary Pediment",
				"Mummy Mask of a Woman", "\"Spectaclae\" Fibula", "(Limestone) Cinerary Chest (from_Chiusi)",
				"Mother and Child", "Gladiator's Helmet", "Shield_Boss/clipeata_imago"
				};
		String[] rome_and_near_east = {"Byzantine Floor Mosiac", "Donor Figure of a kneeling Woman",
				"Tomb relief of a man", "Floor Mosiac fragment with a lion", "Head of Zeus", "Tall flagon",
				"Core-wound amphoriskos", "Steelyard Weight in the form of a bust of Athena", 
				"Byzantine Processional Cross with Medallion of Christ"
				};
		
		names.put(c.getString(R.string.egypt), egypt);
		names.put(c.getString(R.string.south_asia), south_asia);
		names.put(c.getString(R.string.greece), greece);
		names.put(c.getString(R.string.middle_east), middle_east);
		names.put(c.getString(R.string.korea), korea);
		names.put(c.getString(R.string.chinese_architecture), chinese_architecture);
		names.put(c.getString(R.string.nubia), nubia);
		names.put(c.getString(R.string.china), china);
		names.put(c.getString(R.string.japan), japan);
		names.put(c.getString(R.string.chinese_sculpture), chinese_sculpture);
		names.put(c.getString(R.string.rome), rome);
		names.put(c.getString(R.string.rome_and_near_east), rome_and_near_east);
	}
	
	private static void setupCovers(Context c) {
		covers.put(c.getString(R.string.egypt), R.drawable.egypt3s);
		covers.put(c.getString(R.string.south_asia), R.drawable.southasia2s);
		covers.put(c.getString(R.string.greece), R.drawable.greece4s);
		covers.put(c.getString(R.string.middle_east), R.drawable.mideast7s);
		covers.put(c.getString(R.string.korea), R.drawable.korea5s);
		covers.put(c.getString(R.string.chinese_architecture), R.drawable.chinese_arch9s);
		covers.put(c.getString(R.string.nubia), R.drawable.nubia3s);
		covers.put(c.getString(R.string.china), R.drawable.china3s);
		covers.put(c.getString(R.string.japan), R.drawable.japan6s);
		covers.put(c.getString(R.string.chinese_sculpture), R.drawable.chinese_sculp1s);
		covers.put(c.getString(R.string.rome), R.drawable.rome2s);
		covers.put(c.getString(R.string.rome_and_near_east), R.drawable.rome_ne1s);
	}
	
	private static void setupWords(Context c) {
		String[] egypt = {"Pedikhonsu", "Senwosret", "Sakhmet", "Hatshepsut", "Bokennenife"
				};
		String[] south_asia = {"bhuj", "Yamantaka", "Vajrabhairava", "palampore"
				};
		String[] greece = {"etrusco", "etrusco-corinthian", "neck-amphora", "amphora", "kylix", 
				"Dionysos", "Herakles", "parthenos", "Silenos"
				};
		String[] middle_east = {"amlash", "axe-adze", "adze", "Qur'ran"
				};
		String[] korea = {"Yi", "Sim-Won", "Namjaego", "Namjae", "dais", "Jwagyeong", "Ki", "Baik"
				};
		String[] chinese_architecture = {"Xiuding", "Anyang", "Zuo", "Biao", "Yanluo",
				};
		String[] nubia = {"Faience", "Stela", "Meroitic", "Nefertem"
				};
		String[] china = {"Swatow", "Cizhou", "Vairochana", "Yongzhong", "Yongzhong-type",
				};
		String[] japan = {"Ko-Imari", "Ko", "Imari", "kuwagata", "Shinto", "Miroku", "Boatsu",
				"Maitreya", "Bodhisattva", "Negoro", "Negoro-type", "ewer"
				};
		String[] chinese_sculpture = {"Luohan", "luohan", "stele", "Amitabha", "Guanyin"
				};
		String[] rome = {"Spectaclae", "Chiusi", "clipeata", "imago"
				};
		String[] rome_and_near_east = {"Byzantine", "amphoriskos"
				};
		

		words.put(c.getString(R.string.egypt), egypt);
		words.put(c.getString(R.string.south_asia), south_asia);
		words.put(c.getString(R.string.greece), greece);
		words.put(c.getString(R.string.middle_east), middle_east);
		words.put(c.getString(R.string.korea), korea);
		words.put(c.getString(R.string.chinese_architecture), chinese_architecture);
		words.put(c.getString(R.string.nubia), nubia);
		words.put(c.getString(R.string.china), china);
		words.put(c.getString(R.string.japan), japan);
		words.put(c.getString(R.string.chinese_sculpture), chinese_sculpture);
		words.put(c.getString(R.string.rome), rome);
		words.put(c.getString(R.string.rome_and_near_east), rome_and_near_east);
	}
}
