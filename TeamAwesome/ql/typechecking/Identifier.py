from ..ast import Nodes
from ..ast.Visitor import Visitor as ASTVisitor
from ..TypeRules import nativeQuestionType


def questionIdentifiedBy(identifier, node):
    visitor = QuestionIdentifiedByVisitor(identifier)
    visitor.visit(node)
    return visitor.question


def typeOfIdentifier(identifier, node):
    question = questionIdentifiedBy(identifier, node)
    if question is None:
        return None
    return nativeQuestionType(question.type)


class QuestionIdentifiedByVisitor(ASTVisitor):
    def __init__(self, identifier):
        self._identifier = identifier
        self._question = None

    @property
    def question(self):
        return self._question
        
    def _visitQuestionStatement(self, node):
        if self.question is None and \
            node.identifier == self._identifier:
            self._question = node