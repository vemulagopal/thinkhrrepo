package com.thinkhr.util.service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.stream.Stream;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

/**
 *  
 *  This class must implement all the methods of the WordUtilService interface.
 *  This is the service class which should have all the business functionality.
 *  
 */

@Service
public class WordUtilServiceImpl implements WordUtilService {

	Logger logger = LoggerFactory.getLogger(WordUtilServiceImpl.class);

	@Autowired
	ResourceLoader resourceLoader;

	/**
	 * This method print a random word from the given list of words. 
	 * @param nothing.
	 * @return Nothing.
	 */
	public void findRandomWord() {
		Random rand = new Random();
		ArrayList<String> words = fetchAllWords();
		String word = words.get(rand.nextInt(words.size()));
		System.out.println(word);
		logger.info("Random Word : {}", word);
	}
	
	/**
	 * This method reads all the words from a text file into string array. 
	 * @param nothing.
	 * @return ArrayList.
	 */
	public ArrayList<String> fetchAllWords() {
		ArrayList<String> allWords = new ArrayList<String>();
		Resource fileResource = resourceLoader.getResource("classpath:words_alpha.txt");
		if (fileResource.isReadable()) {
			try (BufferedReader reader = new BufferedReader(new InputStreamReader(fileResource.getInputStream()))) {
				Stream<String> stream = reader.lines();
				stream.forEach(word -> {
					allWords.add(word);
				});
			} catch (FileNotFoundException fe) {
				 throw new RuntimeException(
		                  "File Not found", fe);
			}
		      catch (IOException ioe) {
		    	  throw new RuntimeException(
		                  "Exception while reading the file", ioe);

			}

		}

		return allWords;
	}

}
