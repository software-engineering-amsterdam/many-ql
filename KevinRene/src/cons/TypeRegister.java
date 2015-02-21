package cons;

import java.util.HashMap;
import java.util.Map;

import cons.exception.UndefinedVariableException;
import cons.ql.ast.expression.Identifier;
import cons.ql.ast.expression.QLType;
import cons.ql.ast.expression.type.QLError;

public class TypeRegister {
	private Map<Identifier, QLType> register = new HashMap<Identifier, QLType>();
	private final static TypeRegister INSTANCE = new TypeRegister();
	
	private TypeRegister() {}
	
	public static TypeRegister getInstance() {
		return INSTANCE;
	}
	
	public void store(Identifier identifier, QLType typeInstance) {
		register.put(identifier, typeInstance);
	}
	
	public QLType resolve(Identifier identifier) {
		if(register.containsKey(identifier)) {
			return register.get(identifier);
		}
		else {
			return new QLError();
		}
	}
	
	public Map<Identifier, QLType> getBindings() {
		return this.register;
	}	
}
