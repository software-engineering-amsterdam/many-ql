package test.evaluator;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import test.evaluator.arithmetic.TestAddition;
import test.evaluator.arithmetic.TestDivision;
import test.evaluator.arithmetic.TestMultiplication;
import test.evaluator.arithmetic.TestNegation;
import test.evaluator.arithmetic.TestPositive;
import test.evaluator.arithmetic.TestSubtraction;

@RunWith(Suite.class)
@Suite.SuiteClasses({
   TestAddition.class,   
   TestDivision.class,
   TestMultiplication.class,
   TestNegation.class,
   TestPositive.class,
   TestSubtraction.class,
})
public class TestArithmetic {}
