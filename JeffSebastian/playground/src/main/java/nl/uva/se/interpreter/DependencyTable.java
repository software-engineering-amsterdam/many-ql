package nl.uva.se.interpreter;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class DependencyTable {

	private Map<String, Set<String>> dependencies;
	
	public DependencyTable() {
		dependencies = new HashMap<String, Set<String>>();
	}
	
	public void addDependency(String from, String to) {
		if (dependencies.containsKey(from)) {
			dependencies.get(from).add(to);
		} else {
			dependencies.put(from, new HashSet<String>());
		}
	}
	
	public Set<String> getDependenciesFor(String name) {
		if (dependencies.containsKey(name)) {
			return dependencies.get(name);
		}
		
		return Collections.<String> emptySet();
	}
}
