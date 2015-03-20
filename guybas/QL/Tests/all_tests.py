import unittest
from QL.Tests.grammar import *
from QL.Tests.ast import *
# from QL.Tests.type_checker import *
# from QL.Tests.evaluator import *

# Execute tests

suite = unittest.TestLoader().loadTestsFromTestCase(TestBasicGrammar)
suite.addTests(unittest.TestLoader().loadTestsFromTestCase(TestFactories))
# suite.addTests(unittest.TestLoader().loadTestsFromTestCase(TestAST))
# suite.addTests(unittest.TestLoader().loadTestsFromTestCase(TestExpressionGrammar))
# suite.addTests(unittest.TestLoader().loadTestsFromTestCase(TestTypeChecker))
# suite.addTests(unittest.TestLoader().loadTestsFromTestCase(TestProcessor))


unittest.TextTestRunner(verbosity=2).run(suite)