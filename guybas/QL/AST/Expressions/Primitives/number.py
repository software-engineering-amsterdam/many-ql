import QL.AST.Expressions.Primitives.primitive as e
import QL.Grammar.constants as constants


class Number(e.Primitive):
    def __init__(self, number):
        self.number = number

    def return_type_string(self, type_dict):
        return constants.NUMBER

    def pretty_print(self):
        return str(self.number)  # since it is a real integer

    # numbers are not dependencies
    def get_dependency_collection(self):
        return []