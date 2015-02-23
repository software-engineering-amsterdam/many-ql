package cons;

import java.util.HashMap;
import java.util.Map;

import cons.ql.ast.expression.Identifier;
import cons.ql.ast.expression.QLType;
import cons.ql.ast.expression.type.QLError;

public class TypeRegister {
	private Map<String, QLType> register = new HashMap<String, QLType>();
	
	public TypeRegister() {}
	
	public void store(Identifier identifier, QLType typeInstance) {
		register.put(identifier.toString(), typeInstance);
	}
	
	public QLType resolve(Identifier identifier) {
		if(register.containsKey(identifier.toString())) {
			return register.get(identifier.toString());
		}
		else {
			return new QLError();
		}
	}
	
	public Map<String, QLType> getBindings() {
		return this.register;
	}
	
	public void clear() {
		this.register.clear();
	}
}
