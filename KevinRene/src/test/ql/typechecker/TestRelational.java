package test.ql.typechecker;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import test.ql.typechecker.relational.TestAnd;
import test.ql.typechecker.relational.TestEqual;
import test.ql.typechecker.relational.TestGreater;
import test.ql.typechecker.relational.TestGreaterOrEqual;
import test.ql.typechecker.relational.TestLower;
import test.ql.typechecker.relational.TestLowerOrEqual;
import test.ql.typechecker.relational.TestNot;
import test.ql.typechecker.relational.TestNotEqual;
import test.ql.typechecker.relational.TestOr;

@RunWith(Suite.class)
@Suite.SuiteClasses({
	TestAnd.class,
	TestEqual.class,
	TestGreaterOrEqual.class,
	TestGreater.class,
	TestLowerOrEqual.class,
	TestLower.class,
	TestNotEqual.class,
	TestNot.class,
	TestOr.class
})
public class TestRelational {}
