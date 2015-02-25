from ..ast.Visitor import Visitor as ASTVisitor

class Visitor(ASTVisitor):
    def __init__(self, ast, evaluator):
        self._evaluator
        self._ast = ast

    def _visitRoot(self, node):
        super()._visitRoot(node)
        return self._evaluator
