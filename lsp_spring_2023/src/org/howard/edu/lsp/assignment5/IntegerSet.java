package org.howard.edu.lsp.assignment5;

import java.util.ArrayList;
import java.util.List;

import org.howard.edu.lsp.assignment4.IntegerSetException;

public class IntegerSet {
	
	// ArrayList of integers 
	
	private List<Integer> set = new ArrayList<Integer>();
	
	
	/**
	 * constructor for IntegerSet
	 * @param list 
	 */
	
	
	public IntegerSet(List<Integer> integers) {
		for (int i = 0; i < integers.size(); i++) {
			int addition = (int) integers.get(i);
			this.add(addition);
		}
	}
	
	
	
	public List<Integer> getSet() {
		return this.set;
	}

	
	/**
	 * Clears the internal representation of the set
	 */
	
	
	public void clear() {
		if (!this.isEmpty()) {
			this.set.clear();
		}
	}
	

	/**
	 * returns the length of the set
	 */
	
	
	public int length() {
		return this.set.size();
	} 

	/**
	 * Returns true if the 2 sets are equal, false otherwise;
	 * Two sets are equal if they contain all of the same values in ANY order.
	 */
	
	
	public boolean equals(IntegerSet b) {
		if (this.length() != b.length()) {
			return false;
		}
		for (int i = 0; i < this.length(); i++) {
			if (!(b.contains(this.set.get(i)))){
				return false;
			}
		}
		return true;
	} 

	
	/**
	 * Returns true if the set contains the value, otherwise false
	 */
	
	
	public boolean contains(int value) {
		return this.set.contains(value);
	}    

	
	/**
	 * Returns the largest item in the set; Throws a IntegerSetException if the set is empty 
	 */
	
	
	public int largest() throws IntegerSetException {
		if (this.isEmpty()) {
			throw new IntegerSetException("IntegerSetException: The largest number cannot be found because the list is empty!");
		} else if (this.length() == 1) {
			return this.set.get(0);
		}
		int largest = this.set.get(0);
		for (int i = 1; i < this.length(); i++) {
			if (this.set.get(i) > largest) {
				largest = this.set.get(i);
			}
		}
		return largest;
	} 

	
	/**
	 * returns the smallest item in the set; Throws a IntegerSetException if the set is empty
	 */
	
	
	public int smallest() throws IntegerSetException{
		if (this.isEmpty()) {
			throw new IntegerSetException("IntegerSetException: The smallest number cannot be found because the list is empty!");
		} else if (this.length() == 1) {
			return this.set.get(0);
		}
		int smallest = this.set.get(0);
		for (int i = 1; i < this.length(); i++) {
			if (this.set.get(i) < smallest) {
				smallest = this.set.get(i);
			}
		}
		return smallest;
	}

	
	/**
	 * Adds an item to the set or does nothing if it is already there
	 */
	
	
	public void add(int item) {
		if (!(this.contains(item))) {
			this.set.add(item);
		}
		
	}
	
 
	/**
	 * Removes an item from the set or does nothing if it is not there
	 */
	
	
	public void remove(int item) {
		if (this.contains(item)) {
			int position = this.set.indexOf(item);
			this.set.remove(position);
		}
	}
 
	
	/**
	 * Set union
	 */
	
	
	public void union(IntegerSet b) {
		List<Integer> setB = b.getSet();
		if (b.isEmpty()) {
			return;
		}
		for (int i = 0; i < b.length(); i++) {
			if (this.contains(setB.get(i))) {
				continue;
			}
			this.add(setB.get(i));
		}
	}

	
	/**
	 * Set intersection
	 */
	
	
	public void intersect(IntegerSet b) {
		List<Integer> intersectingSet = new ArrayList<Integer>();
		for (int i = 0; i < this.length(); i++) {
			int set_value = this.set.get(i);
			if (b.contains(set_value)) {
				intersectingSet.add(set_value);
			}
		}
		this.set = intersectingSet;
	} 

	/**
	 * Set difference, i.e., s1 –s2
	 */
	
	
	public void diff(IntegerSet b) {
		List<Integer> result = new ArrayList<Integer>();
		for (int i = 0; i < this.length(); i++) {
			int set_value = this.set.get(i);
			if (!(b.contains(set_value))) {
				result.add(set_value);
			}
		}
		this.set = result;
	}
 
	
	/**
	 *  Returns true if the set is empty, false otherwise
	 */
	
	
	public boolean isEmpty() {
		return this.set.isEmpty();
	} 

	/**
	 * Return String representation of your set
	 */
	
	public String toString() {
		return this.set.toString();
	}

	
	
}
