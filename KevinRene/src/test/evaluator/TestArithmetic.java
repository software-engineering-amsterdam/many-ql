package test.evaluator;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import test.typechecker.arithmetic.TestAddition;
import test.typechecker.arithmetic.TestDivision;
import test.typechecker.arithmetic.TestMultiplication;
import test.typechecker.arithmetic.TestNegation;
import test.typechecker.arithmetic.TestPositive;
import test.typechecker.arithmetic.TestSubtraction;

@RunWith(Suite.class)
@Suite.SuiteClasses({
   TestAddition.class,
   TestDivision.class,
   TestMultiplication.class,
   TestNegation.class,
   TestPositive.class,
   TestSubtraction.class
})
public class TestArithmetic {}
