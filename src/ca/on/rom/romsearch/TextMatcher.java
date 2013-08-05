package ca.on.rom.romsearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;


public class TextMatcher {
	
	private static final String[] CONNECTORS = {"a", "an", "as", "of", "the", "for"};
	
	public static boolean TextMatch(String input, String master) {
		//tokenize input and get answers
		ArrayList<String> itokens_orig = new ArrayList<String>(Arrays.asList(input.toLowerCase(Locale.getDefault()).split(" |\\-")));
		ArrayList<String> itokens = new ArrayList<String>(itokens_orig); //copy to work with
		//format for matching
		removePunctuation(itokens);
		removeBanned(itokens, CONNECTORS);
		ArrayList<ArrayList<String>> answers = getAnswers(master);
		//check input against all combinations in answers
		comboloop :
		for (ArrayList<String> mtokens : answers) {
			//return false if input is longer than master 
			//(allowing for a 1 margin of error (e.g. rogue "a"))
			if (itokens_orig.size() > mtokens.size() + 1) {
				continue;
			}
			//format for matching
			removePunctuation(mtokens);
			removeBanned(mtokens, CONNECTORS);
			//check to see if all key words are shared
			ArrayList<String> itokens_copy = new ArrayList<String>(itokens);
			for (int i = 0; i < mtokens.size(); i++) {
				String item = mtokens.get(i);
				if (itokens_copy.contains(item)) {
					itokens_copy.remove(item);
				} else {
					continue comboloop;
				}
			}
			if (itokens_copy.size() > 0) {
				continue;
			}
			return true;
		}
		return false;
	}
	
	private static ArrayList<ArrayList<String>> getAnswers(String master) {
		ArrayList<ArrayList<String>> combinations = new ArrayList<ArrayList<String>>();
		ArrayList<String> regular = new ArrayList<String>();
		ArrayList<String> optional = new ArrayList<String>();
		ArrayList<String> alternate = new ArrayList<String>();
		String[] mtokens = master.toLowerCase(Locale.getDefault()).split("[ |\\-]");
		//sort tokens
		for (String token : mtokens) {
			if (token.contains("/")) {
				alternate.add(token);
			} else if (token.contains("(")) {
				optional.add(token);
			} else {
				//regular
				regular.add(token);
			}
		}
		//create all possible combinations
		if (alternate.isEmpty()) {
			combinations.add(regular);
			for (int i = 0; i < optional.size(); i++) {
				String token = optional.get(i);
				//trim the leading and trailing brackets
				token = token.substring(token.indexOf("(") + 1, token.lastIndexOf(")"));
				//split in the case of two words, and all them all the regular words
				ArrayList<String> combo = new ArrayList<String>(Arrays.asList(token.split("_")));
				combo.addAll(regular);
				combinations.add(combo);
			}
		} else if (optional.isEmpty()) {
			ArrayList<ArrayList<String>> combos = new ArrayList<ArrayList<String>>();
			ArrayList<String> all = new ArrayList<String>();
			combos.add(regular);
			all.addAll(regular);
			//if you have to read this code, I'm sorry. Combinational explosion sucks.
			for (int i = 0; i < alternate.size(); i++) {
				combos.addAll(deepCopy(combos));
				String token = alternate.get(i);
				String[] alternates = token.split("/");
				all.addAll(Arrays.asList(alternates[0].split("_")));
				all.addAll(Arrays.asList(alternates[1].split("_")));
				//alternate adding the tokens
				for (int j = 0; j < combos.size(); j++) {
					if (j < combos.size()/2) {
						combos.get(j).addAll(Arrays.asList(alternates[0].split("_")));
					} else {
						combos.get(j).addAll(Arrays.asList(alternates[1].split("_")));
					}
				}
			}
			combinations.addAll(combos);
			combinations.add(all);
		}
		return combinations;
	}
	
	private static ArrayList<ArrayList<String>> deepCopy(ArrayList<ArrayList<String>> list) {
		ArrayList<ArrayList<String>> newlist = new ArrayList<ArrayList<String>>();
		for (ArrayList<String> item : list) {
			ArrayList<String> newitem = new ArrayList<String>();
			newitem.addAll(item);
			newlist.add(newitem);
		}
		return newlist;
	}
	
	/*
	 * Remove words from String[] banned from ArrayList<String> tokens
	 */
	private static void removeBanned(ArrayList<String> tokens, String[] banned) {
		for (int i = 0; i < tokens.size(); i++) {
			String t = tokens.get(i);
			//remove tokens if in banned
			for (int j = 0; j < banned.length; j++) {
				if (t.equals(banned[j])) {
					tokens.remove(t);
					break;
				}
			}
		}
	}
	
	private static void removePunctuation(ArrayList<String> tokens) {
		for (int i = 0; i < tokens.size(); i++) {
			String token = tokens.get(i);
			//token.replaceFirst("^[^a-zA-Z]+", "");
			//token.replaceAll("[^a-zA-Z]+$", "");
			if (token.contains("(")) {
				token = token.replaceFirst("\\(", "");
			} if (token.contains(")")) {
				token = token.replaceFirst("\\)", "");
			}
			tokens.set(i, token);
		}
	}
	
	public static String format(String master) {
		StringBuilder formatted = new StringBuilder();
		ArrayList<String> tokens = new ArrayList<String>(Arrays.asList(master.split(" ")));
		removePunctuation(tokens);
		for (String token : tokens) {
			if (token.contains("_")) {
				token = token.replaceFirst("_", " ");
			}
			if (token.contains("/")) {
				String[] alternate = token.split("/");
				alternate[1] = "(" + alternate[1] + ")";
				token = alternate[0] + " " + alternate[1];
			}
			formatted.append(token + " ");
		}
		//delete last extra space
		formatted.deleteCharAt(formatted.lastIndexOf(" "));
		return formatted.toString();
	}
}
