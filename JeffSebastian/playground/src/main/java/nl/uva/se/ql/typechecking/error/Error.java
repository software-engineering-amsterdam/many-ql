package nl.uva.se.ql.typechecking.error;

public abstract class Error extends AbstractError {

	public Error(int line, int offset, String name, String description) {
		super(line, offset, name, description);
	}

	@Override
	public String toString() {
		return "ERROR! " + super.toString();
	}

}
