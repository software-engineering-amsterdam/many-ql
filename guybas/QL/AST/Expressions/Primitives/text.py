import QL.AST.Expressions.Primitives.primitive as p
import QL.Grammar.constants as constants


class Text(p.Primitive):
    def __init__(self, text):
        self.__text = "\"" + text + "\""

    def pretty_print(self):
        return self.__text

    def return_type_string(self, type_dict):
        return constants.TEXT

    # texts are not dependencies
    def get_dependency_collection(self):
        return []

    def eval_expression(self, type_map):
        return self.__text