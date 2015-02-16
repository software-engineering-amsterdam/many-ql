package cons;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import cons.exception.UndefinedVariableException;
import cons.ql.ast.expression.QLType;
import cons.ql.ast.expression.literal.*;

public class RegisterTest {
	private Register register = Register.getInstance();
	
	@Rule
	public ExpectedException expected = ExpectedException.none();
	
	@Test
	public void testRegistration() {
		QLString myString = new QLString("My String");
		QLIdent myIdentifier = new QLIdent("aString");
		
		register.registerBinding(myIdentifier, myString);
		try {
			assertEquals("Should return my previously bound type instance.", 
					register.getBinding(myIdentifier).toString(), "My String");
		} catch(Exception e) {
			
		}
		
		myString.setValue("Other value");
		Register.getInstance().registerBinding(myIdentifier, myString);
		
		try {
			assertEquals("Should return the newly bound type instance.", 
					register.getBinding(myIdentifier).toString(), "Other value");
		} catch(Exception e) {
			
		}
	}
	
	@Test
	public void throwsUndefinedVariableException() throws UndefinedVariableException {
		QLIdent myIdentifier = new QLIdent("aString");
		
		expected.expect(UndefinedVariableException.class);
		expected.expectMessage("aString is undefined");
		register.getBinding(myIdentifier);
	}
}
