package nl.uva.sc.encoders.qls.ast;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import nl.uva.sc.encoders.ql.ast.TextLocation;

public class Page extends AstNode {

	private final String name;
	private final List<Section> sections;
	private final List<DefaultStyle> pageDefaultStyles;

	public Page(TextLocation textLocation, String name, List<Section> sections, List<DefaultStyle> pageDefaultStyles) {
		super(textLocation);
		this.name = name;
		this.sections = sections;
		this.pageDefaultStyles = pageDefaultStyles;
	}

	public String getName() {
		return name;
	}

	public List<Section> getSections() {
		return sections;
	}

	public Section getSection(String name) {
		for (Section section : sections) {
			if (section.getName().equals(name)) {
				return section;
			}
		}
		return null;
	}

	public List<DefaultStyle> getPageDefaultStyles() {
		return pageDefaultStyles;
	}

	public void collectQuestions(Collection<String> questions) {
		for (Section section : sections) {
			section.collectQuestions(questions);
		}
	}

	public boolean containsQuestion(String name) {
		List<String> questions = new ArrayList<>();
		collectQuestions(questions);
		return questions.stream().anyMatch(question -> question.equals(name));
	}

}
