from . import Dispatch

class Visitor:
    def visit(self, subject):
        return Dispatch.onClass(
            self,
            subject,
            lambda className:
                '_visit' + className[0].upper() + className[1:]
        )
