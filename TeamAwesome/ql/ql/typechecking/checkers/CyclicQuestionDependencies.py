from .AbstractBase import AbstractBase

from ...ast.Visitor import ExpressionVisitor
from ...ast.Functions import questionIdentifiedBy



class Checker(AbstractBase):
    def visitQuestionStatement(self, node):
        dependencyChains = self._questionDependencyChains([], node)
        for questionChain in dependencyChains:
            if questionChain[-1] in questionChain[:-1]:
                self._result = self._resultFactory.withError(
                    self._result,
                    self._messageFactory.questionCycle(
                        questionChain, node.expression.lineNumber
                    )
                )

    def _questionDependencyChains(self, breadcrumbs, node):
        cycleFound = node in breadcrumbs
        
        breadcrumbs.append(node)

        if node.expression is None or cycleFound:
            return [breadcrumbs]

        chains = []
        identifiers = self._extractIdentifiers(node.expression)
        
        for i in identifiers:
            question = questionIdentifiedBy(i, self._questionnaire)
            if question is not None:
                chains.extend(
                    self._questionDependencyChains(
                        breadcrumbs, question
                    )
                )

        return chains

    def _extractIdentifiers(self, expression):
        visitor = ExtractIdentifiersVisitor()
        expression.accept(visitor)
        return visitor.identifiers



class ExtractIdentifiersVisitor(ExpressionVisitor):
    def __init__(self):
        self._identifiers = []

    @property
    def identifiers(self):
        return self._identifiers

    def visitIdentifier(self, node):
        self._identifiers.append(node) 
