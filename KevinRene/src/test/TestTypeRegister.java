package test;

import static org.junit.Assert.assertEquals;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import cons.TypeRegister;
import cons.exception.UndefinedVariableException;
import cons.ql.ast.expression.Identifier;
import cons.ql.ast.expression.literal.StringLiteral;
import cons.ql.ast.statement.Form;

public class TestTypeRegister {
	private TypeRegister register = TypeRegister.getInstance();
	
	@Rule
	public ExpectedException expected = ExpectedException.none();
	
	@Test
	public void testRegistration() throws UndefinedVariableException {
		StringLiteral myString = new StringLiteral("My String");
		Identifier myIdentifier = new Identifier("aString");
		
		register.store(myIdentifier, myString.getType());
		try {
			assertEquals("Should return my previously bound type instance.", 
					register.resolve(myIdentifier).toString(), "QLString");
		} catch(Exception e) {
			
		}
		
		myString = new StringLiteral("Other value");
		TypeRegister.getInstance().store(myIdentifier, myString.getType());
		
		assertEquals("Should return the newly bound type instance.", 
				register.resolve(myIdentifier).toString(), "QLString");
	}
	
	@Test
	public void throwsQLError() {
		Identifier myIdentifier = new Identifier("aString");
		
		assertEquals("Should return the error type", 
				register.resolve(myIdentifier).toString(), "QLError");
	}
}
