# AST format of the Form

class Form:
    def __init__(self, name, introduction, statements):
        self._name = name
        self._introduction = introduction
        self._statements = statements
        self._type_dict = self.create_statement_dict()

    def create_statement_dict(self):
        d = {}
        for s in self._statements:
            d = dict(list(d.items()) + list(s.id_type_collection().items()))
        d["comp_operator"] = "comp_operator"
        d["calc_operator"] = "calc_operator"
        d["bool"] = "bool"
        d["number"] = "number"

        return d

    def pretty_print(self):
        s = self._name + "\n"
        s += self._introduction + "\n"
        for x in self._statements:
            s += x.pretty_print(1)
        return s

    def get_statements(self):
        return self._statements

    def get_name(self):
        return self._name

    def get_introduction(self):
        return self._introduction

    def get_ids(self):
        ids = []
        for s in self._statements:
            ids += (s.id_collection())
        return ids

    def get_labels(self):
        labels = []
        for s in self._statements:
            labels += s.label_collection()
        return labels

    def get_dependencies(self):
        dependencies = {}
        for s in self._statements:
            new_dependencies = s.dependency_collection({})
            dependencies = dict(list(dependencies.items()) + list(new_dependencies.items()))
        return dependencies

    def get_expressions(self):
        expressions = []
        for x in self._statements:
            expressions += x.return_expressions()
        return expressions

    # Getters
    def get_statements(self):
        return self._statements

    def get_type_dict(self):
        return self._type_dict