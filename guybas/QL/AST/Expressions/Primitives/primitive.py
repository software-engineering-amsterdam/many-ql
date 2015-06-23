# basic primitive interface
class Primitive:
    def __init__(self):
        raise NotImplementedError("Not implemented here")

    def __str__(self):
        raise NotImplementedError("Not implemented here")

    def return_type(self, type_map):
        raise NotImplementedError("Not implemented here")

    def eval_expression(self, answer_map):
        raise NotImplementedError("Not implemented here")

    # every primitive except variable has no variables, so by default return the empty list
    def get_variables(self):
        return []

    # Every primitive is a valid expression so return the empty error message
    def type_error_messages(self, td):
        return []