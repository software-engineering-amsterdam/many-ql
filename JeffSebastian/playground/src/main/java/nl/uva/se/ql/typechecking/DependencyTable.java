package nl.uva.se.ql.typechecking;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

public class DependencyTable {

	private Map<String, Set<String>> dependencies;
	
	public DependencyTable() {
		dependencies = new HashMap<String, Set<String>>();
	}
	
	public void addDependency(String from, String to) {
		if (dependencies.containsKey(from)) {
			dependencies.get(from).add(to);
		} else {
			Set<String> set = new HashSet<String>();
			set.add(to);
			dependencies.put(from, set);
		}
	}
	
	public Set<String> getDependenciesFor(String name) {
		if (dependencies.containsKey(name)) {
			return dependencies.get(name);
		}
		
		return Collections.<String> emptySet();
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		for (Entry<String, Set<String>> entry : dependencies.entrySet()) {
			sb.append(entry.getKey() + ": ");
			for (String s : entry.getValue()) {
				sb.append(s + ", ");
			}
			sb.append("\n");
		}
		
		return sb.toString();
	}
}
