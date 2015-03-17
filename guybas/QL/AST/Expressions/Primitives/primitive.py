# basic primitive interface
class Primitive:
    def __init__(self):
        raise Exception("Not implemented by sub class")

    def return_type_string(self, type_dict):
        raise Exception("Not implemented by sub class")

    def pretty_print(self):
        raise Exception("Not implemented by sub class")

    def get_dependency_collection(self):
        raise Exception("Not implemented by sub class")

    # Every primitive is a valid expression so return the empty error message
    def is_valid_expression_message(self, td):
        return []

    def eval_expression(self, type_map):
        raise Exception("Not implemented by sub class")