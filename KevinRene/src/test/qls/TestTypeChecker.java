package test.qls;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import test.qls.typechecker.TestStatement;

@RunWith(Suite.class)
@Suite.SuiteClasses({
	TestStatement.class
})
public class TestTypeChecker {
}
