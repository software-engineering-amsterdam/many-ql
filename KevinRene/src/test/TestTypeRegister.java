package test;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import cons.TypeRegister;
import cons.ql.ast.expression.Identifier;
import cons.ql.ast.expression.literal.StringLiteral;
import cons.ql.ast.expression.type.QLFloat;
import cons.ql.ast.statement.Question;

public class TestTypeRegister {
	
	@After
	public void emptyRegister() {
		TypeRegister.getInstance().clear();
	}
	
	@Test
	public void testRegistration() {
		TypeRegister register = TypeRegister.getInstance();
		
		StringLiteral myString = new StringLiteral("My String");
		Identifier myIdentifier = new Identifier("aString");
		
		register.store(myIdentifier, myString.getType());
		
		assertEquals("Should return my previously bound type instance.", 
			register.resolve(myIdentifier).toString(), "QLString");
		
		myString = new StringLiteral("Other value");
		TypeRegister.getInstance().store(myIdentifier, myString.getType());
		
		assertEquals("Should return the newly bound type instance.", "QLString",
				register.resolve(myIdentifier).toString());
	}
	
	@Test
	public void throwsQLError() {
		TypeRegister register = TypeRegister.getInstance();
		
		Identifier myIdentifier = new Identifier("aString");
		
		assertEquals("Should return the error type", "QLError",
				register.resolve(myIdentifier).toString());
	}
	
	@Test
	public void testAdvancedRegistration() {
		TypeRegister register = TypeRegister.getInstance();
		
		Question question = new Question(
				new Identifier("houseValue"), 
				new QLFloat(), 
				new StringLiteral("Value of house"));
		
		// The creation above should have added the identifier
		// of the question to the register with a type of QLFloat()
		
		assertEquals("Should return the QLFLoat type", "QLFloat",
				register.resolve(question.getIdentifier()).toString());
	}
	@Test
	public void testDoubleRegistration() {
		TypeRegister register = TypeRegister.getInstance();
		
		Question question = new Question(
				new Identifier("houseValue"), 
				new QLFloat(), 
				new StringLiteral("Value of house"));
		
		Question question2 = new Question(
				new Identifier("carValue"), 
				new QLFloat(), 
				new StringLiteral("Value of car"));
		
		// The creation above should have added the identifier
		// of the questions to the register with a type of QLFloat()

		assertEquals("Should return the QLFLoat type", "QLFloat",
				register.resolve(question.getIdentifier()).toString());
		assertEquals("Should return the QLFLoat type", "QLFloat",
				register.resolve(question2.getIdentifier()).toString());
	}
}
