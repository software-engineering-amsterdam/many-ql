from .Visitor import Visitor
from . import Message
from .Common import questionIdentifiedBy

from ..ast import Nodes
from ..ast.Visitor import Visitor as ASTVisitor

from .. import CustomTypes

class Checker(Visitor):
    def _visitQuestionStatement(self, node):
        dependencyChains = self._questionDependencyChains([], node)
        for chain in dependencyChains:
            if chain[-1] in chain[:-1]:
                self._result = self._result.withMessage(
                    Message.Error(
                        'there is a question dependency cycle: '\
                       +' <- '.join([q.identifier for q in chain])\
                       +'. It means the calculation of the answer '\
                       +'requires its own result as input. This is '\
                       +'incalculable. Please double check the '\
                       +'definitions of the questions.',
                        node.expr
                    )
                )

    def _questionDependencyChains(self, breadcrumbs, node):
        breadcrumbs.append(node)

        cycleFound = node in breadcrumbs[:-1] 

        if node.expr is None or cycleFound:
            return [breadcrumbs]

        chains = []
        identifiers = self._extractIdentifiers(node.expr)
        
        for i in identifiers:
            question = questionIdentifiedBy(i, self._ast.root)
            if question is not None:
                chains.extend(
                    self._questionDependencyChains(
                        breadcrumbs, question
                    )
                )

        return chains

    def _extractIdentifiers(self, node):
        visitor = ExtractIdentifiersVisitor()
        visitor.visit(node)
        return visitor.identifiers


class ExtractIdentifiersVisitor(ASTVisitor):
    def __init__(self):
        self.__identifiers = []

    @property
    def identifiers(self):
        return self.__identifiers

    def _visitAtomicExpression(self, node):
        if isinstance(node.left, CustomTypes.Identifier):
            self.__identifiers.append(node.left) 
