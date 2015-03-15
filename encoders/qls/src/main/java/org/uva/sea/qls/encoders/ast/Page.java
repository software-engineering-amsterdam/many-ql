package org.uva.sea.qls.encoders.ast;

import java.util.ArrayList;
import java.util.List;

public class Page {

	private final String name;

	private List<Section> sections = new ArrayList<Section>();

	public Page(String name) {
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
