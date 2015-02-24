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
        className = obj.__class__.__name__
        destinationName = className[0].upper() + className[1:]
        method = getattr(
            self,
            '_visit' + destinationName
        )
        return method(obj)
