package uva.ql.interpreter.typecheck.depedency;

import java.util.HashSet;
import java.util.Set;

import uva.ql.interpreter.typecheck.table.DependencyTable;

public class DependencyHelper {

	
	public DependencyTable populateDependencyTable(DependencyTable table){
		
		for (String identifier : table.getKeys()){
			IdentifierSet identifierSet = table.retrieveIdentifierSet(identifier);
			
			for (String _identifier : identifierSet.retrieveIdentifiers()){	
				
				if (!_identifier.equals(identifier)){
					
					if (!table.valueEmpty(_identifier)){
						IdentifierSet _identifierSet = table.retrieveIdentifierSet(_identifier);
						
						for (String key : _identifierSet.retrieveIdentifiers()){	
				
							if (key.equals(identifier)){
								identifierSet.putValue(key);
								table.putIdentifierSet(identifier, identifierSet);
							}
						}
					}
				}
			}
		}
		
	   return table;
	}

	public Set<String> getCycles(DependencyTable table){
		
		Set<String> cycles = new HashSet<String>();
		
		for (String key : table.getKeys()){
			IdentifierSet value = table.retrieveIdentifierSet(key);
			cycles = this.hasDependencies(cycles, value, key);
		}
		
		return cycles;
	}
	
	private Set<String> hasDependencies(Set<String> cycles, IdentifierSet identifierSet, String key){
		
		if (identifierSet.containsIdentifier(key)){
			cycles.add(key);
		}
		
		return cycles;
	}
	
}
