// TheFluffyUnicorns
// Roster: Taaseen Ali, Puneet Johal, Sophia Xia
// APCS1 pd1
// HW23 -- Etterbay Odingcay Oughthray Ollaborationcay
// 2017-10-25

/*
 * Additional Methods and Exceptions: 1. The Letter Y a) Treat it as a vowel
 * when it makes the "i" or "e" sound: typically happens when it is at the end
 * of a word and is the only vowel in the word 2. Translating Sentences: a)
 * Keeping punctuation and other special symbols, such as hyphens and
 * apostrophies b) Leaving whitespace unaffected 3. Moving "qu" together, even
 * though it isn't a consonant blend 4. Three letter consonant blends
 */

/***
 * class Pig a Pig Latin translator ~~~~~~~~~~~~~~~~~~~ SKELETON
 * ~~~~~~~~~~~~~~~~~~~ 9 ,--.-'-,--. \ /-~-\ / / )' a a `( \ ( ( ,---. ) ) \
 * `(_o_o_)' / \ `-' / | |---| | [_] [_] PROTIP: Make this class compilable
 * first, then develop and test one method at a time. NEVER STRAY TOO FAR FROM
 * COMPILABILITY/RUNNABILITY!
 ***/

import java.util.Scanner;

public class Pig {

	// Instance Vars
	// ==========================================================================

	// Q: How does this initialization make your life easier?
	// I can reference VOWELS instead of coding for all the vowels separately
	// or coding for the vowels in every method
	// easier to just have it up here for all the methods to use

	private static final String VOWELS = "aeiouyAEIOUY";
	private static final String PUNCTUATION = ",.!:;";
	private static final String SP_PUNCTUATION = "+-@ ";
	private static int Ctr;
	// used in countVowels
	private static String holder;
	// used in allVowels

	/*
	 * ===================================== boolean hasA(String,String) --
	 * checks for a letter in a String pre: w != null, letter.length() == 1
	 * post: hasA("cat", "a") -> true hasA("cat", "p") -> false
	 * =====================================
	 */
	public static boolean hasA(String w, String letter) {
		// checks if letter is in string
		if (w.indexOf(letter) == -1) {
			return false;
		}
		return true;
	}// end hasA()

	/*
	 * ===================================== boolean isAVowel(String) -- tells
	 * whether a letter is a vowel precondition: letter.length() == 1
	 * =====================================
	 */
	public static boolean isAVowel(String letter) {
		if (VOWELS.indexOf(letter) == -1) {
			return false;
		}
		return true;
	}// end isAVowel

	/*
	 * ===================================== int countVowels(String) -- counts
	 * vowels in a String pre: w != null post: countVowels("meatball") -> 3
	 * =====================================
	 */
	public static int countVowels(String w) {
		for (Ctr = 0; w.length() != 0; w = w.substring(1, w.length())) {
			if (VOWELS.indexOf(w.substring(0, 1)) != -1) {
				Ctr++;
			}
		}
		return Ctr;
	}// end CountVowels

	/*
	 * ===================================== boolean hasAVowel(String) -- tells
	 * whether a String has a vowel pre: w != null post: hasAVowel("cat") ->
	 * true hasAVowel("zzz") -> false =====================================
	 */
	public static boolean hasAVowel(String w) {
		// lazy... so I just called countVowels
		if (countVowels(w) > 0) {
			return true;
		}
		return false;
	}

	/*
	 * ===================================== String allVowels(String) -- returns
	 * vowels in a String pre: w != null post: allVowels("meatball") -> "eaa"
	 * =====================================
	 */
	// copied code for countVowels and slightly altered it to add the vowels to
	// a string
	// again, I'm lazy
	public static String allVowels(String w) {
		for (holder = ""; w.length() != 0; w = w.substring(1, w.length())) {
			if (VOWELS.indexOf(w.substring(0, 1)) != -1) {
				holder = holder + w.substring(0, 1);
			}
		}
		return holder;
	}

	// --------------------------------------------------------------------------------------------------------------------------------------------------------------

	// firstVowel method

	// pre: w != null
	// post: firstVowel("") --> ""
	// firstVowel("zzz") --> ""
	// firstVowel("meatball") --> "e"
	public static String firstVowel(String w) {
		if (allVowels(w).length() > 0) {
			return allVowels(w).substring(0, 1);
		}
		return "";
	}

