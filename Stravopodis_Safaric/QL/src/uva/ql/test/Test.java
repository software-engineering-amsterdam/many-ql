package uva.ql.test;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class Test {
	
	public void runTestSuite(){
		Result result = JUnitCore.runClasses(TestSuite.class);
		
		for (Failure failure : result.getFailures()){
			System.out.println("Failure: " + failure);
		}
		
		System.out.println("Test is successful: " + result.wasSuccessful());
	}
}
