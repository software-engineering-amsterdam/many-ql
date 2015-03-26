package nl.uva.sc.encoders.qls.ast.parser;

import java.util.List;

import nl.uva.sc.encoders.ql.validation.SyntaxError;
import nl.uva.sc.encoders.qls.ast.Stylesheet;

public class StylesheetParsingResult {

	private final Stylesheet stylesheet;

	private final List<SyntaxError> syntaxErrors;

	public StylesheetParsingResult(Stylesheet stylesheet, List<SyntaxError> syntaxErrors) {
		this.stylesheet = stylesheet;
		this.syntaxErrors = syntaxErrors;
	}

	public Stylesheet getStylesheet() {
		return stylesheet;
	}

	public List<SyntaxError> getSyntaxErrors() {
		return syntaxErrors;
	}

}
