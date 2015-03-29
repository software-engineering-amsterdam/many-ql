package uva.ql.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ TestAST.class, TestExpression.class,
		TestExpressionEvaluator.class, TestTypeChecker.class })
	
	public class TestSuite {
		
	}	
