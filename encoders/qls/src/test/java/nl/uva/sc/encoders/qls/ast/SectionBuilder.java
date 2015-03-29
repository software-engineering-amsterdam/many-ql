package nl.uva.sc.encoders.qls.ast;

import static nl.uva.sc.encoders.ql.ast.TextLocationBuilder.aTextLocation;

import java.util.ArrayList;
import java.util.List;

import nl.uva.sc.encoders.ql.ast.TextLocation;
import nl.uva.sc.encoders.qls.ast.property.FontSize;

public class SectionBuilder {

	private TextLocation textLocation;
	private String name;
	private List<String> questionNames = new ArrayList<>();
	private List<Section> subSections = new ArrayList<>();
	private List<FontSize> sectionDefaultStyles = new ArrayList<>();

	public static SectionBuilder aSection() {
		SectionBuilder builder = new SectionBuilder();
		builder.textLocation = aTextLocation().build();
		builder.name = "Section with all kinds of Crap";
		builder.questionNames.add("SomeQuestionA");
		builder.questionNames.add("SomeQuestionB");
		builder.subSections.add(aSection().build());
		return builder;
	}

	public Section build() {
		return new Section(textLocation, name);
	}

	public SectionBuilder withName(String name) {
		this.name = name;
		return this;
	}

}
