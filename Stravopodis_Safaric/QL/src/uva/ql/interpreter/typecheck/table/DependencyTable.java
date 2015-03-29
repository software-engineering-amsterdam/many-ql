package uva.ql.interpreter.typecheck.table;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import uva.ql.interpreter.typecheck.depedency.IdentifierSet;

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
	
	public void putIdentifierSet(String key, IdentifierSet set) {
		this.dependencies.put(key, set);
	}

	public boolean keyExists(String key) {
		return this.dependencies.containsKey(key);
	}

	public boolean valueEmpty(String identifier){
		
		IdentifierSet set = this.retrieveIdentifierSet(identifier);
		
		if (set == null){
			return true;
		}
		
		return set.isEmpty();
	}
	
	public IdentifierSet retrieveIdentifierSet(String key) {
		return this.dependencies.get(key);
	}

	@Override
	public String toString() {
		return this.dependencies.toString();
	}
}
