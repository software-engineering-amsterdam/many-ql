package nl.uva.se.ql.typechecking.error;

public abstract class AbstractError {

	private final int line;
	private final int offset;
	private final String name;
	private final String description;
	
	public AbstractError(int line, int offset, String name, String description) {
		this.line = line;
		this.offset = offset;
		this.name = name;
		this.description = description;
	}

	public int getLine() {
		return line;
	}

	public int getOffset() {
		return offset;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(name + " ");
		sb.append("(at " + line + ":" + offset + "): ");
		sb.append(description);
		
		return sb.toString();
	}
	
}
