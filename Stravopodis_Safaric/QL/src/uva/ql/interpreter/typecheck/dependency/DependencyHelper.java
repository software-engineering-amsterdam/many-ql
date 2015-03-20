package uva.ql.interpreter.typecheck.dependency;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class DependencyHelper {

	
	public static DependencyTable populateFullDependencies(DependencyTable _table){
		
		Iterator<DependencySet> itr = _table.getValues().iterator();
		
	    while (itr.hasNext()) {
	    	DependencySet list = itr.next();

	    	for (String identifier : list.retrieveIdentifiers()){
	    		for (String key : _table.getKeys()){
	    			DependencySet _list = _table.retrieveValue(key);
	    			
	    			if (identifier.equals(key)){
	    				for (String m: _list.retrieveIdentifiers()){
	    					list.putValue(m);
	    				}
	    				_table.putValue(key, list);
	    			}
	    			
	    		}
	    	} 		
		}
	    System.out.println(_table.toString());
	    return _table;
	}
	
	
	public static boolean checkDependencies(String key, DependencySet value){
		for (String val : value.retrieveIdentifiers()){
			System.out.print("Checking......");
			if (key.equals(val)){
				return true;
			}
		}
		return false;
	}


	public static Set<String> findCycles(DependencyTable _table){
		Set<String> cycles = new HashSet<String>();
		
		for (String key : _table.getKeys()){
			DependencySet value = _table.retrieveValue(key);
			
			System.out.println("value: "  + key + " -> " + value.containsIdentifier(key) + " ==== " + value.retrieveIdentifiers());
			if (value.retrieveIdentifiers().contains(key)){
				System.out.println("Found for: " + key);
			}
		}
		
		return cycles;
	}
}
