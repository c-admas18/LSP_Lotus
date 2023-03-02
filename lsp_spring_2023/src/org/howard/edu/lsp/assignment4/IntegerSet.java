package org.howard.edu.lsp.assignment4;

import java.util.ArrayList;
import java.util.List;

public class IntegerSet {
	
	private List<Integer> set; 
	
	/**
	 * constructor for IntegerSet
	 */
	
	public IntegerSet() {
		this.set = new ArrayList<Integer>();
	}

	
	public List<Integer> getSet(){
		return this.set;
	}
	
	public int get(int index) {
		return set.get(index);
	}
	
	/**
	 * Clears the internal representation of the set
	 */
	
	public void clear() {
		if(!this.isEmpty()){
			set.clear();
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
			if (!(b.contains(this.set.get(i)))) {
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
	
	public int largest() throws IntegerSetExecption{
		if (this.isEmpty()) {
			throw new IntegerSetExecption("IntegerSetException: The list is empty so the largert number can't be found.");
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
	
	public int smallest() throws IntegerSetExecption{
		if (this.isEmpty()) {
			throw new IntegerSetExecption("IntegerSetException: The list is empty so the smallest number can't be found.");
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
		for (int i = 0; i<setB.size(); i++) {
			if (!this.contains(setB.get(i))) {
				this.add(setB.get(i));
			}
		}
	}
	
	/**
	 * Set intersection
	 */
	
	public void intersect(IntegerSet b) {
		List<Integer> setB = b.getSet();
			for(int i = 0; i<setB.size(); i++) {
				if( b.contains(i)) {
					setB.add(i);
				}
			}
			this.set = setB;
	}
	
	
	
	/**
	 * Set difference, i.e., s1 –s2
	 */
	
	public void diff(IntegerSet b) {
		for(int i=0; i<set.size(); i++) { 
			if(b.contains(set.get(i))) { 
				set.remove(set.get(i)); 
				b.remove(set.get(i));
			};
		} 	
		for(int i=0; i<b.length();i++) {
			set.add(b.get(i)); 
		}

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
