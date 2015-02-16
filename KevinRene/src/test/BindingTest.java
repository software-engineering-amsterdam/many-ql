package test;

import static org.junit.Assert.assertEquals;

import java.util.Iterator;
import java.util.Map.Entry;

import org.junit.Test;

import cons.Register;
import cons.ql.ast.ASTNode;
import cons.ql.ast.expression.QLType;
import cons.ql.ast.expression.literal.QLIdent;
import cons.ql.ast.visitor.binder.Binder;
import cons.ql.parser.Parser;

public class BindingTest {

	private Register register = Register.getInstance();
	
	@SuppressWarnings("rawtypes")
	@Test
	public void testRegisteringIdent() {
		String myExpression = "lol : money { \"something\" } ";
		
		ASTNode myTree = Parser.parse(myExpression);
		Binder binder = new Binder();
		
		myTree.accept(binder);
		
		assertEquals(register.getBindings().size(), 1);
		
		Iterator<Entry<QLIdent, QLType>> iterator = register.getBindings().entrySet().iterator();
		while (iterator.hasNext()) {
			Entry<QLIdent, QLType> curr = iterator.next();
			System.out.println(curr.getKey().toString() + " -> " + curr.getValue().getName());
		}
		
	}
}
