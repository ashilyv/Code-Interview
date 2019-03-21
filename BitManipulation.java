import java.util.ArrayList;

public class BitManipulation {
/**
 * Question #5.2, pg 116
 * Convert a decimal number between 0 and 1 to its
 * binary representation
 */
	public String BinaryRepresentation(double decnumber){
		//int binaryrep = 0;
		String binarynumber = "0.";
		//System.out.println("binaryrep is " + binaryrep);
		for(int i=1; i<33; i++){
			double binaryvalue =  1 /(Math.pow(2, i));
			//System.out.println(binaryvalue);
			if(binaryvalue <= decnumber){
				decnumber = decnumber - binaryvalue;
				//System.out.println("decnumber is " + decnumber);
				//binaryrep = (byte) (binaryrep << 1);
				binarynumber = binarynumber + "1";
			}
			else{
				//binaryrep = (byte) (binaryrep << 0);
				binarynumber = binarynumber + "0";
			}
			
		}
		
		return binarynumber;
		
	}
/**	
 * 5.3, pg 116
 * Answer(code) from the book, pg 278
 * @param number
 */
	public int longestSequence(int n){
		if(n == -1) 
			return Integer.BYTES * 8;
		ArrayList<Integer> sequences = getAlternatingSequences(n);
		return findLongestSequence(sequences);
		
	}
	
	ArrayList<Integer> getAlternatingSequences(int n){
		ArrayList<Integer> sequences = new ArrayList<Integer>();
		int searchingFor = 0;
		int counter = 0;
		for(int i = 0; i < Integer.BYTES * 8; i++){
			if((n & 1) != searchingFor){
				sequences.add(counter);
				searchingFor = n & 1;
				counter = 0;
			}
		counter++;
		n >>>= 1;
		}
		sequences.add(counter);
	
		return sequences;
	}
/**
 * 5.3, pg 116 rest of the code (methods)
 * Given the lengths of alternating sequences of 0s and 1s, 
 * find the longest one we can build
 * @param seq is an integer array list
 * @return longest number of 1s
 */
	int findLongestSequence(ArrayList<Integer> seq){
		int maxSeq = 1;
		
		for(int i=0; i < seq.size(); i+=2){
			int zerosSeq = seq.get(i);
			int onesSeqRight = i - 1 >= 0 ? seq.get(i-1) : 0;
			int onesSeqLeft = i + 1 < seq.size() ? seq.get(i+1) : 0;
			
			int thisSeq = 0;
			if(zerosSeq == 1) { //Can merger
				thisSeq = onesSeqLeft + 1 + onesSeqRight;
			}
			if(zerosSeq > 1) { // Just add a zero to either side
				thisSeq = 1 + Math.max(onesSeqRight, onesSeqRight);
			}
			else if(zerosSeq == 0) { // No zero, but take either side
				thisSeq = Math.max(onesSeqRight, onesSeqLeft);
			}
			maxSeq = Math.max(thisSeq, maxSeq);
		}
		return maxSeq;
	}
		
	
}

