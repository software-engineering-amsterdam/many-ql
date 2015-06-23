package test.ql;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import test.ql.evaluator.TestArithmetic;
import test.ql.evaluator.TestLiteral;
import test.ql.evaluator.TestRelational;

@RunWith(Suite.class)
@Suite.SuiteClasses({
   TestArithmetic.class,
   TestLiteral.class,
   TestRelational.class,
})
public class TestEvaluator {
}
