package com.thinkhr.util.service;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WordUtilServiceTest {
	
	@Autowired
	private WordUtilService wordUtilService;
	
	@Test
	public void testFetchAllWords() throws IOException,FileNotFoundException {
		wordUtilService.findRandomWord();
	}

}
