package lang.tests;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

/**
 * Created by Nik on 10-2-15.
 */
public class TestRunner
{
    public static void main(String[] args)
    {
        Result result = JUnitCore.runClasses(LexerTest.class);
        for (Failure failure : result.getFailures())
        {
            System.out.println(failure.toString());
        }
        System.out.println("Lexer test: " + (result.wasSuccessful() ? "pass" : "FAIL"));
    }
}
