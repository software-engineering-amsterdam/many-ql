package nl.uva.se.interpreter.error;

public abstract class Error extends AbstractFailure {

	public Error(int line, int offset, String name, String description) {
		super(line, offset, name, description);
	}

	@Override
	public String toString() {
		return "ERROR! " + super.toString();
	}

}
