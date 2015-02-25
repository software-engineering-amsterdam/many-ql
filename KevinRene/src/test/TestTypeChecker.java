package test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import test.typechecker.TestArithmetic;
import test.typechecker.TestCompatibility;
import test.typechecker.TestIdentifier;
import test.typechecker.TestLiteral;
import test.typechecker.TestRelational;
import test.typechecker.TestStatement;

@RunWith(Suite.class)
@Suite.SuiteClasses({
   TestArithmetic.class,
   TestLiteral.class,
   TestStatement.class,
   TestRelational.class,
   TestIdentifier.class,
   TestCompatibility.class
})
public class TestTypeChecker {
}
