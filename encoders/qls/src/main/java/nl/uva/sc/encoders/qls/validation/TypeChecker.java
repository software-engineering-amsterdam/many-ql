package nl.uva.sc.encoders.qls.validation;

import static nl.uva.sc.encoders.ql.validation.ValidationMessage.Type.ERROR;

import java.util.ArrayList;
import java.util.List;

import nl.uva.sc.encoders.ql.ast.Questionnaire;
import nl.uva.sc.encoders.ql.ast.TextLocation;
import nl.uva.sc.encoders.ql.validation.TypeValidation;
import nl.uva.sc.encoders.qls.ast.Page;
import nl.uva.sc.encoders.qls.ast.Section;
import nl.uva.sc.encoders.qls.ast.Stylesheet;
import nl.uva.sc.encoders.qls.visitor.SectionVisitor;

public class TypeChecker implements SectionVisitor<List<TypeValidation>> {

	private final Stylesheet stylesheet;
	private final Questionnaire questionnaire;

	List<TypeValidation> validations = new ArrayList<>();

	public TypeChecker(Stylesheet stylesheet, Questionnaire questionnaire) {
		this.stylesheet = stylesheet;
		this.questionnaire = questionnaire;
	}

	public List<TypeValidation> checkTypes() {
		List<Page> pages = stylesheet.getPages();
		for (Page page : pages) {
			List<Section> sections = page.getSections();
			for (Section section : sections) {
				validations.addAll(section.accept(this));
			}
		}
		return validations;
	}

	@Override
	public List<TypeValidation> visit(Section section) {
		String name = section.getName();
		List<TypeValidation> validations = new ArrayList<>();
		List<String> questions = new ArrayList<>();
		questions = stylesheet.getAllQuestions();
		for (String question : questions) {
			if (!questionnaire.containsQuestion(question)) {
				String validationMessage = "Question '" + name + "' does not exist in questionnaire";
				TextLocation textLocation = section.getTextLocation();
				validations.add(new TypeValidation(validationMessage, textLocation, ERROR));
			}
		}
		return validations;
	}
}
