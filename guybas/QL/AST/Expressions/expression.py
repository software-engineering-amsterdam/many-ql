# Expression without parenthesis
class Expression:
    # initialization
    def __init__(self, expression):
        self._expression = expression
        self._dependencies = Expression.dependency_collection(self._expression)

    # get the return _type of the _expression
    def return_type_string(self, type_dict):
        types = ""
        for x in self._expression:
            types += x.return_type_string(type_dict)
        return types

    # return a pretty printed string of the _expression
    def pretty_print(self, level = 0):
        s = ""
        if self._expression:
            for x in self._expression:
                s += x.pretty_print()
        return s

    # get all variables in the _expression
    def get_dependencies(self):
        return self._dependencies

    # return the expressions as a list of lists
    def as_list(self):
        l = []
        for x in self._expression:
            l += x.as_list()
        return l

    # static helper method to get the _dependencies once
    @staticmethod
    def dependency_collection(expression):
        dependencies = []
        for element in expression:
            dependencies += element.get_dependencies()
        return dependencies

    # Return the negative of the _expression
    # def add_not(self):
    #     l = [Expression(self._expression)]
    #     return Expression([operators.Operator("not"), c.ComplexExpression(l)])