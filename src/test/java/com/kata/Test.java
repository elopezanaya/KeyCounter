package com.kata;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.util.HashMap;

public class Test {

	
	KeyCounter keyCounter = new KeyCounter();
	
	@org.junit.Test
	public void test() throws FileNotFoundException {
		
		HashMap<String, Integer> tableOfResults= keyCounter.getTableOfResults("input.txt");
		
		assertTrue(6 == tableOfResults.get("John"));
		assertTrue(8 == tableOfResults.get("Jane"));
		
		
	}
	
	@org.junit.Test
	public void testNoScore() throws FileNotFoundException {
		
		HashMap<String, Integer> tableOfResults= keyCounter.getTableOfResults("inputNoScore.txt");
		
		assertTrue(4 == tableOfResults.get("John"));
		assertTrue(8 == tableOfResults.get("Jane"));
		
		
	}
	
	@org.junit.Test
	public void testNoValues() throws FileNotFoundException {
		
		HashMap<String, Integer> tableOfResults= keyCounter.getTableOfResults("inputNovalues.txt");
		
		assertTrue(null == tableOfResults.get("John"));
		assertTrue(null == tableOfResults.get("Jane"));
		
		
	}
	
	@org.junit.Test
	public void testNoName() throws FileNotFoundException {
		
		HashMap<String, Integer> tableOfResults= keyCounter.getTableOfResults("inputNoName.txt");
		
		assertTrue(null == tableOfResults.get("John"));
		assertTrue(null == tableOfResults.get("Jane"));
		
		
	}

}
