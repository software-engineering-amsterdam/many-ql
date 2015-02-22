package uva.ql.typecheck;
import uva.ql.ast.expressions.*;
import uva.ql.typecheck.Symbol;
import uva.ql.typecheck.SymbolMap;
import uva.ql.ast.expressions.literals.*;
import uva.ql.parser.QLParser.PrimitiveTypeContext;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

import java.util.*;

public class SymbolMap {
	
	protected Map<String, Symbol> smb = new LinkedHashMap <String,Symbol>();
	
	
	public void define (String name, ArrayList <String> arguments){
		String args = arguments.toString();
		Symbol symbol = new Symbol(null,name+args,null);
		define(symbol);
		}
	
	private void define(Symbol symbol){
		smb.put(symbol.name,symbol);
		}
	
	
	private Symbol retrieve(String name) {
		Symbol symbol = smb.get(name);
		if (symbol!=null) return symbol;
		return null;
	}
	
	public Symbol retrieve(String name, ArrayList<String> arguments){
		
		String args = arguments.toString();
		return retrieve(name+args);
	}
	
	public String toString() {
		
		return smb.keySet().toString();
	}
	 /*
	}
	
	protected void SymApp(String id, PrimitiveTypeContext primitiveTypeContext) {
		smb.put(this.id,this.tp);
		
		
	}
	
	protected void SymPrint() {
		
		System.out.println(this.smb);
	}*/
}

