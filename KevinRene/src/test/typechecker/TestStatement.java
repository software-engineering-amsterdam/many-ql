package test.typechecker;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import test.typechecker.statement.TestForm;
import test.typechecker.statement.TestIf;

@RunWith(Suite.class)
@Suite.SuiteClasses({
	TestForm.class,
	TestIf.class
})
public class TestStatement {}
