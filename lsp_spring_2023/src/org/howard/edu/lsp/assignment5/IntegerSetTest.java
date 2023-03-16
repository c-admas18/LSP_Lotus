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

	IntegerSet standard = new IntegerSet(Arrays.asList(1, 2, 3, 4, 5, 6));
	IntegerSet single = new IntegerSet(Arrays.asList(11));
	IntegerSet four1 = new IntegerSet(Arrays.asList(5, 1, 15, 3));
	IntegerSet four2 = new IntegerSet(Arrays.asList(2, 3, 4, 5));
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
		standard = new IntegerSet(Arrays.asList(1, 2, 3, 4, 5, 6));
		single = new IntegerSet(Arrays.asList(11));
		four1 = new IntegerSet(Arrays.asList(5, 1, 15, 3));
		four2 = new IntegerSet(Arrays.asList(2,3, 4, 5));
		empty = new IntegerSet(Arrays.asList());
	}

	
	@Test
	@DisplayName("Test cases for clear")
	void testClear() {
		standard.clear();
		assertEquals(Arrays.asList(), standard.getSet());
	}
	
	
	@Test
	@DisplayName("Test cases for length")
	void testLength() {
		assertEquals(6, standard.length());
		assertEquals(4, four1.length());
		assertEquals(1, single.length());
		assertEquals(0, empty.length());
	}
	
	
	@Test
	@DisplayName("Test cases for equals")
	void testEquals() {
		assertTrue(standard.equals(standard));
		assertFalse(standard.equals(four2));
	}
	
	
	@Test
	@DisplayName("Test cases for contains")
	void testContains() {
		assertTrue(standard.contains(1));
		assertFalse(standard.contains(0));
	}
	
	
	@Test
	@DisplayName("Test cases for largest")
	void testLargest() throws IntegerSetException{
		assertEquals(6, standard.largest());
		assertEquals(11, single.largest());
		Throwable exception = assertThrows(IntegerSetException.class, () -> {empty.largest();});
		assertEquals("IntegerSetException: The largest number cannot be found because the list is empty!", exception.getMessage());
	}
	
	
	@Test
	@DisplayName("Test cases for smallest")
	void testSmallest() throws IntegerSetException{
		assertEquals(1, standard.smallest());
		assertEquals(11, single.smallest());
		Throwable exception = assertThrows(IntegerSetException.class, () -> {empty.smallest();});
	    assertEquals("IntegerSetException: The smallest number cannot be found because the list is empty!", exception.getMessage());
	}
	
	
	@Test
	@DisplayName("Test cases for add")
	void testAdd() {
		standard.add(1);
		assertEquals(Arrays.asList(1, 2, 3, 4, 5, 6), standard.getSet());
		standard.add(0);
		assertEquals(Arrays.asList(1, 2, 3, 4, 5, 6, 0), standard.getSet());
	}
	
	
	@Test
	@DisplayName("Test cases for remove")
	void testRemove() {
		standard.remove(0);
		assertEquals(Arrays.asList(1, 2, 3, 4, 5, 6), standard.getSet());
		standard.remove(1);
		assertEquals(Arrays.asList(2, 3, 4, 5, 6), standard.getSet());
	}
	
	
	@Test
	@DisplayName("Test cases for union")
	void testUnion() {
		standard.union(empty);
		assertEquals(Arrays.asList(1, 2, 3, 4, 5, 6), standard.getSet());
		empty.union(standard);
		assertEquals(Arrays.asList(1, 2, 3, 4, 5, 6), empty.getSet());
		standard.union(four2);
		assertEquals(Arrays.asList(1, 2, 3, 4, 5, 6), standard.getSet());
	}
	
	
	@Test
	@DisplayName("Test cases for intersect")
	void testIntersect() {
		standard.intersect(standard);
		assertEquals(Arrays.asList(1, 2, 3, 4, 5, 6), standard.getSet());
		empty.intersect(standard);
		assertEquals(Arrays.asList(), empty.getSet());
		standard.intersect(four2);
		assertEquals(Arrays.asList(2,3, 4, 5), standard.getSet());
	}
	
	
	@Test
	@DisplayName("Test cases for diff")
	void testDiff() {
		standard.diff(empty);
		assertEquals(Arrays.asList(1, 2, 3, 4, 5, 6), standard.getSet());
		empty.diff(standard);
		assertEquals(Arrays.asList(), empty.getSet());
		standard.diff(four2);
		assertEquals(Arrays.asList(1, 6), standard.getSet());
	}
	
	
	@Test
	@DisplayName("Test cases for isEmpty")
	void testIsEmpty() {
		assertTrue(empty.isEmpty());
		assertFalse(standard.isEmpty());
	}
	
	
	@Test
	@DisplayName("Test cases for toString")
	void testToString() {
		assertEquals("[1, 2, 3, 4, 5, 6]", standard.toString());
		assertEquals("[]", empty.toString());
	}



}
