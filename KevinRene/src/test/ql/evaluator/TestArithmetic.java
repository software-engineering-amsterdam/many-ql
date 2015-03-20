package test.ql.evaluator;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import test.ql.evaluator.arithmetic.TestAddition;
import test.ql.evaluator.arithmetic.TestDivision;
import test.ql.evaluator.arithmetic.TestMultiplication;
import test.ql.evaluator.arithmetic.TestNegation;
import test.ql.evaluator.arithmetic.TestPositive;
import test.ql.evaluator.arithmetic.TestSubtraction;

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
