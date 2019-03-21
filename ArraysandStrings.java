/**
 * Has solution to Chapter 1: Arrays and Strings
 * Each solution is a method
 * @author Ashily Varghese
 *
 */
public class ArraysandStrings {

	/**
 * Answer 1.2
 * This takes a C-string and reverses it
 * @param str String array with chars of the string
 * @return reverse String array with the reversed string
 */
	public static String[] reverseString(String[] str){
		String temp = (String) null;
		int size = str.length;
		for(int i=0; i<=size/2; i++){
			temp = str[i];
			str[i] = str[size-1-i];
			str[size-1-i] = temp;
		}
		return str;
	}
/**
 * Answer 1.3
 * @param str
 * @return string with no duplicate characters 
 */
	public static String removeDuplicates(String str){
		int size = str.length();
			for(int i=0; i<size-1; i++){
				for(int j=i+1; j<size; j++){
					if(str.charAt(j) == str.charAt(i))
						str.replace(Character.toString(str.charAt(j)),"");
						
				}
			}
		
		return str;
	}
/**
 * Answer 1.3
 * Code from the book
 */
	public static char[] removeDuplicates(char[] str){
		if(str == null) return null;
		int len = str.length;
		if(len < 2) return str;
		
		int tail = 1;
		
		for(int i = 1; i < len; i++){
			int j;
			for(j = 0; j < tail; ++j){
				if (str[i] == str[j]) break;
			}
			if(j == tail){
				str[tail] = str[i];
				++tail;
			}
		}
		str[tail] = 0;
		return str;
	}
	
	
/**
 * Answer 1.4 (final answer)
 * This checks to see if two strings are anagrams by adding 
 * the ascii values of two strings
 * @param s first string
 * @param t second string
 * @return a boolean value of true if the strings are anagrms
 */

	public static boolean areAnagram(String s, String t){
		int sum1 = 0; 
		int sum2 = 0;
		int ascii1, ascii2;
		
		// removing white spaces
		s = s.replaceAll(" ", "");
		t = t.replaceAll(" ", "");
		int length1 = s.length();
		int length2 = t.length();
		
		// checking length
		if(length1 != length2) {
			return false;
		}else{
			for(int a=0; a<length1; a++){
				// First string
				ascii1 = (int)s.charAt(a);
				// if the letters are capital then add 32
				if(65 <= ascii1  && ascii1 <= 90){
					sum1 = sum1 + ascii1 +  32;
				}else{
					sum1 = sum1 + ascii1;
				}
				
				// Second string
				ascii2 = (int)t.charAt(a);
				if(65 <= ascii2  && ascii2 <= 90){
					sum2 = sum2 + ascii2 +  32;
				}else{
					sum2 = sum2 + ascii2;
				}
			}
			
			if(sum1 == sum2) {
				return true;
			}else return false;
		}
	}
	
/**
 * Answer 1.4
 * Code from the book
 */
	public static boolean anagram(String s, String t){
		if(s.length() != t.length()) return false;
		int[] letters = new int[256];
		int num_unique_chars = 0;
		int num_completed_t = 0;
		char[] s_array = s.toCharArray();
		for(char c : s_array){
			System.out.println("c is " + c);
			System.out.println("letters[c] is " + letters[c]);
			if(letters[c] == 0) ++num_unique_chars;
			++letters[c];
			System.out.println("letters[c] is " + letters[c]);
		}
		
		for(int i = 0; i< t.length(); ++i){
			int c = (int) t.charAt(i);
			if(letters[c] == 0) return false;
			--letters[c];
		}
		return false;
		
	}
/**
 * 1.4 Edition 6
 * This method checks to see if a string is a permutation of a palindrome	
 * @param s is the input string
 * 
 */
	public static boolean isPalindromePermutation(String s){
		int[] table = charFrequency(s);
		boolean answer = checkMaxOdd(table);
		return answer;
	}
	
	public static boolean checkMaxOdd(int[] table){
		int countOdd = 0;
		for(int j = 0; j < 35; j++){
			if(table[j] % 2 == 1){
				countOdd++;
			}
		}
		if(countOdd > 1)
			return false;
		else
			return true;
	}
	
	public static int[] charFrequency(String s){
		String str = s.replace(" ", "");
		int[] table = new int[35]; 
		
		for(int i = 0; i < str.length(); i++){
			int asciivalue = (int)str.charAt(i);
			
			if(asciivalue >= 97 && asciivalue <= 122)
				asciivalue = asciivalue - 32;
			int arrayindex = asciivalue % 35;
			table[arrayindex]++;
		}
		return table;
	}
	
/**
 * Answer 1.5 
 * This method uses replaceAll() method
 * @param s
 * @return
 */
	public static String replaceSpaces1(String s){
		s = s.replaceAll(" ", "%20");
		return s;
	}

	public static String replaceSpaces2(String s){
		String newstring = "";
		for(int a=0; a<s.length(); a++){
			int asciivalue = (int)s.charAt(a);
			if(asciivalue == 32){
				newstring = newstring + "%20";
			}else{
				newstring = newstring + Character.toString(s.charAt(a));
			}
		}
		return newstring;
	}
	public static boolean isUniqueChars(String str){
		int checker = 0;
		for(int i=0; i<str.length(); i++){
			int val = str.charAt(i) - 'a';
			if((checker & (1 << val)) > 0){
				return false;
			}
			checker |= (1<<val);
		}
		return true;
	}
	

}
