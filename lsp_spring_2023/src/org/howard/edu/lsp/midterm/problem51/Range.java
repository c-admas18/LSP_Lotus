//Chrystell Adams

package org.howard.edu.lsp.midterm.problem51;

public interface Range {
	
	
	/**
	 * returns true if v is ≥ lower bound and ≤ upper bound
	 * false otherwises
	 */
	
	public boolean contains( int value );  
	
	/** 
	 * returns true if the receiver contains at least 
	 * one value in common with other, and false otherwise 
	 * EmptyRangeException is thrown when a null Range object is passed to the method 
	 */
	
	public boolean overlaps( Range other ) throws EmptyRangeException; 
	
	// returns the number of integers in the range
	
	public int size(); 
   


}
