package nl.uva.sc.encoders.qls.ast.widget;

import java.util.List;

import nl.uva.sc.encoders.ql.ast.TextLocation;

public class RadioBuilder {

	private TextLocation textLocation;
	private List<String> options;

	public static RadioBuilder aRadio() {
		RadioBuilder builder = new RadioBuilder();
		builder.textLocation = new TextLocation(20, 5);
		builder.options.add("Off Course!");
		builder.options.add("No idiot..");
		builder.options.add("Well ehm, perhaps, maybe?");
		return builder;
	}

	public Radio build() {
		Radio radio = new Radio(textLocation, options);
		return radio;
	}

	public RadioBuilder withTextLocation(TextLocation textLocation) {
		this.textLocation = textLocation;
		return this;
	}

}
