from ..ast import Visitor as ASTVisitors


class StatementChecker(ASTVisitors.StatementVisitor):
    def __init__(self, ast, resultAlg):
        self._result = resultAlg.empty()
        self._ast = ast

    def _visitRoot(self, node):
        super()._visitRoot(node)
        return self._result


class FullChecker(ASTVisitors.FullVisitor):
    def __init__(self, ast, resultAlg):
        self._result = resultAlg.empty()
        self._ast = ast

    def _visitRoot(self, node):
        super()._visitRoot(node)
        return self._result