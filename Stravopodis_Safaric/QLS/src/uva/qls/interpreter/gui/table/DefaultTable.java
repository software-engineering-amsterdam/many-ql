package uva.qls.interpreter.gui.table;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import uva.qls.ast.type.PrimitiveType;
import uva.qls.interpreter.typecheck.table.Table;

public class DefaultTable extends Table<String, Deque<DefaultTableValue>>{

	private Map<String, Deque<DefaultTableValue>> stacks;
	
	public DefaultTable(){
		this.initializeStacks();
	}
	
	public Map<String, Deque<DefaultTableValue>> getStacks(){
		return this.stacks;
	}
	
	public void clearStacks(){
		this.initializeStacks();
	}
	
	private void initializeStacks(){
		this.stacks = new HashMap<String, Deque<DefaultTableValue>>();
		
		for (String s : PrimitiveType.getAllTypes()){
			this.stacks.put(s, new ArrayDeque<DefaultTableValue>());
		}
	}
	
	@Override
	public void putValue(String identifier, Deque<DefaultTableValue> value) {
		this.stacks.put(identifier, value);
	}
	
	public void push(String identifier, DefaultTableValue value){
		Deque<DefaultTableValue> stack = this.retrieveValue(identifier);
		stack.push(value);
		this.putValue(identifier, stack);
	}
	
	public void pop(String identifier){
		Deque<DefaultTableValue> stack = this.retrieveValue(identifier);
		stack.pop();
		this.putValue(identifier, stack);
	}

	@Override
	public Deque<DefaultTableValue> retrieveValue(String identifier) {
		return this.stacks.get(identifier);
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}


}
