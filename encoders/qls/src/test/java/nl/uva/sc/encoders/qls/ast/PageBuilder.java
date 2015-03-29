package nl.uva.sc.encoders.qls.ast;

import static nl.uva.sc.encoders.ql.ast.TextLocationBuilder.aTextLocation;
import static nl.uva.sc.encoders.qls.ast.SectionBuilder.aSection;

import java.util.ArrayList;
import java.util.List;

import nl.uva.sc.encoders.ql.ast.TextLocation;

public class PageBuilder {

	private TextLocation textLocation;
	private String name;
	private List<Section> sections = new ArrayList<Section>();
	private List<DefaultStyle> pageDefaultStyles = new ArrayList<>();

	public static PageBuilder aPage() {
		PageBuilder pageBuilder = new PageBuilder();
		pageBuilder.textLocation = aTextLocation().build();
		pageBuilder.name = "SomePage";
		pageBuilder.sections.add(aSection().build());
		return pageBuilder;
	}

	public Page build() {
		return new Page(textLocation, name);
	}

}
