import QL.AST.Elements.element as element


class Text(element.Element):
    def __init__(self, text):
        self.text = text

    def pretty_print(self):
        return "\"" + str(self.text) + "\""

    def return_type(self, type_dict):
        return "text"

    def pretty_print(self):
        return self.text

    def get_dependencies(self):
        return []

    def as_list(self):
        return [self.text]