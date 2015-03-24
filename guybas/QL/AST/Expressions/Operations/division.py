import QL.AST.Expressions.Operations.binary_expression as b
import QL.Grammar.constants as constants


class Division(b.BinaryExpression):

    def set_string_operator(self):
        return "/"

    def return_type_string(self, type_map):
        return int

    def eval(self, x, y):
        return x / y