	// beginsWithVowel method

	// pre: w != null and w.length() > 0
	// post: beginsWithVowel("apple") --> true
	// beginsWithVowel("strong") --> false
	public static boolean beginsWithVowel(String w) {
		return isAVowel(w.substring(0, 1));
	}

	public static boolean hasPunctuation(String w){
		for(int i=0; i<PUNCTUATION.length(); i++){
			String punc = PUNCTUATION.substring(i,i+1);
			if(hasA(w, punc)) return true;
		}
		return false;
	}
	
	public static String getSpPunct(String w){
		for(int i=0; i<SP_PUNCTUATION.length(); i++){
			String punc = SP_PUNCTUATION.substring(i,i+1);
			if(hasA(w, punc)) return punc;
		}
		return "";
	}
	
	// engToPig method

	// pre: w.length() > 0
	// post: engToPig("apple") --> "appleway"
	// engToPig("strong") --> "ongstray"
	// engToPig("java") --> "avajay"

	public static String getStartingConsonants(String w) {
		if (w.substring(0, 1).toLowerCase().equals("y")) {
			return w.substring(0, w.indexOf(allVowels(w).substring(1, 2)));
		}

		return w.substring(0, w.indexOf(firstVowel(w)));
	}

	public static String engToPigWord(String w) {
		String startingCons = getStartingConsonants(w), punc = "";
		int lastConsIndex = startingCons.length(); //index on w after the starting consonants
		
		if (startingCons.equals("")) { //if word starts with a vowel
			return w + "way";
		}
		
		String firstLetter = startingCons.substring(0,1);
		boolean isCapitalized = firstLetter.equals(firstLetter.toUpperCase());
		if(hasPunctuation(w)){
			punc = w.substring(w.length()-1);
			w = w.substring(0,w.length()-1);
		}
		
		if(isCapitalized){
			return w.substring(lastConsIndex, lastConsIndex+1).toUpperCase() + w.substring(lastConsIndex+1) + startingCons.toLowerCase() + "ay" + punc; 
		}
		else {
			return w.substring(lastConsIndex) + startingCons + "ay" + punc;//append the word without the starting cons + the starting cons at the end + "ay"
		}
		
	}
	
	public static String engToPig(String w){
		String sentence = w, retStr = "";
		
		String space = getSpPunct(w);
		int index=0;
		
		while(!space.equals("")){
			index = sentence.indexOf(space);
			retStr += engToPigWord(sentence.substring(0,index)) + space;
			sentence = sentence.substring(index+1);
			space = getSpPunct(sentence);
		}
		retStr += engToPigWord(sentence);
		
		return retStr;
	}		
		
		/*int space = sentence.indexOf(" ");
				
		for(space = sentence.indexOf(" "); space!=-1; space=sentence.indexOf(" ")){
			retStr += engToPigWord(sentence.substring(0,space)) + " ";
			sentence = sentence.substring(sentence.indexOf(" ")+1);
		}*/
		

	// Main Method
	// ==========================================================================

