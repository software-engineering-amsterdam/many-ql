
import unittest

import sys,os
sys.path.insert(0, os.path.abspath(__file__ + "/../.."))

from ParseTests import ParseTests
from TypecheckingTests import TypecheckingTests
from EvaluationTests import EvaluationTests

if __name__ == '__main__':
    suite = unittest.TestLoader().loadTestsFromTestCase(ParseTests)
    unittest.TextTestRunner(verbosity=2).run(suite)

    suite = unittest.TestLoader().loadTestsFromTestCase(TypecheckingTests)
    unittest.TextTestRunner(verbosity=2).run(suite)

    suite = unittest.TestLoader().loadTestsFromTestCase(EvaluationTests)
    unittest.TextTestRunner(verbosity=2).run(suite)
