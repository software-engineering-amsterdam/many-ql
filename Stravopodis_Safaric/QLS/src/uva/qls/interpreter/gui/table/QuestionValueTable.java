package uva.qls.interpreter.gui.table;
import java.util.HashMap;
import java.util.Map;

import uva.qls.ast.statements.*;
import uva.qls.interpreter.typecheck.table.Table;

public class QuestionValueTable extends Table<Question, DefaultTableValue> {

	private Map<Question, DefaultTableValue> table;
	
	public QuestionValueTable(){
		this.table = new HashMap<Question, DefaultTableValue>();
	}
	
	public Map<Question, DefaultTableValue> getTable(){
		return this.table;
	}
	
	@Override
	public void putValue(Question question, DefaultTableValue value) {
		this.table.put(question, value);
	}

	@Override
	public DefaultTableValue retrieveValue(Question question) {
		return this.table.get(question);
	}

	@Override
	public String toString() {
		return this.table.toString();
	}

	
	
}
