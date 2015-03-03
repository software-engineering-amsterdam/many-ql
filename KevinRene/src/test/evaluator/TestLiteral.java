package test.evaluator;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import test.evaluator.literal.TestBooleanLiteral;

@RunWith(Suite.class)
@Suite.SuiteClasses({
   TestBooleanLiteral.class
})
public class TestLiteral {}
