package uva.ql.interpreter.typecheck.depedency;

import java.util.HashSet;
import java.util.Set;

public class IdentifierSet {

	private Set<String> identifiers;

	public IdentifierSet(){
		this.identifiers = new HashSet<String>();
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
	
	public boolean isEmpty(){
		return this.identifiers.isEmpty();
	}
	
	public boolean containsIdentifier(String _identifier){
		for (String identifier : this.identifiers){
			if (identifier.equals(_identifier)){
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



