package test;

import static org.junit.Assert.assertEquals;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import cons.TypeRegister;
import cons.ql.ast.expression.Identifier;
import cons.ql.ast.expression.literal.StringLiteral;
import cons.ql.ast.expression.type.QLFloat;
import cons.ql.ast.statement.Question;

public class TestTypeRegister {
	private TypeRegister register = TypeRegister.getInstance();
	
	@Rule
	public ExpectedException expected = ExpectedException.none();
	
	@Test
	public void testRegistration() {
		StringLiteral myString = new StringLiteral("My String");
		Identifier myIdentifier = new Identifier("aString");
		
		register.store(myIdentifier, myString.getType());
		
		assertEquals("Should return my previously bound type instance.", 
			register.resolve(myIdentifier).toString(), "QLString");
		
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
	
	@Test
	public void testAdvancedRegistration() {
		Question question = new Question(
				new Identifier("houseValue"), 
				new QLFloat(), 
				new StringLiteral("Value of house"));
		
		// The creation above should have added the identifier
		// of the question to the register with a type of QLFloat()
		
		assertEquals("Should return the QLFLoat type", 
				register.resolve(question.getIdentifier()).toString(), "QLFloat");
	}
	@Test
	public void testDoubleRegistration() {
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

		assertEquals("Should return the QLFLoat type", 
				register.resolve(question.getIdentifier()).toString(), "QLFloat");
		assertEquals("Should return the QLFLoat type", 
				register.resolve(question2.getIdentifier()).toString(), "QLFloat");
	}
}
