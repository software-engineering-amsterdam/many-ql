package nl.uva.se.ql.typechecking;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import nl.uva.se.ql.ast.statement.Question;

public class DependencyTable implements Iterable<Question> {

	private Map<Question, Set<Question>> dependencies;
	
	public DependencyTable() {
		dependencies = new HashMap<Question, Set<Question>>();
	}
	
	public void addDependency(Question from, Question to) {
		if (!dependencies.containsKey(from)) {
			dependencies.put(from, new HashSet<Question>());
		}
		
		dependencies.get(from).add(to);
	}
	
	public Set<Question> getDependenciesFor(Question name) {
		if (dependencies.containsKey(name)) {
			return dependencies.get(name);
		}
		
		return Collections.<Question> emptySet();
	}
	
	@Override
	public Iterator<Question> iterator() {
		return dependencies.keySet().iterator();
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		for (Entry<Question, Set<Question>> entry : dependencies.entrySet()) {
			sb.append(entry.getKey() + ": ");
			for (Question q : entry.getValue()) {
				sb.append(q.getId() + ", ");
			}
			sb.append("\n");
		}
		
		return sb.toString();
	}
	
}
