package com.kata;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Scanner;

import org.apache.commons.lang3.StringUtils;

import com.kata.vo.Score;

public class KeyCounter {

	private Scanner scanner;
	HashMap<String, Integer> boardResult = new HashMap<String, Integer>();

	public HashMap<String, Integer> getTableOfResults(String fileName)
			throws FileNotFoundException {

		
		loadFileToRead(fileName);

		Score score=null;
		String line;
		
		while (scanner.hasNextLine()) {

			line = scanner.next();

			
			score = extractScore(score, line);
			
			
			saveNewResultInTheBoard(boardResult, score);
			
			
			
		}

		return boardResult;
	}

	private Score extractScore(Score score, String line) {
		
		String[] transform;

		if (!StringUtils.isEmpty(line) && line.trim().length()>0){
			
			transform = line.split(",");
			
			if (transform != null && transform.length>0 ){
				
				if (transform.length == 2) {

					score = new Score(transform[0], Integer.valueOf(transform[1]));

				}else{
					score = new Score(transform[0], 0);
					
					
				}

			
				
			}
			
		}
		System.out.println("SCORE :  " + score.toString());

		return score;
	}

	private void saveNewResultInTheBoard(HashMap<String, Integer> boardResult,
			Score score) {
		Integer actualValue;
		
		if (score !=null){
			
			actualValue = boardResult.get(score.getName());

			if (actualValue != null) {

				actualValue += score.getScore();

				boardResult.put(score.getName(), actualValue);

			} else {
				boardResult.put(score.getName(), score.getScore());

			}			
			
		}

	}

	private void loadFileToRead(String fileName) throws FileNotFoundException {
		ClassLoader classLoader = getClass().getClassLoader();
		scanner = new Scanner(new FileReader(new File(classLoader.getResource(
				fileName).getFile())));
	}

}
