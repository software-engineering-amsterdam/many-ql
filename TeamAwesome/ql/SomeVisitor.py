class SomeVisitor:
    def visit(self, obj):
        return self._dispatch(obj)

    # Dispatch works this way in Python:
    # suppose obj is an instance of class Foo.
    # The method dispatched to will be _visitFoo(obj).
    def _dispatch(self, obj):
        method = getattr(
            self,
            '_visit' + obj.__class__.__name__
        )
        if method is None:
            raise AssertionError('method %s not found' % (method))
        return method(obj)
