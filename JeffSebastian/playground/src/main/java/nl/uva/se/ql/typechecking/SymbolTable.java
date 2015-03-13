package nl.uva.se.ql.typechecking;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import nl.uva.se.ql.ast.statement.Question;
import nl.uva.se.ql.ast.type.Type;

public class SymbolTable {

	private Map<String, Question> symbols;
	
	public SymbolTable() {
		symbols = new HashMap<String, Question>();
	}
	
	public void addSymbol(String name, Question question) {
		symbols.put(name, question);
	}
	
	public boolean containsSymbol(String name) {
		return symbols.containsKey(name);
	}
	
	public Type getTypeForSymbol(String name) {
		return symbols.get(name).getType();
	}
	
	public Question getQuestionForSymbol(String name) {
		return symbols.get(name);
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		for (Entry<String, Question> entry : symbols.entrySet()) {
			sb.append(entry.getKey() + ": " + entry.getValue().getType());
			sb.append("\n");
		}
		
		return sb.toString();
	}
	
}
