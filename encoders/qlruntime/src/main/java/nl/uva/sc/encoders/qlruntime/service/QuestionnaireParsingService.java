package nl.uva.sc.encoders.qlruntime.service;

import java.io.IOException;

import nl.uva.sc.encoders.ql.ast.Questionnaire;

/**
 * Service for parsing questionnaire input files.
 */
public interface QuestionnaireParsingService {

	/**
	 * Parses the input file and creates a questionnaire.
	 * 
	 * @param location
	 *            the location of the input file.
	 * @return The {@link Questionnaire} that was parsed from the input file.
	 */
	QuestionnaireParsingResult parse(String location) throws IOException;
}
