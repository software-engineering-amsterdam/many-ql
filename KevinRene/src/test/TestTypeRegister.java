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
		
	@Test
	public void testRegistration() {
		TypeRegister register = new TypeRegister();
		
		StringLiteral myString = new StringLiteral("My String");
		Identifier myIdentifier = new Identifier("aString");
		
		register.store(myIdentifier, myString.getType());
		
		assertEquals("Should return my previously bound type instance.", 
			register.resolve(myIdentifier).toString(), "QLString");
		
		myString = new StringLiteral("Other value");
		register.store(myIdentifier, myString.getType());
		
		assertEquals("Should return the newly bound type instance.", "QLString",
				register.resolve(myIdentifier).toString());
	}
	
	@Test
	public void throwsQLError() {
		TypeRegister register = new TypeRegister();
		
		Identifier myIdentifier = new Identifier("aString");
		
		assertEquals("Should return the error type", "QLError",
				register.resolve(myIdentifier).toString());
	}
	
	@Test
	public void testAdvancedRegistration() {
		TypeRegister register = new TypeRegister();
		
		Question question = new Question(
				new Identifier("houseValue"), 
				new QLFloat(), 
				new StringLiteral("Value of house"));
		
		register.store(question.getIdentifier(), question.getType());
		
		assertEquals("Should return the QLFLoat type", "QLFloat",
				register.resolve(question.getIdentifier()).toString());
	}
	@Test
	public void testDoubleRegistration() {
		TypeRegister register = new TypeRegister();
		
		Question question = new Question(
				new Identifier("houseValue"), 
				new QLFloat(), 
				new StringLiteral("Value of house"));
		
		Question question2 = new Question(
				new Identifier("carValue"), 
				new QLFloat(), 
				new StringLiteral("Value of car"));
		
		register.store(question.getIdentifier(), question.getType());
		register.store(question2.getIdentifier(), question2.getType());

		assertEquals("Should return the QLFLoat type", "QLFloat",
				register.resolve(question.getIdentifier()).toString());
		assertEquals("Should return the QLFLoat type", "QLFloat",
				register.resolve(question2.getIdentifier()).toString());
	}
}
