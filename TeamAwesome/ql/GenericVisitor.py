class GenericVisitor:
    def visit(self, obj):
        return self._dispatch(obj)

    # Dispatch works this way in Python:
    # suppose obj is an instance of class Foo.
    # The method dispatched to will be _visitFoo(obj).
    #
    # Python will raise an AttributeError if getattr() fails to find
    # the method.
    def _dispatch(self, obj):
        method = getattr(
            self,
            '_visit' + obj.__class__.__name__
        )
        return method(obj)
