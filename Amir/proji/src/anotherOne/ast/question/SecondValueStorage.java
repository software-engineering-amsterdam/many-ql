package anotherOne.ast.question;

import java.util.HashMap;
import java.util.Map;

import javax.swing.JComponent;

import anotherOne.ast.value.NumericalTypeValue;
import anotherOne.ast.value.TypeValue;

public class SecondValueStorage {
	public Map<String, JComponent> _values;
//	public Map map = new HashMap();
	public SecondValueStorage (){//(Map<String, Value> vls){
//		this._values = vls;
	}
	
	JComponent ii (){
//		this._values.put(arg0, arg1);
		return this._values.get("hasSoldHouse");
//		_values.put("ASD", new NumericalValue(3));
	}
//	List<>
}
