package org.itstep;

import java.util.ArrayList;
import java.util.List;

import org.itstep.dao.KeywordDAO;
import org.itstep.model.Keyword;
import org.itstep.service.StartupStep;

/**
 * Hello world!
 *
 */
public class App 
{
	public static void main(String[] args) {
		List<Keyword> keys = new ArrayList<Keyword>();

		keys.add(new Keyword("cat toys"));

		keys.add(new Keyword("dog toys"));

		keys.add(new Keyword("cat food"));

		KeywordDAO keyDAO = new KeywordDAO();

		for (Keyword keyword : keys) {

			keyDAO.save(keyword);

		}

		
		
		List<Keyword> keysFromDB = keyDAO.getAll();

		StartupStep startupStep = new StartupStep(keysFromDB);
		
		startupStep.runParsing();

	}
}