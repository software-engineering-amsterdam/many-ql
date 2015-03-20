package nl.uva.se.ql.typechecking;

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
		CyclicDependencyChecker checker = new CyclicDependencyChecker(dependencies);
		checker.findCycles();
		
		return checker.errors;
	}
	
	private void findCycles() {
		for (Question q : dependencies) {
			checkDependenciesFor(q);
		}
	}
	
	/**
	 * Dependency check stops after the first occurance of a cyclic dependency
	 * 
	 * @param question
	 */
	private void checkDependenciesFor(Question question) {
		Set<Question> dpc = dependencies.getDependenciesFor(question);
		
		for (Question dependant : dpc) {
			if (dependant.equals(question)) {
				errors.addError(new CyclicDependency(question.getLineNumber(), 
						question.getOffset()));
				return;
			}
			
			checkAllPaths(question, dependencies.getDependenciesFor(dependant));
		}
	}
	
	private void checkAllPaths(Question question, Set<Question> dependants) {
		for (Question q : dependants) {
			if (q.equals(question)) {
				errors.addError(new CyclicDependency(question.getLineNumber(), 
						question.getOffset()));
				return;
			}
		}
	}
}
