package nl.uva.sc.encoders.qls.ast;

import static nl.uva.sc.encoders.ql.ast.TextLocationBuilder.aTextLocation;

import java.util.ArrayList;
import java.util.List;

import nl.uva.sc.encoders.ql.ast.TextLocation;

public class SectionBuilder {

	private TextLocation textLocation;
	private String name;
	private List<Question> questions = new ArrayList<>();
	private List<Section> subSections = new ArrayList<>();
	private List<DefaultStyle> sectionDefaultStyles = new ArrayList<>();

	public static SectionBuilder aSection() {
		SectionBuilder builder = new SectionBuilder();
		builder.textLocation = aTextLocation().build();
		builder.name = "Section with all kinds of Crap";
		builder.questions.add(new Question(aTextLocation().build(), "SomeQuestionA", null));
		builder.questions.add(new Question(aTextLocation().build(), "SomeQuestionB", null));
		return builder;
	}

	public Section build() {
		return new Section(textLocation, name, questions, subSections, sectionDefaultStyles);
	}

	public SectionBuilder withName(String name) {
		this.name = name;
		return this;
	}

	public SectionBuilder withQuestions(List<Question> questions) {
		this.questions = questions;
		return this;
	}

}