	public static void main(String[] args) {

		System.out.println("===============hasA===============");
		System.out.println(hasA("dictionary", "a")); // true
		System.out.println(hasA("cat", "a")); // true
		System.out.println(hasA("cat", "p")); // false
		System.out.println(hasA("aaaabaaa", "b")); // true
		System.out.println(hasA("aaaabaaa", "a")); // true
		System.out.println(hasA("", "b")); // false
		System.out.println(hasA("sadjkds", "sad")); // false
		System.out.println(hasA("word", "w")); // true
		System.out.println(hasA("myname", "p")); // false
		System.out.println(hasA("uhoh", "h")); // true
		System.out.println(hasA("", "i")); // false
		System.out.println("");

		System.out.println("===============isAVowel===============");
		System.out.println(isAVowel("a")); // true
		System.out.println(isAVowel("b")); // false
		System.out.println(isAVowel("a")); // true
		System.out.println(isAVowel("b")); // false
		System.out.println(isAVowel("i")); // true
		System.out.println(isAVowel("42"));// false
		System.out.println(isAVowel("U")); // false
		System.out.println("");

		System.out.println("===============countVowels===============");
		System.out.println(countVowels("cat")); // 1
		System.out.println(countVowels("hmmmmmm")); // 0
		System.out.println(countVowels("dictionary")); // 4
		System.out.println(countVowels("aaaa")); // 4
		System.out.println(countVowels("aaab")); // 3
		System.out.println(countVowels("aace")); // 3
		System.out.println(countVowels("dddd")); // 0
		System.out.println(countVowels("vowel")); // 2
		System.out.println(countVowels("gym")); // 0
		System.out.println(countVowels("")); // 0
		System.out.println("");

		System.out.println("===============hasAVowel===============");
		System.out.println(hasAVowel("cat")); // true
		System.out.println(hasAVowel("zzz")); // false
		System.out.println(hasAVowel("abcd")); // true
		System.out.println(hasAVowel("bcd")); // false
		System.out.println(hasAVowel("")); // false
		System.out.println(hasAVowel("dub")); // true
		System.out.println(hasAVowel("vowel")); // true
		System.out.println(hasAVowel("gym")); // false
		System.out.println("");

		System.out.println("===============allVowels===============");
		System.out.println(allVowels("cat")); // a
		System.out.println(allVowels("zzz")); // ""
		System.out.println(allVowels("dictionary")); // iioa
		System.out.println(allVowels("aaab")); // aaa
		System.out.println(allVowels("aeioub")); // aeiou
		System.out.println(allVowels("nnnnbh")); // ""
		System.out.println(allVowels("abebibobu")); // aeiou
		System.out.println(allVowels("vowel")); // oe
		System.out.println(allVowels("Has he hit you?")); // aeiou
		System.out.println(allVowels("gym")); // empty string
		System.out.println(allVowels("")); // empty string
		System.out.println("");

		System.out.println("===============firstVowel===============");
		System.out.println(firstVowel("cat")); // a
		System.out.println(firstVowel("zzz")); // ""
		System.out.println(firstVowel("dictionary")); // i
		System.out.println(firstVowel("action")); // a
		System.out.println("");

		System.out.println("===============beginsWithVowel===============");
		System.out.println(beginsWithVowel("cat")); // false
		System.out.println(beginsWithVowel("zzz")); // false
		System.out.println(beginsWithVowel("dictionary")); // false
		System.out.println(beginsWithVowel("action")); // true
		System.out.println("");

		System.out.println("===============engToPig===============");
		System.out.println(engToPig("cat")); // atcay
		System.out.println(engToPig("zzz")); // zzzay
		System.out.println(engToPig("dictionary")); // ictionaryday
		System.out.println(engToPig("imbecile")); // imbecileway
		System.out.println(engToPig("that")); // atthay
		System.out.println(engToPig("shoot")); // ootshay
		System.out.println(engToPig("better")); // etterbay
		System.out.println(engToPig("coding")); // odingcay
		System.out.println(engToPig("through")); // roughthay
		System.out.println(engToPig("collaboration")); // ollaborationcay
		System.out.println(engToPig("Through, Scrap Trap")); // ollaborationcay
		System.out.println(engToPig("Many, puntuation's; in this: sentence.")); // ollaborationcay
		//System.out.println(engToPig("Wait - you're -Um hello?")); 
		System.out.println(engToPig("Through, Scrap Trap")); // ollaborationcay
		System.out.println(engToPig("(hello)")); // ollaborationcay
		System.out.println(getStartingConsonants("hello"));
		System.out.println(getStartingConsonants("there"));
		System.out.println(getStartingConsonants("through"));
		System.out.println(getStartingConsonants("emacs"));
		System.out.println(getStartingConsonants("yello"));
		System.out.println(getStartingConsonants("yvone"));
		System.out.println("===============Command line args===============");
		String toTranslate = "";
		for(String word: args){
	    	toTranslate += word + " ";
		}
		if (toTranslate.length() > 0){	
	    	System.out.println(engToPig(toTranslate.substring(0,toTranslate.length()-1)));
		}
		System.out.println("===============Scanner===============");
		// scanner function - takes an input either from the command line or as
		// a file and prints out
		Scanner sc = new Scanner(System.in);
		

		while (sc.hasNext()) {
			String word = sc.next();
			System.out.println(word + ": " + engToPig(word));
		}

	}// end main()

}// end class Pig