package uva.qls.ast.type;

import uva.qls.ast.type.TypeBoolean;
import uva.qls.ast.type.TypeInteger;
import uva.qls.ast.type.TypeMoney;
import uva.qls.ast.type.TypeString;

public interface TypeVisitor<T> {

	public T visitTypeBoolean(TypeBoolean booleanType);
	public T visitTypeInteger(TypeInteger integerType);
	public T visitTypeMoney(TypeMoney moneyType);
	public T visitTypeString(TypeString stringType);
}
