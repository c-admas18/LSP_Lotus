package org.howard.edu.lsp.assignment4;

public class Driver {

	public static void main(String[] args) throws IntegerSetExecption {
		IntegerSet set1 = new IntegerSet();
		
		set1.add(3);
		set1.add(10);
		set1.add(1);
		set1.add(7);
		
		IntegerSet set2 = new IntegerSet();
		
		set2.add(4);
		set2.add(5);
		set2.add(11);
		set2.add(6);
		
		System.out.println("Is set1 empty? " + set1.isEmpty());
		
		System.out.println("The length of set1 is " + set1.length());
		System.out.println("The length of set2 is " + set2.length());
		
		System.out.println("The values of set1 are " + set1.getSet());
		System.out.println("The values of set2 are " + set2.getSet());
		
		System.out.println("Does set1 containe 7? " + set1.contains(7));
		System.out.println("Does set1 containe 11? " + set1.contains(11));
		
		System.out.println("Are the sets equal? " + set1.equals(set2));
		
		System.out.println("The smallest value of set1 is " + set1.smallest());
		System.out.println("The smallest value of set2 is " + set2.smallest());
		
		System.out.println("The largest value of set1 is " + set1.largest());
		System.out.println("The largest value of set2 is " + set2.largest());
		
		set1.diff(set2);
		System.out.println("The difference of set1 and set2 is " + set1.toString());
		
		set1.union(set2);
		System.out.println("The union of set1 and set2 is " + set1.toString());
		
		System.out.println("The values of set1 are " + set1.getSet());
		System.out.println("The values of set2 are " + set2.getSet());
		
		set1.intersect(set2);
		System.out.println("The intersection of set1 and set2 is " + set1.toString());
		
		
		set2.remove(4);
		set2.remove(5);
		System.out.println("The values of set2 are " + set2.getSet());
		
		set1.clear();
		System.out.println("Is set1 empty? " + set1.isEmpty());
		

	}

}
