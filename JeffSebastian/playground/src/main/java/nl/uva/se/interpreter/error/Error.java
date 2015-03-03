package nl.uva.se.interpreter.error;

public class Error {

	private int line;
	private int offset;
	private String name;
	private String description;
	
	public Error(int line, int offset, String name, String description) {
		this.line = line;
		this.offset = offset;
		this.name = name;
		this.description = description;
	}

	public int getLine() {
		return line;
	}

	public void setLine(int line) {
		this.line = line;
	}

	public int getOffset() {
		return offset;
	}

	public void setOffset(int offset) {
		this.offset = offset;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
