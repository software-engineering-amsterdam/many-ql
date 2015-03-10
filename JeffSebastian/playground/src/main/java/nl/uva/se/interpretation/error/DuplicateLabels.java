package nl.uva.se.interpretation.error;

public class DuplicateLabels extends Warning {

	public DuplicateLabels(int line, int offset, String label) {
		super(line, offset, "duplicate labels", label + " is already defined!");
	}

}
