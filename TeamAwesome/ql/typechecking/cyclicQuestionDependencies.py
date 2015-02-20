from .Visitor import Visitor
from . import Message

import ASTNodes
import CustomTypes
from ASTVisitor import ASTVisitor


class Checker(Visitor):
    def _visitQuestionStatement(self, node):
        paths = self._dependencyPaths([], node)
        for p in paths:
            if p[-1] in p[:-1]:
                self._result = self._result.withMessage(
                    Message.Error(
                        'there is a question dependency cycle: '\
                       +' <- '.join([q.identifier for q in p])\
                       +'. It means the calculation of the answer '\
                       +'requires its own result as input. This is '\
                       +'incalculable. Please double check the '\
                       +'definitions of the questions.',
                        node.expr
                    )
                )

    def _dependencyPaths(self, path, node):
        path.append(node)

        if node.expr is None or node in path[:-1]:
            return [path]

        paths = []

        identifiers = self._extractIdentifiers(node.expr)
        for i in identifiers:
            question = self._questionIdentifiedBy(i, self._ast.root)
            if question is not None:
                paths.extend(self._dependencyPaths(path, question))

        return paths

    def _extractIdentifiers(self, node):
        visitor = ExtractIdentifiersVisitor()
        visitor.visit(node)
        return visitor.identifiers

    def _questionIdentifiedBy(self, identifier, node):
        if isinstance(node, ASTNodes.QuestionStatement) and \
            node.identifier == identifier:
            return node

        for n in node.getChildren():
            question = self._questionIdentifiedBy(identifier, n)
            if question is not None:
                return question

        return None

class ExtractIdentifiersVisitor(ASTVisitor):
    def __init__(self):
        self.__identifiers = []

    @property
    def identifiers(self):
        return self.__identifiers

    def _visitAtomicExpression(self, node):
        if isinstance(node.left, CustomTypes.Identifier):
            self.__identifiers.append(node.left) 
