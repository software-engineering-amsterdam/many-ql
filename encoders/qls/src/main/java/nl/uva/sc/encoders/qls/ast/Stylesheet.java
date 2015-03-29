package nl.uva.sc.encoders.qls.ast;

import java.util.ArrayList;
import java.util.List;

import nl.uva.sc.encoders.ql.ast.TextLocation;

public class Stylesheet extends AstNode {

	private final String name;

	private final List<Page> pages;

	public Stylesheet(TextLocation textLocation, String name, List<Page> pages) {
		super(textLocation);
		this.name = name;
		this.pages = pages;
	}

	public boolean containsQuestion(String name) {
		return getAllQuestions().stream().anyMatch(question -> question.equals(name));
	}

	public List<String> getAllQuestions() {
		List<String> result = new ArrayList<>();
		for (Page page : pages) {
			page.collectQuestions(result);
		}
		return result;
	}

	public String getName() {
		return name;
	}

	public List<Page> getPages() {
		return pages;
	}

}
