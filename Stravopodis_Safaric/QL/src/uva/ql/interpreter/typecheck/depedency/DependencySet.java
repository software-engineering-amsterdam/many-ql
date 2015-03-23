package uva.ql.interpreter.typecheck.depedency;

import java.util.HashSet;
import java.util.Set;

public class DependencySet {

	private Set<String> identifiers = new HashSet<String>();

	public DependencySet(){}
	
	public DependencySet(DependencySet _set){
		this.identifiers = _set.identifiers;
	}
	
	public DependencySet(String _identifier){
		this.identifiers.add(_identifier);
	}
	
	public boolean containsItem(String _identifier){
		return this.identifiers.contains(_identifier);
	}
	
	public Set<String> retrieveIdentifiers(){
		return this.identifiers;
	}
	
	public void putValue(String _identifier){
		this.identifiers.add(_identifier);
	}
	
	public boolean containsIdentifier(String _identifier){
		for (String identifier : this.identifiers){
			if (identifier.contains(_identifier)){
				return true;
			}
		}
		return false;
	}
    
    @Override
    public String toString(){
    	return this.identifiers.toString();
    }
}



