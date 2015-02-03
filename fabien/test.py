#!/usr/bin/env python

import unittest
from QL import QL
from typecheck import ParseError

class TestCases(unittest.TestCase):
    def setUp(self):
        self.app = QL()

    def testEmptyForm(self):
        parsed = self.app.parse("form taxOfficeExample {}")
        self.assertEquals(parsed.type, "form")

    def testNonClosingForm(self):
        self.assertRaises(ParseError, self.app.parse, "form taxOfficeExample {")

    def testSimpleForm(self):
        parsed = self.app.parse(
          "form taxOfficeExample { \
            \"Did you sell a house in 2010?\" \
               hasSoldHouse: boolean \
            \"Did you buy a house in 2010?\" \
               hasBoughtHouse: boolean \
            \"Did you enter a loan?\" \
               hasMaintLoan: boolean \
          }"
        )
        self.assertEquals(parsed.type, "form")


if __name__ == '__main__':
    suite = unittest.TestLoader().loadTestsFromTestCase(TestCases)
    unittest.TextTestRunner(verbosity=2).run(suite)
