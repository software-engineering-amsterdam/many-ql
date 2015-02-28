package uva.ql.interpreter.gui;

import java.util.HashMap;
import java.util.Map;

import uva.ql.ast.expressions.*;
import uva.ql.ast.expressions.literals.StringLiteral;
import uva.ql.interpreter.typecheck.Symbol;
import uva.ql.interpreter.typecheck.SymbolMap;

public class StoreTable {
	
	private Map<String, Expression> storeTable = new HashMap<String, Expression>();
	
	public StoreTable(SymbolMap _symbolTable){
		this.storeTable = this.symbolTableToStoreTable(_symbolTable);
		System.err.println(this.storeTable.toString());
	}
	
	public Map<String, Expression> getStoreTable(){
		return this.storeTable;
	}
	
	private Map<String, Expression> symbolTableToStoreTable(SymbolMap _symbolTable){
		Map<String, Expression> _storeTable = new HashMap<String, Expression>();
		
		for (String key : _symbolTable.getAllKeys()){
			for (Symbol s : _symbolTable.retrieve(key)){
				if (s.getContent() != null){
					
					if (!(s.getContent() instanceof StringLiteral))
						_storeTable.put(key, (Expression)s.getContent());
				}
			}
		}
		
		return _storeTable;
	}
	@Override
	public String toString(){
		String s = "";
		for (String key : this.storeTable.keySet()){
			s+=this.storeTable.get(key);
		}
		return s;
	}
	
}
