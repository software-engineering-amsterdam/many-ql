package test;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import cons.Register;
import cons.exception.UndefinedVariableException;
import cons.ql.ast.expression.literal.*;
import cons.ql.ast.statement.Block;
import cons.ql.ast.statement.Form;

public class RegisterTest {
	private Register register = Register.getInstance();
	
	@Rule
	public ExpectedException expected = ExpectedException.none();
	
	@Test
	public void testRegistration() throws UndefinedVariableException {
		QLString myString = new QLString("My String");
		QLIdent myIdentifier = new QLIdent("aString");
		
		register.registerBinding(myIdentifier, myString);
		try {
			assertEquals("Should return my previously bound type instance.", 
					register.getBinding(myIdentifier).toString(), "My String");
		} catch(Exception e) {
			
		}
		
		myString = new QLString("Other value");
		Register.getInstance().registerBinding(myIdentifier, myString);
		
		assertEquals("Should return the newly bound type instance.", 
				register.getBinding(myIdentifier).toString(), "Other value");
	}
	
	@Test
	public void testAutomaticRegistration() throws UndefinedVariableException {
		QLIdent myIdentifier = new QLIdent("taxFormExample");
		Form myForm = new Form(myIdentifier, null);
		
		assertEquals("A created form should be registered",
				register.getBinding(myIdentifier), myForm);
	}
	
	@Test
	public void throwsUndefinedVariableException() throws UndefinedVariableException {
		QLIdent myIdentifier = new QLIdent("aString");
		
		expected.expect(UndefinedVariableException.class);
		expected.expectMessage("aString is undefined");
		register.getBinding(myIdentifier);
	}
}
