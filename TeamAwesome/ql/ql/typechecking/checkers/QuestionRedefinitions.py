from .AbstractBase import AbstractBase

from ...ast.Functions import typeOfIdentifier



class Checker(AbstractBase):
    def visitQuestionStatement(self, node):
        expectedType = typeOfIdentifier(
            node.identifier, self._questionnaire
        )
        myType = node.type

        if myType != expectedType:
            self._result = self._resultFactory.withError(
                self._result,
                self._messageFactory.questionRedefinition(
                    node,
                    myType,
                    expectedType,
                    node.lineNumber
                )
            )
