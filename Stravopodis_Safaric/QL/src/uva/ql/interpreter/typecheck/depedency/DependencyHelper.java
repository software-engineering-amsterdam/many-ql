package uva.ql.interpreter.typecheck.depedency;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class DependencyHelper {

	
	public static DependencyTable populateFullDependencies(DependencyTable table){
		
		Iterator<DependencySet> itr = table.getValues().iterator();
		
	    while (itr.hasNext()) {
	    	DependencySet list = itr.next();
	    	
	    	for (String identifier : list.retrieveIdentifiers()){
	    		for (String key : table.getKeys()){
	    			DependencySet _list = table.retrieveValue(key);
	    			
	    			if (identifier.equals(key)){
	    				for (String m: _list.retrieveIdentifiers()){
	    					list.putValue(m);
	    				}
	    				table.putValue(key, list);
	    			}
	    		}
	    	} 		
		}
	   return table;
	}
	

	public static Set<String> findCycles(DependencyTable _table){
		Set<String> cycles = new HashSet<String>();
		
		for (String key : _table.getKeys()){
			DependencySet value = _table.retrieveValue(key);
			
			if (value.containsIdentifier(key)){
				cycles.add(key);
			}
		}
		
		return cycles;
	}
}
