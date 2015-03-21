package nl.uva.se.ql.typechecking;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import nl.uva.se.ql.ast.statement.Question;
import nl.uva.se.ql.typechecking.error.CyclicDependency;
import nl.uva.se.ql.typechecking.error.ErrorList;

public class CyclicDependencyChecker {

	private DependencyTable dependencies;
	private ErrorList errors;

	private CyclicDependencyChecker(DependencyTable dependencies) {
		this.dependencies = dependencies;
		errors = new ErrorList();
	}

	public static ErrorList check(DependencyTable dependencies) {
		CyclicDependencyChecker checker = new CyclicDependencyChecker(
				dependencies);
		checker.findCycles();

		return checker.errors;
	}

	private void findCycles() {
		for (Question q : dependencies) {
			checkDependenciesFor(q);
		}
	}

	private void checkDependenciesFor(Question question) {
		Set<Question> dpc = dependencies.getDependenciesFor(question);

		for (Question dependant : dpc) {
			if (dependant.equals(question)) {
				errors.addError(new CyclicDependency(question.getLineNumber(),
						question.getOffset()));
			}

			checkAllPaths(question, dependencies.getDependenciesFor(dependant),
					new ArrayList<Question>());
		}
	}

	private void checkAllPaths(Question question, Set<Question> dependants,
			List<Question> visited) {
		for (Question q : dependants) {
			if (!visited.contains(q)) {
				visited.add(q);
				if (q.equals(question)) {
					errors.addError(new CyclicDependency(question
							.getLineNumber(), question.getOffset()));
				}
				checkAllPaths(question, dependencies.getDependenciesFor(q),
						visited);
			}
		}
	}
}
