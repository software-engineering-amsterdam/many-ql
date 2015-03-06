from typechecking import Message
from . import Checker

from ql.typechecking.Identifier import questionIdentifiedBy

class Checker(Checker.StatementChecker):
    def _visitQuestionStatement(self, node):
        qlQuestion = questionIdentifiedBy(
            node.identifier,
            self._qlAst.root
        )

        if qlQuestion is None:
            self._result = self._result.withError(Message.Error(
                "Undefined question `"+node.identifier+"`",
                node
            ))