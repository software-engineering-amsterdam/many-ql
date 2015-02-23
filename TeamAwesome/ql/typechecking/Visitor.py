from .Result import Result

from ..ast.Visitor import Visitor as ASTVisitor

class Visitor(ASTVisitor):
    def __init__(self, ast):
        # You can add any type check result
        # to this variable here. It is returned
        # by _visitRoot by default. 
        # To save you from typing of some 'return's
        self._result = Result()
        self._ast = ast

    def _visitRoot(self, node):
        super()._visitRoot(node)
        return self._result
