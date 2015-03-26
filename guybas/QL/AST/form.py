# AST format of the Form
import collections


class Form:
    def __init__(self, name, introduction, statements):
        self._name = name
        self._introduction = introduction
        self._statements = statements

    # Pretty formatted string of the _form
    def string_presentation(self):
        s = self._name + "\n"
        s += self._introduction + "\n"
        for x in self._statements:
            s += x.string_presentation(0)
        return s

    def statements(self):
        return self._statements

    def name(self):
        return self._name

    def introduction(self):
        return self._introduction

    def ids(self):
        ids = []
        for s in self._statements:
            ids += (s.ids())
        return ids

    def labels(self):
        labels = []
        for s in self._statements:
            labels += s.labels()
        return labels

    # return a dictionary with ids as keys and dependencies (ids) as values, same approach below for id to type
    # and id to statements
    def dependencies(self):
        dependencies = {}
        for s in self._statements:
            new_dependencies = s.dependencies({})
            dependencies = dict(list(dependencies.items()) + list(new_dependencies.items()))
        # Get transitive _dependencies
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

    def id_type_map(self):
        d = {}
        for s in self._statements:
            d = dict(list(d.items()) + list(s.id_type_map().items()))
        return d

    def id_statement_map(self):
        d = {}
        for s in self._statements:
            d = dict(list(d.items()) + list(s.id_statement_map().items()))
        return d

    #
    # Type checker
    #

    def expression_type_error_messages(self):
        td = self.id_type_map()
        messages = []
        for x in self._statements:
            messages.extend(x.expressions_type_error_messages(td))
        return messages

    @staticmethod
    def check_duplicates(l):
        duplicates = [x for x, y in collections.Counter(l).items() if y > 1]
        return duplicates

    def ids_error_messages(self):
        error_messages = []
        duplicates = Form.check_duplicates(self.ids())
        for i in duplicates:
            error_messages.append("duplicate id: " + i)
        return error_messages

    def labels_error_messages(self):
        error_messages = []
        duplicates = self.check_duplicates(self.labels())
        for i in duplicates:
            error_messages.append("duplicate label: " + i)
        return error_messages

    def dependencies_error_messages(self):
        error_messages = []
        dependencies = self.dependencies()
        for d in dependencies:
            if d in dependencies[d]:
                error_messages += [str(d) + " is dependent on itself"]
        return error_messages


