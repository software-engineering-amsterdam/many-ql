# basic primitive interface
class Primitive:
    def __init__(self):
        raise NotImplementedError("Not implemented by sub class")

    def string_presentation(self):
        raise NotImplementedError("Not implemented by sub class")

    def return_type_string(self, type_dict):
        raise NotImplementedError("Not implemented by sub class")

    def eval_expression(self, type_map):
        raise NotImplementedError("Not implemented by sub class")

    # every primitive except variable has no variables, so by default return the empty list
    def get_variables(self):
        return []

    # Every primitive is a valid expression so return the empty error message
    def is_valid_expression_message(self, td):
        return []