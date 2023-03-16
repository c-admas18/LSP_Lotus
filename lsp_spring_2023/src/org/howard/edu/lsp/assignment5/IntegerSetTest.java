package org.howard.edu.lsp.assignment5;





import java.util.Arrays;

import org.junit.jupiter.api.Test;

import org.howard.edu.lsp.assignment4.IntegerSetException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;


class IntegerSetTest {

	IntegerSet set = new IntegerSet(Arrays.asList(1, 2, 3, 4, 5, 6));
	IntegerSet oneset = new IntegerSet(Arrays.asList(11));
	IntegerSet fourset1 = new IntegerSet(Arrays.asList(5, 1, 15, 3));
	IntegerSet fourset2 = new IntegerSet(Arrays.asList(2, 3, 4, 5));
	IntegerSet empty = new IntegerSet(Arrays.asList());

	/**
	 * @throws java.lang.Exception
	 */
	
	
	@BeforeEach
	void setUp() throws Exception {
		
	}

	/**
	 * @throws java.lang.Exception
	 */
	
	
	@AfterEach
	void tearDown() throws Exception {
		set = new IntegerSet(Arrays.asList(1, 2, 3, 4, 5, 6));
		oneset = new IntegerSet(Arrays.asList(11));
		fourset1 = new IntegerSet(Arrays.asList(5, 1, 15, 3));
		fourset2 = new IntegerSet(Arrays.asList(2,3, 4, 5));
		empty = new IntegerSet(Arrays.asList());
	}

	
	@Test
	@DisplayName("Test cases for clear")
	void testClear() {
		set.clear();
		assertEquals(Arrays.asList(), set.getSet());
	}
	
	
	@Test
	@DisplayName("Test cases for length")
	void testLength() {
		assertEquals(6, set.length());
		assertEquals(4, fourset1.length());
		assertEquals(1, oneset.length());
		assertEquals(0, empty.length());
	}
	
	
	@Test
	@DisplayName("Test cases for equals")
	void testEquals() {
		assertTrue(set.equals(set));
		assertFalse(set.equals(fourset2));
	}
	
	
	@Test
	@DisplayName("Test cases for contains")
	void testContains() {
		assertTrue(set.contains(1));
		assertFalse(set.contains(0));
	}
	
	
	@Test
	@DisplayName("Test cases for largest")
	void testLargest() throws IntegerSetException{
		assertEquals(6, set.largest());
		assertEquals(11, oneset.largest());
		Throwable exception = assertThrows(IntegerSetException.class, () -> {empty.largest();});
		assertEquals("IntegerSetException: The largest number cannot be found because the list is empty!", exception.getMessage());
	}
	
	
	@Test
	@DisplayName("Test cases for smallest")
	void testSmallest() throws IntegerSetException{
		assertEquals(1, set.smallest());
		assertEquals(11, oneset.smallest());
		Throwable exception = assertThrows(IntegerSetException.class, () -> {empty.smallest();});
	    assertEquals("IntegerSetException: The smallest number cannot be found because the list is empty!", exception.getMessage());
	}
	
	
	@Test
	@DisplayName("Test cases for add")
	void testAdd() {
		set.add(1);
		assertEquals(Arrays.asList(1, 2, 3, 4, 5, 6), set.getSet());
		set.add(0);
		assertEquals(Arrays.asList(1, 2, 3, 4, 5, 6, 0), set.getSet());
	}
	
	
	@Test
	@DisplayName("Test cases for remove")
	void testRemove() {
		set.remove(0);
		assertEquals(Arrays.asList(1, 2, 3, 4, 5, 6), set.getSet());
		set.remove(1);
		assertEquals(Arrays.asList(2, 3, 4, 5, 6), set.getSet());
	}
	
	
	@Test
	@DisplayName("Test cases for union")
	void testUnion() {
		set.union(empty);
		assertEquals(Arrays.asList(1, 2, 3, 4, 5, 6), set.getSet());
		empty.union(set);
		assertEquals(Arrays.asList(1, 2, 3, 4, 5, 6), empty.getSet());
		set.union(fourset2);
		assertEquals(Arrays.asList(1, 2, 3, 4, 5, 6), set.getSet());
	}
	
	
	@Test
	@DisplayName("Test cases for intersect")
	void testIntersect() {
		set.intersect(set);
		assertEquals(Arrays.asList(1, 2, 3, 4, 5, 6), set.getSet());
		empty.intersect(set);
		assertEquals(Arrays.asList(), empty.getSet());
		set.intersect(fourset2);
		assertEquals(Arrays.asList(2,3, 4, 5), set.getSet());
	}
	
	
	@Test
	@DisplayName("Test cases for diff")
	void testDiff() {
		set.diff(empty);
		assertEquals(Arrays.asList(1, 2, 3, 4, 5, 6), set.getSet());
		empty.diff(set);
		assertEquals(Arrays.asList(), empty.getSet());
		set.diff(fourset2);
		assertEquals(Arrays.asList(1, 6), set.getSet());
	}
	
	
	@Test
	@DisplayName("Test cases for isEmpty")
	void testIsEmpty() {
		assertTrue(empty.isEmpty());
		assertFalse(set.isEmpty());
	}
	
	
	@Test
	@DisplayName("Test cases for toString")
	void testToString() {
		assertEquals("[1, 2, 3, 4, 5, 6]", set.toString());
		assertEquals("[]", empty.toString());
	}



}
