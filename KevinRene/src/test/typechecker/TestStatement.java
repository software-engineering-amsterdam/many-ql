package test.typechecker;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import test.typechecker.statement.TestComputedQuestion;
import test.typechecker.statement.TestForm;
import test.typechecker.statement.TestIf;
import test.typechecker.statement.TestQuestion;

@RunWith(Suite.class)
@Suite.SuiteClasses({
	TestComputedQuestion.class,
	TestForm.class,
	TestIf.class,
	TestQuestion.class
})
public class TestStatement {}
