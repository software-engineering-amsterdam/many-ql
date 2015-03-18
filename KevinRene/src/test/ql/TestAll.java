package test.ql;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
	TestEvaluator.class,
	TestParser.class,
	TestTypeChecker.class,
	TestTypeRegister.class
})
public class TestAll {
}
