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
        return variable.Variable(tokens[0])

    @staticmethod
    def make_number(tokens):
        return number.Number(int(tokens[0]))

    @staticmethod
    def make_calc_operator(tokens):
        return operator.CalcOperator(tokens[0])

    @staticmethod
    def make_comp_operator(tokens):
        return operator.CompareOperator(tokens[0])

    @staticmethod
    def make_extra_operator(tokens):
        return operator.ExtraOperator(tokens[0])

    @staticmethod
    def make_bool(tokens):
        if tokens[0] == "True":
            return boolean.Bool(True)
        else:
            return boolean.Bool(False)

    @staticmethod
    def make_text(tokens):
        return text.Text(f.FormFactory.make_sentence(tokens))

    @staticmethod
    def make_sub_expression(tokens):
        e = simple_expression.SimpleExpression(tokens)
        return e

    @staticmethod
    def make_expression(tokens):
        x = complex_expression.ComplexExpression(tokens)
        return x