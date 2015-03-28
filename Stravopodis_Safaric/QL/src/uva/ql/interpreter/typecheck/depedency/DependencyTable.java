package uva.ql.interpreter.typecheck.depedency;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class DependencyTable {

	private Map<String,IdentifierSet> dependencies = new HashMap<String,IdentifierSet>();
	
	public DependencyTable(){}
	
	public Collection<IdentifierSet> getValues(){
		return this.dependencies.values();
	}
	
	public Set<String> getKeys(){
		return this.dependencies.keySet();
	}
	
	public DependencyTable(Map<String,IdentifierSet> _dependencies){
		this.dependencies=_dependencies;
	}
	
	public Map<String,IdentifierSet> getDependencyTable(){
		return this.dependencies;
	}
	
	public void putValue(String key, IdentifierSet value) {
		this.dependencies.put(key, value);
	}

	public boolean keyExists(String key) {
		return this.dependencies.containsKey(key);
	}

	public boolean valueEmpty(String identifier){
		
		IdentifierSet set = this.retrieveValue(identifier);
		
		if (set == null){
			return true;
		}
		
		return set.isEmpty();
	}
	
	public IdentifierSet retrieveValue(String key) {
		return this.dependencies.get(key);
	}

	@Override
	public String toString() {
		return this.dependencies.toString();
	}
}
