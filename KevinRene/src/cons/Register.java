package cons;

import java.util.HashMap;
import java.util.Map;

import cons.exception.UndefinedVariableException;
import cons.ql.ast.ASTNode;
import cons.ql.ast.expression.literal.Identifier;

public class Register {
	private Map<Identifier, ASTNode> register = new HashMap<Identifier, ASTNode>();
	private final static Register INSTANCE = new Register();
	
	private Register() {}
	
	public static Register getInstance() {
		return INSTANCE;
	}
	
	public void store(Identifier identifier, ASTNode typeInstance) {
		register.put(identifier, typeInstance);
	}
	
	public ASTNode resolve(Identifier identifier) throws UndefinedVariableException {
		if(register.containsKey(identifier)) {
			return register.get(identifier);
		}
		
		throw new UndefinedVariableException(identifier.toString() + " is undefined.");
	}
	
	public Map<Identifier, ASTNode> getBindings() {
		return this.register;
	}	
}
