package test.ql.typechecker;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import test.ql.typechecker.arithmetic.TestAddition;
import test.ql.typechecker.arithmetic.TestDivision;
import test.ql.typechecker.arithmetic.TestMultiplication;
import test.ql.typechecker.arithmetic.TestNegation;
import test.ql.typechecker.arithmetic.TestPositive;
import test.ql.typechecker.arithmetic.TestSubtraction;

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
