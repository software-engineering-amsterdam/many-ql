package nl.uva.sc.encoders.qls.ast;

public class SectionBuilder {

	private String name;

	public static SectionBuilder aSection() {
		SectionBuilder builder = new SectionBuilder();
		builder.name = "Section with all kinds of Crap";
		return builder;
	}

	public SectionBuilder withName(String name) {
		this.name = name;
		return this;
	}

}
