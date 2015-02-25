package test.typechecker;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import test.typechecker.relational.TestAnd;
import test.typechecker.relational.TestEqual;
import test.typechecker.relational.TestGreater;
import test.typechecker.relational.TestGreaterOrEqual;
import test.typechecker.relational.TestLower;
import test.typechecker.relational.TestLowerOrEqual;
import test.typechecker.relational.TestNot;
import test.typechecker.relational.TestNotEqual;
import test.typechecker.relational.TestOr;

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
