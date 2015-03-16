from typechecking import Message

from .Identifier import typeOfIdentifier
from ..TypeRules import nativeQuestionType
from . import Checker

class Checker(Checker.StatementChecker):
    def _visitQuestionStatement(self, node):
        myType = nativeQuestionType(node.type)
        expectedType = typeOfIdentifier(
            node.identifier, self._ast.root
        )

        if myType != expectedType:
            self._result = self._resultAlg.withError(
                self._result,
                Message.Error(
                    'Duplicate definition of question `'\
                   +node.identifier+'` with different type `'\
                   +str(myType)+'` (expected type `'\
                   +str(expectedType)+'`)',
                    node
                )
            )