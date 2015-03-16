# AST format of the Form


class Form:
    def __init__(self, name, introduction, statements):
        self._name = name
        self._introduction = introduction
        self._statements = statements

    # Pretty print the _form
    def pretty_print(self):
        s = self._name + "\n"
        s += self._introduction + "\n"
        for x in self._statements:
            s += x.pretty_print(1)
        return s

    #
    # getters of the form
    #

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

    # TODO: it broke..
    def get_dependencies(self):
        dependencies = {}
        for s in self._statements:
            new_dependencies = s.get_dependency_collection({})
            dependencies = dict(list(dependencies.items()) + list(new_dependencies.items()))
        # Get transitive _dependencies
        transitive_dependencies = {}
        for k in dependencies:
            transitive_dependencies[k] = Form.transitive_dependencies_key(k, set([]), set([]), dependencies)
        return transitive_dependencies

    def get_type_dict(self):
        d = {}
        for s in self._statements:
            d = dict(list(d.items()) + list(s.get_id_type_collection().items()))
        return d

    def get_statement_dict(self):
        d = {}
        for s in self._statements:
            d = dict(list(d.items()) + list(s.get_statement_dict().items()))
        return d

    @staticmethod
    def transitive_dependencies_key(key, values, checked, dependencies):
        for v in dependencies[key]:
            values.add(v)
            checked.add(key)
            if v not in checked:
                values = values.union(Form.transitive_dependencies_key(v, values, checked, dependencies))
        return values

    def valid_expressions(self):
        td = self.get_type_dict()
        for x in self._statements:
            if not x.valid_type(td):
                print("x is not valid")
                return False
        return True