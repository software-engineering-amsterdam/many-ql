
import unittest

import sys,os
sys.path.insert(0, os.path.abspath(__file__ + "/../.."))

from parsingTests import TestCases as ParseTests

if __name__ == '__main__':
    suite = unittest.TestLoader().loadTestsFromTestCase(ParseTests)
    unittest.TextTestRunner(verbosity=2).run(suite)
