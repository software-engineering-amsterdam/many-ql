package com.form.language.test;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
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
	BoolType booltype2 = new BoolType();
	assertEquals(booltype, booltype2);

	IntType inttype = new IntType();
	IntType inttype2 = new IntType();
	assertEquals(inttype, inttype2);

	StringType stringtype = new StringType();
	StringType stringtype2 = new StringType();
	assertEquals(stringtype, stringtype2);

	ErrorType errortype = new ErrorType();
	ErrorType errortype2 = new ErrorType();
	assertEquals(errortype, errortype2);
    }
    
    @Test
    public void intValueEquality(){
	int randomnumber = randomgen.nextInt();
	IntValue intvalue = new IntValue(randomnumber);
	IntValue intvalue2 = new IntValue(randomnumber);
	assertEquals(intvalue, intvalue2);
    }

    @Test
    public void boolValueEquality(){
	boolean randombool = randomgen.nextBoolean();
	BoolValue boolvalue = new BoolValue(randombool);
	BoolValue boolvalue2 = new BoolValue(randombool);
	assertEquals(boolvalue, boolvalue2);
    }
    
    @Test
    public void stringValueEquality(){
	String randomstring = Integer.toString(randomgen.nextInt());
	StringValue stringvalue = new StringValue(randomstring);
	StringValue stringvalue2 = new StringValue(randomstring);
	assertEquals(stringvalue, stringvalue2);
    }
}
