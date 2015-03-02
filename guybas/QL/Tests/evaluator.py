import unittest
from QL.Main.processor import *


class TestProcessor(unittest.TestCase):
    def test_processor(self):
        m = Mapper()

        e1 = "(1 + 3 - 2 / 1) == 2"
        self.assertEqual(Processor.eval_expression(e1, m), True)

        e2 = "(1 + 3 - 2 / 1) == 3"
        self.assertEqual(Processor.eval_expression(e2, m), False)

        q1 = Question("id", "number", "Just something.")
        m.update(q1, 4)
        e3 = "(1 + id ) == 5"
        self.assertEqual(Processor.eval_expression(e3, m), True)

        # Types are not valid, the eval function just evaluates to false
        e4 = "id == True"
        self.assertEqual(Processor.eval_expression(e4, m), False)

        # This id doesn't exist or is not initialized yet, evaluate to false
        e5 = "hummus == True"
        self.assertEqual(Processor.eval_expression(e5, m), False)

        q2 = Question("hummus", "bool", "Question.")
        q3 = Question("grade", "number", "Number?")
        m.update(q2, True)
        m.update(q3, 6)

        e6 = "hummus == True and grade > 5"
        self.assertEqual(Processor.eval_expression(e6, m), True)

        # The id is updated and exists now
        e7 = "hummus == True"
        self.assertEqual(Processor.eval_expression(e7, m), True)

        e8 = "hummus"
        self.assertEqual(Processor.eval_expression(e8, m), True)

        m.update(q2, False)
        e9 = "(((1 + 2)) * 3 == 8) or  (not hummus)"
        self.assertEqual(Processor.eval_expression(e9, m), True)