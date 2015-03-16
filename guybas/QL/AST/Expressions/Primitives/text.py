import QL.AST.Expressions.Primitives.primitive as e
import QL.Grammar.constants as constants


class Text(e.Primitive):
    def __init__(self, text):
        self.text = "\"" + text + "\""

    def pretty_print(self):
        return self.text

    def return_type_string(self, type_dict):
        return constants.TEXT

    # texts are not dependencies
    def get_dependency_collection(self):
        return []
