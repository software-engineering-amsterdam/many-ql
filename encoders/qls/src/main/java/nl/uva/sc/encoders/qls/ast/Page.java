package nl.uva.sc.encoders.qls.ast;

import java.util.ArrayList;
import java.util.List;

import nl.uva.sc.encoders.ql.ast.TextLocation;

public class Page extends AstNode {

	private final String name;

	private List<Section> sections = new ArrayList<Section>();

	public Page(TextLocation textLocation, String name) {
		super(textLocation);
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public List<Section> getSections() {
		return sections;
	}

	public void addSection(Section section) {
		sections.add(section);
	}

	public Section getSection(String name) {
		for (Section section : sections) {
			if (section.getName().equals(name)) {
				return section;
			}
		}
		return null;
	}

}
