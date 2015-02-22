# AST format of the Form


class Form:
    def __init__(self, name, introduction, statements):
        self.name = name
        self.introduction = introduction
        self.statements = statements
        self.type_dict = self.create_statement_dict()

    def create_statement_dict(self):
        d = {}
        for s in self.statements:
            d = dict(list(d.items()) + list(s.id_type_collection().items()))
        d["comp_operator"] = "comp_operator"
        d["calc_operator"] = "calc_operator"
        d["bool"] = "bool"
        d["number"] = "number"

        return d

    def pretty_print(self):
        s = self.name + "\n"
        s += self.introduction + "\n"
        for x in self.statements:
            s += x.pretty_print(1)
        return s

    def get_statements(self):
        return self.statements

    def get_name(self):
        return self.name

    def get_introduction(self):
        return self.introduction
