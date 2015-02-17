package cons;

import java.util.HashMap;
import java.util.Map;

import cons.exception.UndefinedVariableException;
import cons.ql.ast.ASTNode;
import cons.ql.ast.expression.type.QLIdentifier;

public class Register {
	private Map<QLIdentifier, ASTNode> register = new HashMap<QLIdentifier, ASTNode>();
	private final static Register INSTANCE = new Register();
	
	private Register() {}
	
	public static Register getInstance() {
		return INSTANCE;
	}
	
	public void store(QLIdentifier identifier, ASTNode typeInstance) {
		register.put(identifier, typeInstance);
	}
	
	public ASTNode resolve(QLIdentifier identifier) throws UndefinedVariableException {
		if(register.containsKey(identifier)) {
			return register.get(identifier);
		}
		
		throw new UndefinedVariableException(identifier.getValue() + " is undefined.");
	}
	
	public Map<QLIdentifier, ASTNode> getBindings() {
		return this.register;
	}	
}
