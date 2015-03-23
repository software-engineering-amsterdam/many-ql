package uva.ql.interpreter.typecheck.depedency;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class DependencyTable {

	private Map<String,DependencySet> dependencies = new HashMap<String,DependencySet>();
	
	public DependencyTable(){}
	
	public Collection<DependencySet> getValues(){
		return this.dependencies.values();
	}
	
	public Set<String> getKeys(){
		return this.dependencies.keySet();
	}
	
	public DependencyTable(Map<String,DependencySet> _dependencies){
		this.dependencies=_dependencies;
		
	}
	
	public Map<String,DependencySet> getDependencyTable(){
		return this.dependencies;
	}
	
	public void putValue(String key, DependencySet value) {
		this.dependencies.put(key, value);
	}

	public boolean keyExists(String key) {
		return this.dependencies.containsKey(key);
	}

	public boolean valueExists(String key, DependencySet value) {
		return this.dependencies.containsValue(value);
	}

	public DependencySet retrieveValue(String key) {
		return this.dependencies.get(key);
	}

	public String toString() {
		return this.dependencies.toString();
	}

	

}
