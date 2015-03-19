package test.ql.typechecker;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import test.ql.typechecker.statement.TestComputedQuestion;
import test.ql.typechecker.statement.TestForm;
import test.ql.typechecker.statement.TestIf;
import test.ql.typechecker.statement.TestQuestion;

@RunWith(Suite.class)
@Suite.SuiteClasses({
	TestComputedQuestion.class,
	TestForm.class,
	TestIf.class,
	TestQuestion.class
})
public class TestStatement {}
