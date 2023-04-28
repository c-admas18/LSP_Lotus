//Chrystell Adams

package org.howard.edu.lsp.finals.problem;

import static org.junit.Assert.*;

import org.junit.Test;

import java.util.*;


public class SongsDatabaseTest {
	

	@Test
	public void testAddSong() {
		
		SongsDatabase db =  new SongsDatabase();
		db.addSong("Rap", "Savage");
		db.addSong("Rap", "Gin and Juice");
		db.addSong("Jazz", "Always There");
		db.addSong("Pop", "Umbrella");
		
		
		Set<String> rapSongs = db.getSongs("Rap");
		assertTrue(rapSongs.contains("Savage"));
		assertTrue(rapSongs.contains("Gin and Juice"));
		
		Set<String> jazzSongs = db.getSongs("Jazz");
		assertTrue(jazzSongs.contains("Always There"));
		
	}
	
	@Test
	public void testGetSongs() {
		
		SongsDatabase db =  new SongsDatabase();
		db.addSong("Rap", "Savage");
		db.addSong("Rap", "Gin and Juice");
		db.addSong("Jazz", "Always There");
		db.addSong("Pop", "Umbrella");
		
		
		Set<String> rapSongs = db.getSongs("Rap");
		assertEquals(2, rapSongs.size());
		
		Set<String> jazzSongs = db.getSongs("Jazz");
		assertEquals(1, jazzSongs.size());
		
		Set<String> popSongs = db.getSongs("Pop");
		assertEquals(1, popSongs.size());
		
		Set<String> countrySongs = db.getSongs("Country");
		assertEquals(0, countrySongs.size());
	}
	
	@Test
	public void testDetGenreOfSong() {
		
		SongsDatabase db =  new SongsDatabase();
		db.addSong("Rap", "Savage");
		db.addSong("Rap", "Gin and Juice");
		db.addSong("Jazz", "Always There");
		db.addSong("Pop", "Umbrella");
		
		
		assertEquals("Rap", db.getGenreOfSong("Savage"));
		assertEquals("Jazz", db.getGenreOfSong("Always There"));
		assertEquals("Pop", db.getGenreOfSong("Umbrella"));
		assertNull(db.getGenreOfSong("Best Thing"));
	}

}
