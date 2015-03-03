package test.evaluator;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import test.typechecker.literal.TestBooleanLiteral;
import test.typechecker.literal.TestFloatLiteral;
import test.typechecker.literal.TestIntegerLiteral;
import test.typechecker.literal.TestStringLiteral;

@RunWith(Suite.class)
@Suite.SuiteClasses({
   TestBooleanLiteral.class,
   TestFloatLiteral.class,
   TestIntegerLiteral.class,
   TestStringLiteral.class
})
public class TestLiteral {}
