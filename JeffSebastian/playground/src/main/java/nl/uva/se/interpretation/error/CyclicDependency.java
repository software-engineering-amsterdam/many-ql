package nl.uva.se.interpretation.error;

public class CyclicDependency extends Error {

	public CyclicDependency(int line, int offset) {
		super(line, offset, "cyclic dependency", "found cyclic dependency");
	}

}
