import QL.AST.Expressions.Primitives.primitive as e


class Variable(e.Primitive):
    def __init__(self, name):
        self.name = name

    def return_type_string(self, type_dict):
        return type_dict[self.name]

    def pretty_print(self):
        return self.name

    # The dependency of the calling object is this variable
    def get_dependency_collection(self):
        return [self.name]