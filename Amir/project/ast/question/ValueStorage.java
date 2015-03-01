package project.ast.question;

import java.util.HashMap;
import java.util.Map;

import project.ast.value.TypeValue;

public class ValueStorage {
	public static HashMap<String, TypeValue> vali = new HashMap<String,TypeValue>();;
	public Map<String, TypeValue> _values;
	public ValueStorage (){//(Map<String, Value> vls){
//		this._values = vls;
	}
	
	TypeValue ii (){
//		this._values.put(arg0, arg1);
		return this._values.get("hasSoldHouse");
//		_values.put("ASD", new NumericalValue(3));
	}
//	List<>
}
