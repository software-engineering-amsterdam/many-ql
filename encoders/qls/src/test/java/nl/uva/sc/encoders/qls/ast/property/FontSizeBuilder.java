package nl.uva.sc.encoders.qls.ast.property;

import static nl.uva.sc.encoders.ql.ast.TextLocationBuilder.aTextLocation;
import nl.uva.sc.encoders.ql.ast.TextLocation;

public class FontSizeBuilder {

	private TextLocation textLocation;
	private int value;

	public static FontSizeBuilder aFontSize() {
		FontSizeBuilder fontSizeBuilder = new FontSizeBuilder();
		fontSizeBuilder.textLocation = aTextLocation().build();
		fontSizeBuilder.value = 20;
		return fontSizeBuilder;
	}

	public FontSize build() {
		return new FontSize(textLocation, value);
	}

}
