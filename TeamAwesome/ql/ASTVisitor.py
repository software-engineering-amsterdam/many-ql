from GenericVisitor import GenericVisitor

class ASTVisitor(GenericVisitor):
    # Below are default methods.
    # They do nothing except visit the tree.
    def _visitRoot(self, node):
        for n in node.getChildren():
            self.visit(n) 

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
