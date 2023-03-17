//Chrystell Adams

package org.howard.edu.lsp.midterm.problem51;


import org.junit.jupiter.api.Test;


import org.junit.jupiter.api.DisplayName;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;



class IntegerRangeTest {
	
	
	IntegerRange range = new IntegerRange(11,20);
	IntegerRange range2 = new IntegerRange(1,5);
	IntegerRange range3 = new IntegerRange(12,19);

	@Test
	@DisplayName("Test cases for contains")
	public void testContains() {
		assertTrue(range.contains(18));
		assertFalse(range.contains(75));
	}
	
	@Test
	@DisplayName("Test cases for overlaps")
	public void testOverlaps() throws EmptyRangeException {
		assertTrue(range.overlaps(range3));
		assertFalse(range.overlaps(range2));
		Throwable exception = assertThrows(EmptyRangeException.class, () -> {range.overlaps(null);});
		assertEquals("The range is null so the object cannot pass!", exception.getMessage());
		
	}
	
	@Test
	@DisplayName("Test cases for size")
	public void testSize() {
		assertEquals(10, range.size());
		assertEquals(5, range2.size());
		assertEquals(8, range3.size());
	}

}
