package cons;

import java.util.HashMap;

import cons.exception.UndefinedVariableException;
import cons.ql.ast.expression.QLType;
import cons.ql.ast.expression.literal.*;

@SuppressWarnings("rawtypes")
public class Register {
	private HashMap<QLIdent, QLType> register = new HashMap<QLIdent, QLType>();
	private final static Register INSTANCE = new Register();
	
	private Register() {}
	
	public static Register getInstance() {
		return INSTANCE;
	}
	
	public void registerBinding(QLIdent identifier, QLType typeInstance) {
		register.put(identifier, typeInstance);
	}
	
	public QLType getBinding(QLIdent identifier) throws UndefinedVariableException {
		if(register.containsKey(identifier)) {
			return register.get(identifier);
		}
		
		throw new UndefinedVariableException(identifier.getValue() + " is undefined.");
	}
}
