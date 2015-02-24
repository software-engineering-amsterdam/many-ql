package cons;

import java.util.HashMap;
import java.util.Map;

import cons.ql.ast.expression.Identifier;
import cons.ql.ast.expression.QLType;

public class TypeRegister {
	private Map<String, QLType> register = new HashMap<String, QLType>();
	
	public TypeRegister() {}
	
	public void store(Identifier identifier, QLType typeInstance) {
		register.put(identifier.toString(), typeInstance);
	}
	
	public QLType resolve(Identifier identifier) {
		return register.get(identifier.toString());
	}
	
	public Map<String, QLType> getBindings() {
		return this.register;
	}
	
	public void clear() {
		this.register.clear();
	}
}
