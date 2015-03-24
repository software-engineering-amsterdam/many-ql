import QL.AST.Expressions.Operations.binary_expression as b


class Minus(b.BinaryExpression):

    def set_string_operator(self):
        return "-"

    def return_type(self, type_map):
        return int

    def eval(self, x, y):
        return x - y