import QL.AST.Expressions.Primitives.primitive as p
import QL.Grammar.constants as constants


class Bool(p.Primitive):

    def __init__(self, pbool):
        self.__bool = pbool

    def string_presentation(self):
        return str(self.__bool)  # since the actual type is a real bool

    def return_type_string(self, type_dict):
        return constants.BOOL

    # just the value of the bool itself
    def eval_expression(self, type_map):
        return self.__bool
