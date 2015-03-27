package com.form.language.test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Test;

import java.util.Random;

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

	IntType inttype = new IntType();
	IntType duplicateInt = new IntType();
	assertEquals(inttype, duplicateInt);

	StringType stringtype = new StringType();
	StringType duplicateString = new StringType();
	assertEquals(stringtype, duplicateString);

	ErrorType errortype = new ErrorType();
	ErrorType duplicateError = new ErrorType();
	assertEquals(errortype, duplicateError);
    }
    
    @Test
    public void intValueEquality(){
	int randomnumber = randomgen.nextInt();
	IntValue intvalue = new IntValue(randomnumber);
	IntValue duplicate = new IntValue(randomnumber);

	assertEquals(intvalue, duplicate);
    }

    @Test
    public void boolValueEquality(){
	boolean randombool = randomgen.nextBoolean();
	BoolValue originalBool = new BoolValue(randombool);
	BoolValue duplicateBool = new BoolValue(randombool);
	BoolValue differentBool = new BoolValue(!randombool);

	assertEquals(originalBool, duplicateBool);
	assertFalse(originalBool.equals(differentBool));
    }
    
    @Test
    public void stringValueEquality(){
	String randomstring = Integer.toString(randomgen.nextInt());
	StringValue originalString = new StringValue(randomstring);
	StringValue duplicateString = new StringValue(randomstring);
	StringValue differentString = new StringValue(randomstring + "Mutation");

	assertEquals(originalString, duplicateString);
	assertFalse(originalString.equals(differentString));
    }
}
