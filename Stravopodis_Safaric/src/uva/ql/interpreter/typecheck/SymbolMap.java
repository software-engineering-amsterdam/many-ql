package uva.ql.interpreter.typecheck;
import uva.ql.ast.expressions.Type;
import uva.ql.interpreter.typecheck.Symbol;

import java.util.*;

import uva.ql.interpreter.typecheck.SymbolMap;

import java.util.List;
import java.util.Map;
import java.util.Set;


public class SymbolMap {
	
	protected Map<String, List<Symbol>> symbols;
	
	public SymbolMap(){
		this.symbols = new HashMap<String, List<Symbol>>();
	}
	public void putValue(String name, Symbol symbol){
		if (!this.exists(name)){
			this.putValueToList(new ArrayList<Symbol>(), name, symbol);
		}
		else {
			this.putValueToList(this.retrieve(name), name, symbol);
		}
	}
	private void putValueToList(List<Symbol> symbolsList, String name, Symbol symbol){
		symbolsList.add(symbol);
		this.symbols.put(name, symbolsList);
	}
	
	public List<Symbol> retrieve(String name){
		if (symbols.get(name) != null)
			return symbols.get(name);
		else return null;
	}
	public boolean exists(String name){
		return retrieve(name) != null;
	}
	public boolean existsWithClassType(String name, String className){
		if (this.exists(name)){
			for (Symbol s : this.retrieve(name)){
				if (s.className.equals(className)) return true;
			}
		}
		return false;
	}
	public boolean keyWithSymbolExists(String name, Symbol symbol){
		if (this.exists(name))
			return this.retrieve(name).contains(symbol);
		return false;
	}
	public Set<String> getAllKeys(){
		return symbols.keySet();
	}
	public List<Type> getTypesForKey(String name){
		List<Type> listOfTypes = new ArrayList<Type>();
		for (Symbol s : this.retrieve(name))
			listOfTypes.add(s.getSymbolType());
		return listOfTypes;
	}
	@Override
	public String toString(){
		return symbols.keySet().toString();
	}
}

