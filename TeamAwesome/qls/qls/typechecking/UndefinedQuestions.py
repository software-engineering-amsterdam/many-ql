from typechecking import Message
from . import Checker

from ql.ast.Visitor import StatementVisitor as QlStatementVisitor
from ..ast.Visitor import StatementVisitor as StatementVisitor



class Checker(Checker.StatementChecker):
    def __init__(self, qlAst, qlsAst, resultAlg):
        super().__init__(qlAst, qlsAst, resultAlg)

        self._questionIdentifiers = []

        self._qlQuestionIdentifiers = \
            _collectQlQuestionIdentifiers(qlAst)
        

    def _visitQuestionStatement(self, node):
        self._questionIdentifiers.append(node.identifier)


    def _visitQLS(self, node):
        super()._visitQLS(node)

        for identifier in self._qlQuestionIdentifiers:
            if identifier not in self._questionIdentifiers:
                self._result = self._result.withError(Message.Error(
                    "question `"+identifier+"` not placed by stylesheet"
                ))

        return self._result



def _collectQlQuestionIdentifiers(qlAst):
    visitor = CollectQlQuestionIdentifiersVisitor()
    visitor.visit(qlAst.root)
    return visitor.questionIdentifiers



class CollectQlQuestionIdentifiersVisitor(QlStatementVisitor):
    def __init__(self):
        self._questionIdentifiers = []

    @property
    def questionIdentifiers(self):
        return self._questionIdentifiers

    def _visitQuestionStatement(self, node):
        self._questionIdentifiers.append(node.identifier)