import QL.AST.Expressions.Primitives.primitive as p
import QL.Grammar.constants as constants


class Bool(p.Primitive):
    def __init__(self, pbool):
        self.__bool = pbool

    def return_type_string(self, type_dict):
        return constants.BOOL

    def pretty_print(self):
        return str(self.__bool)  # since the actual type is a real bool

    # booleans are not dependencies
    def get_dependency_collection(self):
        return []

    def eval_expression(self, type_map):
        return self.__bool