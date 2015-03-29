package nl.uva.sc.encoders.qls.ast.widget;

import java.util.List;

import nl.uva.sc.encoders.ql.ast.TextLocation;

public class Radio extends Widget {

	private final List<String> options;

	public Radio(TextLocation textLocation, List<String> options) {
		super(textLocation);
		this.options = options;
	}

	public List<String> getOptions() {
		return options;
	}
}
