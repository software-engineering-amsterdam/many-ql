package cons;

import java.util.HashMap;
import java.util.Map;

import cons.exception.UndefinedVariableException;
import cons.ql.ast.ASTNode;
import cons.ql.ast.expression.type.QLIdent;

public class Register {

	private Map<QLIdent, ASTNode> register = new HashMap<QLIdent, ASTNode>();
	private final static Register INSTANCE = new Register();
	
	private Register() {}
	
	public static Register getInstance() {
		return INSTANCE;
	}
	
	public void registerBinding(QLIdent identifier, ASTNode typeInstance) {
		register.put(identifier, typeInstance);
	}
	
	public ASTNode getBinding(QLIdent identifier) throws UndefinedVariableException {
		if(register.containsKey(identifier)) {
			return register.get(identifier);
		}
		
		throw new UndefinedVariableException(identifier.getValue() + " is undefined.");
	}
	
	public Map<QLIdent, ASTNode> getBindings() {
		return this.register;
	}
	
}
