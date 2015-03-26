from typechecking import Message

from .AbstractBase import AbstractBase

from ...ast.Visitor import ExpressionVisitor
from ...ast.Functions import questionIdentifiedBy



class Checker(AbstractBase):
    def visitQuestionStatement(self, node):
        dependencyChains = self._questionDependencyChains([], node)
        for chain in dependencyChains:
            if chain[-1] in chain[:-1]:
                self._result = self._resultAlgebra.withError(
                    self._result,
                    CycleError(chain, node.expression.lineNumber)
                )

    def _questionDependencyChains(self, breadcrumbs, node):
        cycleFound = node in breadcrumbs
        
        breadcrumbs.append(node)

        if node.expression is None or cycleFound:
            return [breadcrumbs]

        chains = []
        identifiers = self._extractIdentifiers(node.expression)
        
        for i in identifiers:
            question = questionIdentifiedBy(i, self._parser.questionnaire)
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



class CycleError(Message.Message):
    def __init__(self, cycle, lineNumber):
        text = 'there is a question dependency cycle: '\
           +' <- '.join([str(q.identifier) for q in cycle])\
           +'. It means the calculation of the answer '\
           +'requires its own result as input. This is '\
           +'incalculable. Please double check the '\
           +'definitions of the questions.'

        super().__init__(
            Message.Local(lineNumber),
            Message.Error(),
            text
        )



class ExtractIdentifiersVisitor(ExpressionVisitor):
    def __init__(self):
        self._identifiers = []

    @property
    def identifiers(self):
        return self._identifiers

    def visitIdentifier(self, node):
        self._identifiers.append(node) 
