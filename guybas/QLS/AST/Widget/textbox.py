import QLS.AST.Widget.widget as w
import QL.Grammar.constants as constants


class Textbox(w.Widget):
    def __init__(self):
        pass

    def pretty_print(self, level=0):
        return "    " * level + "Textbox \n"

    def get_compatible(self):
        return [constants.GrammarConstants.TEXT]

    def get_settings(self):
        raise NotImplementedError("Not implemented by sub class")

    def set_settings(self):
        raise NotImplementedError("Not implemented by sub class")