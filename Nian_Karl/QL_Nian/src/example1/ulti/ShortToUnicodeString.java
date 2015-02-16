package example1.ulti;

import example1.antlr.ArrayInitBaseListener;
import example1.antlr.ArrayInitParser;

public class ShortToUnicodeString extends ArrayInitBaseListener{
	@Override public void enterInit(ArrayInitParser.InitContext ctx) {
		System.out.print('"');
	}
	
	@Override public void exitInit(ArrayInitParser.InitContext ctx) {
		System.out.print('"');
	}
	
	@Override public void exitValue(ArrayInitParser.ValueContext ctx) {
		int value = Integer.valueOf(ctx.INT().getText());
		System.out.printf("\\u%04x", value);
	}
}
