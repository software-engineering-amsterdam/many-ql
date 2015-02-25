from ..ast.Visitor import Visitor as ASTVisitor

class Evaluator(object):
	pass

class Checker(ASTVisitor):
    def __init__(self, ast):
        self._evaluator = Evaluator()
        self._ast = ast

    def _visitRoot(self, node):
        super()._visitRoot(node)
        return self._evaluator

    def _visitFormStatement(self, node):
        for n in node.getChildren():
            self.visit(n)

    def _visitQuestionStatement(self, node):
        if node.expr is not None:
            self.visit(node.expr)

    def _visitIfStatement(self, node):
        self.visit(node.expr)
        for n in node.getChildren():
            self.visit(n)

    def _visitAtomicExpression(self, node):
        pass

    def _visitUnaryExpression(self, node):
        self.visit(node.right)

    def _visitBinaryExpression(self, node):
        self.visit(node.left)
        self.visit(node.right)
