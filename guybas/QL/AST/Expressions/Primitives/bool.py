import QL.AST.Expressions.Primitives.primitive as e
import QL.Grammar.constants as constants


class Bool(e.Primitive):
    def __init__(self, pbool):
        self.bool = pbool

    def return_type_string(self, type_dict):
        return constants.BOOL

    def pretty_print(self):
        return str(self.bool)  # since the actual type is a real bool

    # booleans are not dependencies
    def get_dependency_collection(self):
        return []