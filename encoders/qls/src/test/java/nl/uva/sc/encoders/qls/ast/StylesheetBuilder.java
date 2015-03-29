package nl.uva.sc.encoders.qls.ast;

import static nl.uva.sc.encoders.ql.ast.TextLocationBuilder.aTextLocation;
import static nl.uva.sc.encoders.qls.ast.PageBuilder.aPage;

import java.util.ArrayList;
import java.util.List;

import nl.uva.sc.encoders.ql.ast.TextLocation;

public class StylesheetBuilder {

	private TextLocation textLocation;
	private String name;
	private List<Page> pages = new ArrayList<>();

	public static StylesheetBuilder aStylesheet() {
		StylesheetBuilder stylesheetBuilder = new StylesheetBuilder();
		stylesheetBuilder.textLocation = aTextLocation().build();
		stylesheetBuilder.name = "AnotherTaxOfficeExample";
		stylesheetBuilder.pages.add(aPage().build());
		return stylesheetBuilder;
	}

	public Stylesheet build() {
		return new Stylesheet(textLocation, name, pages);
	}

	public StylesheetBuilder withPages(List<Page> pages) {
		pages.clear();
		pages.addAll(pages);
		return this;
	}

}
