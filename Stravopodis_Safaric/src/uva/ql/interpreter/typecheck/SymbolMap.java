package uva.ql.interpreter.typecheck;
import uva.ql.interpreter.typecheck.Symbol;
import java.util.*;
import uva.ql.interpreter.typecheck.SymbolMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;



import java.util.Map;
import java.util.Set;


public class SymbolMap {
	protected List <Symbol> symbolList = new ArrayList<Symbol>();
	protected Map<String, List<Symbol>> symbols;
	
	public SymbolMap(){
		symbols = new HashMap<String,List<Symbol>>();
	}
	public void putValue(String name, List<Symbol> symbolList, Symbol symbol){
		symbolList.add(symbol);
		symbols.put(name, symbolList);
	}
	
	public List<Symbol> retrieve(String name){
		if (symbols.get(name) != null)
			return symbols.get(name);
		else return null;
	}
	public boolean symbolExists(String name, Symbol symbol){
		return retrieve(name).contains(symbol);
	}
	public List<Symbol> retrieve(String name, Symbol symbol){
		return retrieve(name + symbol);
	}
	public boolean exists(String name){
		return retrieve(name) != null;
	}
	public Set<String> getAllKeys(){
		return symbols.keySet();
	}
	@Override
	public String toString(){
		return symbols.keySet().toString();
	}
}

