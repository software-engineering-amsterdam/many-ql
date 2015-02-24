from . import Dispatch

class Visitor:
    def visit(self, obj):
        return Dispatch.onClass(
            self,
            obj,
            lambda className:
                '_visit' + className[0].upper() + className[1:]
        )
