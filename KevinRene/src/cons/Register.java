package cons;

import java.util.HashMap;

import cons.exception.UndefinedVariableException;
import cons.ql.ast.ASTNode;
import cons.ql.ast.expression.literal.*;

public class Register {
	private HashMap<QLIdent, ASTNode> register = new HashMap<QLIdent, ASTNode>();
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
}
