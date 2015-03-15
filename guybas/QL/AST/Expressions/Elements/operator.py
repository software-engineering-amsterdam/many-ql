# AST for operators
import QL.AST.Expressions.Elements.element as e


class Operator(e.Element):
    def __init__(self, operator):
        self.operator = operator

    def pretty_print(self):
        return " " + str(self.operator) + " "

    def get_dependencies(self):
        return []

    def as_list(self):
        return [self.operator]

    def return_type_string(self, type_dict):
        return self.pretty_print()


class Opar:
    def __init__(self):
        pass

    def pretty_print(self):
        return "("

    def get_dependencies(self):
        return []


class Cpar:
    def __init__(self):
        pass

    def pretty_print(self):
        return ")"

    def get_dependencies(self):
        return []