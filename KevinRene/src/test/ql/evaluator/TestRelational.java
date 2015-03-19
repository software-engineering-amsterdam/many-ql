package test.ql.evaluator;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import test.ql.evaluator.relational.TestAnd;
import test.ql.evaluator.relational.TestEqual;
import test.ql.evaluator.relational.TestGreater;
import test.ql.evaluator.relational.TestGreaterOrEqual;
import test.ql.evaluator.relational.TestLower;
import test.ql.evaluator.relational.TestLowerOrEqual;
import test.ql.evaluator.relational.TestNot;
import test.ql.evaluator.relational.TestNotEqual;
import test.ql.evaluator.relational.TestOr;

@RunWith(Suite.class)
@Suite.SuiteClasses({
	TestAnd.class,
	TestEqual.class,
	TestGreater.class,
	TestGreaterOrEqual.class,
	TestLower.class,
	TestLowerOrEqual.class,
	TestNot.class,
	TestNotEqual.class,
	TestOr.class,
})
public class TestRelational {}
