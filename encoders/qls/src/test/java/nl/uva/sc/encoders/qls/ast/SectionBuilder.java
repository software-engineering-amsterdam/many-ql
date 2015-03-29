package nl.uva.sc.encoders.qls.ast;

import static nl.uva.sc.encoders.ql.ast.TextLocationBuilder.aTextLocation;

import java.util.ArrayList;
import java.util.List;

import nl.uva.sc.encoders.ql.ast.TextLocation;

public class SectionBuilder {

	private TextLocation textLocation;
	private String name;
	private List<String> questionNames = new ArrayList<>();
	private List<Section> subSections = new ArrayList<>();
	private List<DefaultStyle> sectionDefaultStyles = new ArrayList<>();

	public static SectionBuilder aSection() {
		SectionBuilder builder = new SectionBuilder();
		builder.textLocation = aTextLocation().build();
		builder.name = "Section with all kinds of Crap";
		builder.questionNames.add("SomeQuestionA");
		builder.questionNames.add("SomeQuestionB");
		return builder;
	}

	public Section build() {
		return new Section(textLocation, name, questionNames, subSections, sectionDefaultStyles);
	}

	public SectionBuilder withName(String name) {
		this.name = name;
		return this;
	}

	public SectionBuilder withQuestions(List<String> questionNames) {
		this.questionNames = questionNames;
		return this;
	}

}
