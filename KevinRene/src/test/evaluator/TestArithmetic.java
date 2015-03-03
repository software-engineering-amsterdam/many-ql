package test.evaluator;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import test.evaluator.arithmetic.TestAddition;
import test.evaluator.arithmetic.TestSubtraction;

@RunWith(Suite.class)
@Suite.SuiteClasses({
   TestAddition.class,
   TestSubtraction.class
})
public class TestArithmetic {}
