package com.form.language.test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.Random;

import org.junit.Test;

import com.form.language.ast.type.BoolType;
import com.form.language.ast.type.ErrorType;
import com.form.language.ast.type.IntType;
import com.form.language.ast.type.StringType;
import com.form.language.ast.values.BoolValue;
import com.form.language.ast.values.IntValue;
import com.form.language.ast.values.StringValue;

public class EqualityTest {
    
    Random randomgen = new Random();
    
    @Test
    public void typeEquality() {
	BoolType booltype = new BoolType();
	BoolType duplicateBool = new BoolType();
	assertEquals(booltype, duplicateBool);
	assertEquals(booltype.hashCode(), duplicateBool.hashCode());

	IntType inttype = new IntType();
	IntType duplicateInt = new IntType();
	assertEquals(inttype, duplicateInt);
	assertEquals(inttype.hashCode(), duplicateInt.hashCode());

	StringType stringtype = new StringType();
	StringType duplicateString = new StringType();
	assertEquals(stringtype, duplicateString);
	assertEquals(stringtype.hashCode(), duplicateString.hashCode());

	ErrorType errortype = new ErrorType();
	ErrorType duplicateError = new ErrorType();
	assertEquals(errortype, duplicateError);
	assertEquals(errortype.hashCode(), duplicateError.hashCode());
    }
    
    @Test
    public void intValueEquality(){
	int randomnumber = randomgen.nextInt();
	IntValue intvalue = new IntValue(randomnumber);
	IntValue duplicate = new IntValue(randomnumber);

	assertEquals(intvalue, duplicate);
	assertEquals(intvalue.hashCode(), duplicate.hashCode());
    }

    @Test
    public void boolValueEquality(){
	boolean randombool = randomgen.nextBoolean();
	BoolValue originalBool = new BoolValue(randombool);
	BoolValue duplicateBool = new BoolValue(randombool);
	BoolValue differentBool = new BoolValue(!randombool);

	assertEquals(originalBool, duplicateBool);
	assertEquals(originalBool.hashCode(), duplicateBool.hashCode());

	assertFalse(originalBool.equals(differentBool));
    }
    
    @Test
    public void stringValueEquality(){
	String randomstring = Integer.toString(randomgen.nextInt());
	StringValue originalString = new StringValue(randomstring);
	StringValue duplicateString = new StringValue(randomstring);
	StringValue differentString = new StringValue(randomstring + "Mutation");

	assertEquals(originalString, duplicateString);
	assertEquals(originalString.hashCode(), duplicateString.hashCode());

	assertFalse(originalString.equals(differentString));
    }
}
