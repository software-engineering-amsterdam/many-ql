

# IExpression interface
class IExpression:
    # initialization
    def __init__(self):
        raise NotImplementedError("Not implemented by sub class")

    # get the return _type of the _expression
    def return_type_string(self, type_dict):
        raise NotImplementedError("Not implemented by sub class")

    # return a pretty printed string of the _expression
    def pretty_print(self):
        raise NotImplementedError("Not implemented by sub class")

    # get all variables in the _expression
    def get_dependencies(self):
        raise NotImplementedError("Not implemented by sub class")






