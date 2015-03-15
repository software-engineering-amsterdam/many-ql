import QL.AST.Expressions.Elements.element as e
import QL.Grammar.constants as constants


class Text(e.Element):
    def __init__(self, text):
        self.text = "\"" + text + "\""

    def pretty_print(self):
        return str(self.text)

    def return_type_string(self, type_dict):
        return constants.GrammarConstants.TEXT

    def get_dependencies(self):
        return []

    def as_list(self):
        return [self.text]