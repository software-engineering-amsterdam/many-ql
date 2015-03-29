import sys
sys.path.append('..')

import unittest
import TestMessage

from ql.core import QLOperators

from ql.ast.Nodes import *
from ql.evaluator.evaluator import createEvaluator

class NoQuestions(unittest.TestCase):
    def test(self):
        evaluator = createEvaluator(self.questionnaire)
        self.assertEqual(0, len(evaluator.questions()))

    @property
    def questionnaire(self):
        return Questionnaire(
            [FormStatement(
                Identifier('form',0),
                [IfStatement(
                    Boolean(False, 0),
                    [QuestionStatement(
                        Identifier('foo', 0),
                        'Foo',
                        QLBoolean,
                        1
                    )],
                    1
                )],
                0
            )]
        )
   

class DuplicateIdentifiers(unittest.TestCase):
    def test(self):
        evaluator = createEvaluator(self.questionnaire)
        questions = evaluator.questions()
        self.assertEqual(1, len(questions))
        self.assertEqual('Foo1', questions[0].text)

    @property
    def questionnaire(self):
        return Questionnaire(
            [FormStatement(
                Identifier('form', 0),
                [QuestionStatement(
                    Identifier('foo', 1),
                    'Foo1',
                    QLBoolean,
                    1
                ),
                QuestionStatement(
                    Identifier('foo', 2),
                    'Foo2',
                    QLBoolean,
                    2
                )],
                0
            )]
        )


class ConditionalQuestion(unittest.TestCase):
    def test(self):
        evaluator = createEvaluator(self.questionnaire)
        self.assertEqual(1, len(evaluator.questions()))

    @property
    def questionnaire(self):
        return Questionnaire(
            [FormStatement(
                Identifier('form', 0),
                [IfStatement(
                    BinaryExpression(
                        Integer(5, 1),
                        QLOperators.QLGreater,
                        Integer(3, 1),
                        1
                    ),
                    [QuestionStatement(
                        Identifier('foo', 2),
                        'Foo',
                        QLBoolean,
                        2
                    )],
                    1
                )],
                0
            )]
        )
    

class ValueDependentQuestion(unittest.TestCase):
    def test(self):
        evaluator = createEvaluator(self.questionnaire)
        questions = evaluator.questions()
        self.assertEqual(2, len(questions))
        self.assertEqual(QLInteger(3), evaluator.getValue(questions[1].identifier))

    @property
    def questionnaire(self):
        return Questionnaire(
            [FormStatement(
                Identifier('form', 0),
                [QuestionStatement(
                    Identifier('foo', 1),
                    'Foo',
                    QLInteger,
                    1,
                    expression = Integer(3, 1)
                ),
                QuestionStatement(
                    Identifier('bar', 2),
                    'Bar',
                    QLBoolean,
                    2,
                    expression = Identifier('foo', 2)
                )],
                0
            )]
        )
    

class VisibilityDependentQuestion(unittest.TestCase):
    def test(self):
        evaluator = createEvaluator(self.questionnaire)
        self.assertEqual(2, len(evaluator.questions()))
        
    @property
    def questionnaire(self):
        return Questionnaire(
            [FormStatement(
                Identifier('form', 0),
                [QuestionStatement(
                    Identifier('foo', 1),
                    'Foo',
                    QLInteger,
                    1,
                    expression = Integer(3, 1)
                ),
                IfStatement(
                    BinaryExpression(
                        Integer(5, 2),
                        QLOperators.QLGreater,
                        Identifier('foo', 2),
                        2
                    ),
                    [QuestionStatement(
                        Identifier('bar', 3),
                        'Bar',
                        QLBoolean,
                        3
                    )],
                    2
                )],
                0
            )]
        )
    

class UnansweredDependentQuestion(unittest.TestCase):
    def test(self):
        evaluator = createEvaluator(self.questionnaire)
        self.assertEqual(1, len(evaluator.questions()))
        
    @property
    def questionnaire(self):
        return Questionnaire(
            [FormStatement(
                Identifier('form', 0),
                [QuestionStatement(
                    Identifier('foo', 1),
                    'Foo',
                    QLInteger,
                    1
                ),
                IfStatement(
                    BinaryExpression(
                        Integer(5, 2),
                        QLOperators.QLGreater,
                        Identifier('foo', 2),
                        2
                    ),
                    [QuestionStatement(
                        Identifier('bar', 3),
                        'Bar',
                        QLBoolean,
                        3
                    )],
                    2
                )],
                0
            )]
        )
    
