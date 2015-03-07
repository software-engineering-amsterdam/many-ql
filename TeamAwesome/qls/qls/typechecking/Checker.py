from ..ast import Visitor as ASTVisitors


class StatementChecker(ASTVisitors.StatementVisitor):
    def __init__(self, qlAst, qlsAst, resultAlg):
        self._result = resultAlg.empty()
        self._qlAst = qlAst
        self._qlsAst = qlsAst

    def _visitQLS(self, node):
        super()._visitQLS(node)
        return self._result