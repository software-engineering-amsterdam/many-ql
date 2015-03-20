import QL.AST.Expressions.Operations.binary_expression as b
import QL.Grammar.constants as constants


class Multiplication(b.BinaryExpression):

    def set_operator(self):
        return "*"

    def return_type_string(self, type_map):
        return constants.NUMBER

    def eval(self, x, y):
        return x * y
