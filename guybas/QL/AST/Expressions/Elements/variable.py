import QL.AST.Expressions.Elements.element as e


class Variable(e.Element):
    def __init__(self, name):
        self.name = name

    def return_type_string(self, type_dict):
        return type_dict[self.name]

    def pretty_print(self):
        return self.name

    def get_dependencies(self):
        return [self.name]