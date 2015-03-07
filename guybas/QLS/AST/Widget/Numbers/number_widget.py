import QLS.AST.Widget.widget as w
import QL.Grammar.constants as constants


# AST for the number_widget interface
class NumberWidget(w.Widget):
    def __init__(self):
        raise NotImplementedError("Not implemented by sub class")

    def pretty_print(self, level=0):
        raise NotImplementedError("Not implemented by sub class")

    def get_compatible(self):
        raise NotImplementedError("Not implemented by sub class")

    def get_range(self):
        raise NotImplementedError("Not implemented by sub class")
