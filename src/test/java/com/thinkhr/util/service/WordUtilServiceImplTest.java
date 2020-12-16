package com.thinkhr.util.service;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WordUtilServiceImplTest {
	
	@Autowired
	private WordUtilServiceImpl wordUtilServiceImpl;
	
	@Rule
    public ExpectedException expectedEx = ExpectedException.none();
	
	
	@Test
	public void testFetchAllWords() throws IOException{
		wordUtilServiceImpl.fetchAllWords();
	}
	
	@Test
	public void testFindRandomWord() throws IOException{
		wordUtilServiceImpl.findRandomWord();
	}
	
	/**
	 * Test Case for IOException for 100% code coverage 
	 */
	@Test
	public void testFindRandomWord_IOException() {
		expectedEx.expect(IOException.class);
		wordUtilServiceImpl.findRandomWord();
	}
	
	/**
	 * Test Case for FileNotFoundException for 100% code coverage 
	 */
	@Test
	public void testFindRandomWord_FileNotFoundException() {
		expectedEx.expect(FileNotFoundException.class);
		wordUtilServiceImpl.findRandomWord();
	}

}
