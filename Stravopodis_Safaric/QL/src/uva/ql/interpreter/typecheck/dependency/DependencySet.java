package uva.ql.interpreter.typecheck.dependency;

import java.util.HashSet;
import java.util.Set;


public class DependencySet {

	private Set<String> identifiers = new HashSet<String>();

	public DependencySet(){}
	
	public DependencySet(Set<String> _set){
		this.identifiers=_set;
	}
	
	public boolean containsItem(String _identifier){
		return this.identifiers.contains(_identifier);
	}
	
	public boolean containsIdentifier(String _identifier){
		for (String identifier : this.identifiers){
			System.out.println("===== > " + _identifier + " " + identifier);
			if (identifier.contains(_identifier)){
				return true;
			}
		}
		return false;
	}
	
	public DependencySet(String _identifier){
		this.identifiers.add(_identifier);
	}
	
	public Set<String> retrieveIdentifiers(){
		return this.identifiers;
	}
	
	public void putValue(String _identifier){
		this.identifiers.add(_identifier);
	}
    
    @Override
    public String toString(){
    	return this.identifiers.toString();
    }
}



