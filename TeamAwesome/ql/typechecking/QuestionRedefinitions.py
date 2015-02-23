from .Visitor import Visitor
from .Common import typeOfIdentifier, nativeQuestionType
from . import Message

class Checker(Visitor):
    def _visitQuestionStatement(self, node):
        myType = nativeQuestionType(node.type)
        expectedType = typeOfIdentifier(
            node.identifier, self._ast.root
        )

        if myType != expectedType:
            self._result = self._result.withMessage(
                Message.Error(
                    'Duplicate definition of question `'\
                   +node.identifier+'` with different type `'\
                   +str(myType)+'` (expected type `'\
                   +str(expectedType)+'`)',
                    node
                )
            )