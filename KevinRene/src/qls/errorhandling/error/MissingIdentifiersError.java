package qls.errorhandling.error;

import java.util.List;
import java.util.Set;

import ql.ast.QLNode;
import ql.ast.expression.Identifier;

public class MissingIdentifiersError extends qls.errorhandling.Error {
	public MissingIdentifiersError(QLNode origin, List<Identifier> processed, Set<Identifier> all) {
		super(origin, "(" + origin.getClass().getSimpleName() + ") misses the following identifiers.\n"
					+ missingIdentifierString(processed, all));
	}
	
	private static String missingIdentifierString(List<Identifier> processed, Set<Identifier> all) {
		StringBuilder missing = new StringBuilder("-- Missing Identifiers --\n");
		
		all.stream()
			.filter(identifier -> !processed.contains(identifier))
			.forEach(identifier -> missing.append("  > " + identifier + "\n"));
		
		return missing.toString();
	}
}
