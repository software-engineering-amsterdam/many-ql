from . import Checker, Message
from .Identifier import questionIdentifiedBy

from ..ast import Nodes, Visitor as ASTVisitors

from .. import CustomTypes

class Checker(Checker.StatementChecker):
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


class ExtractIdentifiersVisitor(ASTVisitors.ExpressionVisitor):
    def __init__(self):
        self._identifiers = []

    @property
    def identifiers(self):
        return self._identifiers

    def _visitIdentifier(self, node):
        self._identifiers.append(node) 
