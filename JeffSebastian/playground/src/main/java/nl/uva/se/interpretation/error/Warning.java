package nl.uva.se.interpretation.error;

public class Warning extends AbstractFailure {

	public Warning(int line, int offset, String name, String description) {
		super(line, offset, name, description);
	}

	@Override
	public String toString() {
		return "Warning! " + super.toString();
	}
}
