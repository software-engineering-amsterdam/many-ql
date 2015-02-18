class ASTVisitor:
    def visit(self, ast):
        return self._dispatch(ast.root)

    # Dispatch works this way in Python:
    # suppose node is an instance of class Foo.
    # The method dispatched to will be _visitFoo(node).
    def _dispatch(self, node):
        method = getattr(
            self,
            '_visit' + node.__class__.__name__
        )
        if method is None:
            raise AssertionError('method %s not found' % (method))
        return method(node)
