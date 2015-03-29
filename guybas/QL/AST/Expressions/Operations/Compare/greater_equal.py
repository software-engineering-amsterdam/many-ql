import QL.AST.Expressions.Operations.Compare.compare_expression as compare_expression


class GreaterEqual(compare_expression.CompareExpression):

    def set_string_operator(self):
        return ">="

    def concrete_eval(self, x, y):
        return x >= y