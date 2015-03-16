import QL.AST.Expressions.expression_interface as e
import QL.AST.Expressions.sub_expression as c


# IExpression without parenthesis
class Expression(e.IExpression):
    # initialization
    def __init__(self, expression):
        self._expression = expression

    # get the return _type of the _expression
    def return_type_string(self, type_dict):
        types = ""
        for x in self._expression:
            types += x.return_type_string(type_dict)
        return types

    # return a pretty printed string of the _expression
    def pretty_print(self, level = 0):
        s = ""
        for x in self._expression:
            s += "(" + x.pretty_print() + ")"
        return s

    # get all variables in the _expression
    def get_dependencies(self):
        dependencies = []
        # for element in self._expression:
        #     dependencies += element.get_dependencies()
        return dependencies

    # Return the negative of the _expression
    # def add_not(self):
    #     l = [Expression(self._expression)]
    #     return Expression([operators.Operator("not"), c.SubExpression(l)])