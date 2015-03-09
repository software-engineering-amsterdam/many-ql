import QL.AST.Expressions.simple_expression as simple_expression
import QL.AST.Expressions.complex_expression as complex_expression
import QL.AST.Elements.operators as operator
import QL.AST.Elements.variable as variable
import QL.AST.Elements.bool as boolean
import QL.AST.Elements.number as number
import QL.AST.Elements.text as text
import QL.Factory.forms as f


# Factory for creating expressions
class ExpressionFactory:

    @staticmethod
    def make_variable(tokens):
        v = tokens[0]
        return variable.Variable(v)

    @staticmethod
    def make_number(tokens):
        n = int(tokens[0])
        return number.Number(n)

    @staticmethod
    def make_operator(tokens):
        op = tokens[0]
        return operator.Operator(op)

    @staticmethod
    def make_bool(tokens):
        value = tokens[0]
        if value == "True":
            return boolean.Bool(True)
        else:
            return boolean.Bool(False)

    @staticmethod
    def make_text(tokens):
        t = f.FormFactory.make_sentence(tokens)
        return text.Text(t)

    @staticmethod
    def make_sub_expression(tokens):
        return simple_expression.SimpleExpression(tokens)

    @staticmethod
    def make_expression(tokens):
        return complex_expression.ComplexExpression(tokens)
