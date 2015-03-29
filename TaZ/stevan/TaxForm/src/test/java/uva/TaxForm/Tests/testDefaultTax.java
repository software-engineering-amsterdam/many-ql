package uva.TaxForm.Tests;

import org.antlr.v4.runtime.*;
import org.junit.Test;

import uva.TaxForm.antlr4.TaxFormLexer;
import uva.TaxForm.antlr4.TaxFormParser;

public class testDefaultTax {
	
	@Test
	public void testDefaultForm() throws Exception {
		TaxFormLexer tfl = new TaxFormLexer(new ANTLRInputStream(getClass().getResourceAsStream("/default.tax")));
		TaxFormParser tfp = new TaxFormParser(new CommonTokenStream(tfl));
		
		tfp.addErrorListener(
			new BaseErrorListener() {
				
				@Override
				public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, 
										int line, int charPositionInLine, String msg, RecognitionException e) {
					throw new IllegalStateException("failed to parse at line " + line + " due to " + msg, e);
				}
			}
		);
	}
}
