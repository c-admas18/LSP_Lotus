//Chrystell Adams

package org.howard.edu.lsp.midterm.problem51;

public class IntegerRange implements Range {

	private int lower;
   	private int upper;

	
   	// Constructor
   	 IntegerRange(int lower, int upper) { 
        		this.lower = lower;
        		this.upper = upper;
   	 }
   	 
  
   	 //implement getters for lower and upper
   	 
   	public int getLower() {
   		return lower;
   	}
   	
   	public int getUpper() {
   		return upper;
   	}
   	
   	/**
	 * returns true if v is ≥ lower bound and ≤ upper bound
	 * false otherwises
	 */
   	
	public boolean contains(int value) {
		return value >= lower && value <= upper;
	}
   	
   	/** 
	 * returns true if the receiver contains at least 
	 * one value in common with other, and false otherwise 
	 * EmptyRangeException is thrown when a null Range object is passed to the method 
	 */
   	
  
	public boolean overlaps(Range other) throws EmptyRangeException {
		if (other == null) {
			throw new EmptyRangeException("The range is null so the object cannot pass!");
		}
		
		IntegerRange otherR = (IntegerRange) other;
		return otherR.getUpper() >= lower && otherR.getLower() <= upper;
	}
   	
 
   	// returns the number of integers in the range
   
	public int size()  {
		return upper - lower + 1;
	}

}
