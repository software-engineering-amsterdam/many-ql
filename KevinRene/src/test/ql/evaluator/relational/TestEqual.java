package test.ql.evaluator.relational;

import java.util.Arrays;
import java.util.Collection;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import ql.Value;
import ql.value.BooleanValue;
import ql.value.UndefinedValue;
import test.ql.evaluator.BaseTest;

@RunWith(value = Parameterized.class)
public class TestEqual extends BaseTest {
	@Parameters
    public static Collection<Object[]> data() {
   	 return Arrays.asList(new Object[][] {
   			{ "true == false", new BooleanValue(false) },
   			{ "false == true", new BooleanValue(false) },
   			{ "false == false", new BooleanValue(true) },
   			{ "true == true", new BooleanValue(true) },
   			{ "booleanQuestion == false", new BooleanValue(false) },
   			{ "false == booleanQuestion", new BooleanValue(false) },
   			{ "true == booleanQuestion", new BooleanValue(true) },
   			
   			{ "5 == 5", new BooleanValue(true) },
   			{ "5 == 7", new BooleanValue(false) },
   			{ "integerQuestion == 10", new BooleanValue(true) },
   			{ "integerQuestion == 5", new BooleanValue(false) },
   			{ "10 == integerQuestion", new BooleanValue(true) },
   			{ "5 == integerQuestion", new BooleanValue(false) },
   			
   			{ "5.0 == 5.0", new BooleanValue(true) },
   			{ "5.0 == 7.0", new BooleanValue(false) },
   			{ "floatQuestion == 10.5", new BooleanValue(true) },   			
   			{ "floatQuestion == 5.5", new BooleanValue(false) },
   			{ "10.5 == floatQuestion", new BooleanValue(true) },
   			{ "5.5 == floatQuestion", new BooleanValue(false) },
   			   			
   			{ "5 == 5.0", new BooleanValue(true) },
   			{ "5 == 7.0", new BooleanValue(false) },
   			{ "integerQuestion == 10.0", new BooleanValue(true) },
   			{ "integerQuestion == 5.0", new BooleanValue(false) },
   			{ "10.0 == integerQuestion", new BooleanValue(true) },
   			{ "5.0 == integerQuestion", new BooleanValue(false) },
   			
   			{ "5.0 == 5", new BooleanValue(true) },
   			{ "5.0 == 7", new BooleanValue(false) },
   			{ "floatQuestion == 10", new BooleanValue(false) },
   			{ "10 == floatQuestion", new BooleanValue(false) },
   			
   			{ "\"Bob\" == \"Bob\"", new BooleanValue(true) },
   			{ "\"Bob\" == \"Fred\"", new BooleanValue(false) },
   			{ "stringQuestion == \"A string\"", new BooleanValue(true) },
   			{ "\"A string\" == stringQuestion", new BooleanValue(true) },
   			
   			{ "undefinedQuestion == 10.5", new UndefinedValue() },
   			{ "10.5 == undefinedQuestion", new UndefinedValue() },
   			
   			{ "undefinedQuestion == 10", new UndefinedValue() },
   			{ "10 == undefinedQuestion", new UndefinedValue() },
   			
   			{ "undefinedQuestion == \"A string\"", new UndefinedValue() },
   			{ "\"A string\" == undefinedQuestion", new UndefinedValue() },
   	 });
    }

    public TestEqual(String input, Value expected) {
   	 super(input, expected);
    }
}
