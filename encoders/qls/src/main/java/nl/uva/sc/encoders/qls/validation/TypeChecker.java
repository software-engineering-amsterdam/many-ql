package nl.uva.sc.encoders.qls.validation;

import java.util.Collections;
import java.util.List;

import nl.uva.sc.encoders.ql.ast.Questionnaire;
import nl.uva.sc.encoders.ql.validation.TypeValidation;
import nl.uva.sc.encoders.qls.ast.Stylesheet;

public class TypeChecker {

	private final Stylesheet stylesheet;
	private final Questionnaire questionnaire;

	public TypeChecker(Stylesheet stylesheet, Questionnaire questionnaire) {
		this.stylesheet = stylesheet;
		this.questionnaire = questionnaire;
	}

	public List<TypeValidation> checkTypes() {
		return Collections.emptyList();
	}

}
