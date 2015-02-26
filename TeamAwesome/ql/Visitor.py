from . import Dispatch

class Visitor:
    def visit(self, subject):
        methodNameResolver = lambda className: \
            '_visit' + className[0].upper() + className[1:]

        return Dispatch.onClass(self, subject, methodNameResolver)
