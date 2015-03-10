package test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import test.evaluator.TestArithmetic;
import test.evaluator.TestLiteral;
import test.evaluator.TestRelational;

@RunWith(Suite.class)
@Suite.SuiteClasses({
   TestArithmetic.class,
   TestLiteral.class,
   TestRelational.class,
})
public class TestEvaluator {
}
