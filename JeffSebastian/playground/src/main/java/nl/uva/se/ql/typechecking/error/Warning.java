package nl.uva.se.ql.typechecking.error;

public class Warning extends AbstractError {

	public Warning(int line, int offset, String name, String description) {
		super(line, offset, name, description);
	}

	@Override
	public String toString() {
		return "Warning! " + super.toString();
	}
}
