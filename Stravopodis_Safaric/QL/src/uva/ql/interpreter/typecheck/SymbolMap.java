package uva.ql.interpreter.typecheck;

import uva.ql.ast.expressions.Expression;
import uva.ql.ast.question.Question;
import uva.ql.ast.statements.Assign;
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
		if (!this.exists(name))
			this.putValueToList(new ArrayList<Symbol>(), name, symbol);
		else 
			this.putValueToList(this.retrieve(name), name, symbol);
	}
	
	private void putValueToList(List<Symbol> symbolsList, String name, Symbol symbol){
		symbolsList.add(symbol);
		this.symbols.put(name, symbolsList);
	}
	
	private void removeFromList(String identifier, Symbol oldSymbol){
		List<Symbol> symbols = this.retrieve(identifier);

		if (oldSymbol != null){
			symbols.remove(this.indexOfSymbol(symbols, oldSymbol));
			this.symbols.put(identifier, symbols);
		}
	}
	
	public void updateValue(String identifier, Expression expression){
		List<Symbol> symbols = this.retrieve(identifier);
		Symbol symbol = null;
		
		for (Symbol s : symbols){
			if (s.getClassName().equals(Assign.class.getName()) && !s.getSymbolType().equals("string")){
				symbol = s;
				break;
			}
		}
		
		this.removeFromList(identifier, symbol);
		this.putValue(identifier, this.prepareNewObject(identifier, expression));
	}
	
	private Symbol prepareNewObject(String identifier, Expression expression){
		Symbol question = this.getSymbolForAttributes(identifier, null, Question.class.getName());
		return new Symbol(question.getSymbolType(), Assign.class.getName(), question.getCodeLines(), expression);
	}
	
	public List<Symbol> retrieve(String name){
		if (symbols.get(name) != null)
			return symbols.get(name);
		else return null;
	}
	
	public Symbol retrieveSymbol(List<Symbol> listSymbols, String identifier, String className){
		return null;
	}
	
	public boolean exists(String name){
		return this.retrieve(name) != null;
	}
	
	public boolean existsWithClassType(String name, String className){
		if (this.exists(name)){
			for (Symbol s : this.retrieve(name)){
				if (className.equals(s.className))
					return true;
			}
		}
		return false;
	}
	
	public boolean keyWithSymbolExists(String name, Symbol symbol){
		if (this.exists(name)){
			for (Symbol s : this.retrieve(name)){
				if (symbol.equals(s)) return true;
			}
		}
		return false;
	}

	public Symbol getSymbolForAttributes(String name, String type, String className){
		int index = indexOfSymbol(this.retrieve(name), new Symbol(type, className, null));
		if (index != -1) return this.retrieve(name).get(index);
		return null;
	}
	
	public Set<String> getAllKeys(){
		return symbols.keySet();
	}
	
	public List<String> getTypesForKey(String name){
		List<String> listOfTypes = new ArrayList<String>();
		for (Symbol s : this.retrieve(name))
			listOfTypes.add(s.getSymbolType());
		return listOfTypes;
	}
	
	public int indexOfSymbol(List<Symbol> symbolList, Symbol symbol){
		for (int i=0; i < symbolList.size(); i++){
			if (symbol.equals(symbolList.get(i))) {
				return i;
			}
		}
		return -1;
	}
	
	public boolean contentExists(Object _content){
		for (String key : this.getAllKeys()){
			for (Symbol s : this.retrieve(key)){
				if (s.content != null)
					if (_content.toString().equals(s.content.toString())){
						return true;
				}
			}
		}
		return false;
	}
	
	public void printSymbolTable(){
		for (String s : this.symbols.keySet()){
			for (Symbol symbol : this.retrieve(s)){
				System.out.println("SYMBOLTABLE -> " + s + " - " + symbol.toString());
			}
		}
	}
	
	@Override
	public String toString(){
		return symbols.keySet().toString();
	}
}

