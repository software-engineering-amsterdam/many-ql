package test;

import static org.junit.Assert.assertEquals;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import cons.Register;
import cons.exception.UndefinedVariableException;
import cons.ql.ast.expression.Identifier;
import cons.ql.ast.expression.literal.StringLiteral;
import cons.ql.ast.statement.Form;

public class RegisterTest {
	private Register register = Register.getInstance();
	
	@Rule
	public ExpectedException expected = ExpectedException.none();
	
	@Test
	public void testRegistration() throws UndefinedVariableException {
		StringLiteral myString = new StringLiteral("My String");
		Identifier myIdentifier = new Identifier("aString");
		
		register.store(myIdentifier, myString);
		try {
			assertEquals("Should return my previously bound type instance.", 
					register.resolve(myIdentifier).toString(), "My String");
		} catch(Exception e) {
			
		}
		
		myString = new StringLiteral("Other value");
		Register.getInstance().store(myIdentifier, myString);
		
		assertEquals("Should return the newly bound type instance.", 
				register.resolve(myIdentifier).toString(), "Other value");
	}
	
	@Test
	public void testAutomaticRegistration() throws UndefinedVariableException {
		Identifier myIdentifier = new Identifier("taxFormExample");
		Form myForm = new Form(myIdentifier, null);
		
		assertEquals("A created form should be registered",
				register.resolve(myIdentifier), myForm);
	}
	
	@Test
	public void throwsUndefinedVariableException() throws UndefinedVariableException {
		Identifier myIdentifier = new Identifier("aString");
		
		expected.expect(UndefinedVariableException.class);
		expected.expectMessage("aString is undefined");
		register.resolve(myIdentifier);
	}
}
