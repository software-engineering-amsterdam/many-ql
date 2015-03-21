import unittest
import QL.Tests.grammar as grammar
import QL.Tests.ast as ast
import QL.Tests.type_checker as type_checker
# from QL.Tests.evaluator import *

# Execute tests

suite = unittest.TestLoader().loadTestsFromTestCase(grammar.Tests)
suite.addTests(unittest.TestLoader().loadTestsFromTestCase(ast.Tests))
suite.addTests(unittest.TestLoader().loadTestsFromTestCase(type_checker.Tests))
# suite.addTests(unittest.TestLoader().loadTestsFromTestCase(TestExpressionGrammar))
# suite.addTests(unittest.TestLoader().loadTestsFromTestCase(TestTypeChecker))
# suite.addTests(unittest.TestLoader().loadTestsFromTestCase(TestProcessor))


unittest.TextTestRunner(verbosity=2).run(suite)