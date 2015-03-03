package test.evaluator;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import test.evaluator.relational.TestAnd;
import test.evaluator.relational.TestEqual;
import test.evaluator.relational.TestGreater;
import test.evaluator.relational.TestGreaterOrEqual;
import test.evaluator.relational.TestLower;
import test.evaluator.relational.TestLowerOrEqual;
import test.evaluator.relational.TestNot;
import test.evaluator.relational.TestNotEqual;
import test.evaluator.relational.TestOr;

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
