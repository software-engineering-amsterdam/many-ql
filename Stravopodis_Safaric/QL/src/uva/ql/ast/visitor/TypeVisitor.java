package uva.ql.ast.visitor;

import uva.ql.ast.type.TypeBoolean;
import uva.ql.ast.type.TypeInteger;
import uva.ql.ast.type.TypeMoney;
import uva.ql.ast.type.TypeString;

public interface TypeVisitor <T>{

	public T visitTypeBoolean(TypeBoolean booleanType);
	public T visitTypeInteger(TypeInteger integerType);
	public T visitTypeMoney(TypeMoney moneyType);
	public T visitTypeString(TypeString stringType);
	
}
