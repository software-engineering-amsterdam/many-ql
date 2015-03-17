from ..ast import Nodes, Visitor as ASTVisitors
from ..TypeRules import nativeQuestionType


def questionIdentifiedBy(identifier, node):
    visitor = QuestionIdentifiedByVisitor(identifier)
    node.accept(visitor)
    return visitor.question


def typeOfIdentifier(identifier, node):
    nnType = nonNativeTypeOfIdentifier(identifier, node)
    if nnType is None:
        return None
    return nativeQuestionType(nnType)


def nonNativeTypeOfIdentifier(identifier, node):
    question = questionIdentifiedBy(identifier, node)
    if question is None:
        return None
    return question.type


class QuestionIdentifiedByVisitor(ASTVisitors.StatementVisitor):
    def __init__(self, identifier):
        super().__init__()
        self._identifier = identifier
        self._question = None

    @property
    def question(self):
        return self._question
        
    def visitQuestionStatement(self, node):
        if self.question is None and \
            node.identifier.value == self._identifier.value:
            self._question = node