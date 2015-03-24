import QL.AST.Expressions.Operations.binary_expression as b
import QL.Grammar.constants as constants


class Or(b.BinaryExpression):

    def set_string_operator(self):
        return "or"

    def return_type_string(self, type_map):
        return int

    def eval(self, x, y):
        return x or y