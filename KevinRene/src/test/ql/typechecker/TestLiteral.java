package test.ql.typechecker;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import test.ql.typechecker.literal.TestBooleanLiteral;
import test.ql.typechecker.literal.TestFloatLiteral;
import test.ql.typechecker.literal.TestIntegerLiteral;
import test.ql.typechecker.literal.TestStringLiteral;

@RunWith(Suite.class)
@Suite.SuiteClasses({
   TestBooleanLiteral.class,
   TestFloatLiteral.class,
   TestIntegerLiteral.class,
   TestStringLiteral.class
})
public class TestLiteral {}
