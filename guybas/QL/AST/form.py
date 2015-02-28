# AST format of the Form


class Form:
    def __init__(self, name, introduction, statements):
        self._name = name
        self._introduction = introduction
        self._statements = statements
        self._type_dict = self.create_statement_dict()
        self.set_question_ordering()

    # Create a dictionary with ids as keys and types as values
    def create_statement_dict(self):
        d = {}
        for s in self._statements:
            d = dict(list(d.items()) + list(s.id_type_collection().items()))

        # The types and ids of these are the same
        d["comp_operator"] = "comp_operator"
        d["calc_operator"] = "calc_operator"
        d["bool"] = "bool"
        d["number"] = "number"

        return d

    # Pretty print the form
    def pretty_print(self):
        s = self._name + "\n"
        s += self._introduction + "\n"
        for x in self._statements:
            s += x.pretty_print(1)
        return s

    # Return all statements
    def get_statements(self):
        return self._statements

    # Return the name of the form
    def get_name(self):
        return self._name

    # Return the introduction
    # TODO: make this optional
    def get_introduction(self):
        return self._introduction

    # return all ids in the statements
    def get_ids(self):
        ids = []
        for s in self._statements:
            ids += (s.id_collection())
        return ids

    # return all labels in the statements
    def get_labels(self):
        labels = []
        for s in self._statements:
            labels += s.label_collection()
        return labels

    # Get a dictionary of ids and their dependencies
    def get_dependencies(self):
        dependencies = {}
        for s in self._statements:
            new_dependencies = s.dependency_collection({})
            dependencies = dict(list(dependencies.items()) + list(new_dependencies.items()))

        # Get transitive dependencies
        transitive_dependencies = {}
        for k in dependencies:
            transitive_dependencies[k] = Form.transitive_dependencies_key(k, set([]), set([]), dependencies)
        return transitive_dependencies

    @staticmethod
    def transitive_dependencies_key(key, values, checked, dependencies):
        for v in dependencies[key]:
            values.add(v)
            checked.add(key)
            if v not in checked:
                values = values.union(Form.transitive_dependencies_key(v, values, checked, dependencies))
        return values

    # Return all expressions present in the form
    def get_expressions(self):
        expressions = []
        for x in self._statements:
            expressions += x.return_expressions()
        return expressions

    # Return a dictionary with ids as keys and types as values
    def get_type_dict(self):
        return self._type_dict

    # Set the ordering of questions for display
    def set_question_ordering(self):
        c = 0
        for s in self._statements:
            c = s.set_order(c)
