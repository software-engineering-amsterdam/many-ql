class Element:
    def __init__(self):
        raise Exception("Not implemented by sub class")

    def return_type_string(self, type_dict):
        raise Exception("Not implemented by sub class")

    def pretty_print(self):
        raise Exception("Not implemented by sub class")

    def get_dependencies(self):
        raise Exception("Not implemented by sub class")

    def is_valid_expression(self, td):
        return True