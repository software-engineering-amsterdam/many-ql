import QL.AST.Elements.element as e


# Expression interface
class Expression(e.Element):
    # initialization
    def __init__(self):
        raise NotImplementedError("Not implemented by sub class")

    # get the return type of the _expression
    def return_type(self, type_dict):
        raise NotImplementedError("Not implemented by sub class")

    # return a pretty printed string of the _expression
    def pretty_print(self):
        raise NotImplementedError("Not implemented by sub class")

    # get all variables in the _expression
    def get_dependencies(self):
        raise NotImplementedError("Not implemented by sub class")

    # return the expressions as a list of lists
    def as_list(self):
        raise NotImplementedError("Not implemented by sub class")

    # static helper method to get the dependencies once
    @staticmethod
    def dependency_collection(expression):
        raise NotImplementedError("Not implemented by sub class")






