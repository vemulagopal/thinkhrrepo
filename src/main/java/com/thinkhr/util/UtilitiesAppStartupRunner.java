package com.thinkhr.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.thinkhr.util.service.WordUtilService;


@Component
public class UtilitiesAppStartupRunner implements CommandLineRunner {

	@Autowired
	private WordUtilService wordUtilService;

 
	@Override
	public void run(String... args) throws Exception {
		wordUtilService.findRandomWord();

	}
}
