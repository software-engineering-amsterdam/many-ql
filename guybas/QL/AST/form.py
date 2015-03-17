# AST format of the Form
import collections


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

    # TODO : test expression validator
    def check_expressions(self):
        td = self.get_type_dict()
        message = []
        for x in self._statements:
            message.extend(x.valid_type_message(td))
        return message

    #
    # Type checker stuff
    #

    @staticmethod
    def check_duplicates(l):
        # get_dependencies for duplicates
        duplicates = [x for x, y in collections.Counter(l).items() if y > 1]
        return duplicates

    def check_ids(self):
        duplicates = Form.check_duplicates(self.get_ids())
        if duplicates:
            return "There are duplicate ids: " + str(duplicates)
        else:
            return ""

    def check_labels(self):
        duplicates = Form.check_duplicates(self.get_labels())
        if duplicates:
            return "There are duplicate labels: " + str(duplicates)
        else:
            return ""

    def check_dependencies(self):
        message = ""
        dependencies = self.get_dependencies()
        for d in dependencies:
            if d in dependencies[d]:
                message += str(d) + " is dependent on itself"
        return message

    def is_valid_form(self):
        valid = True
        id_message = self.check_ids()
        if id_message:
            valid = False
            print(id_message)

        label_message = self.check_labels()
        if label_message:
            print(label_message)

        dependency_message = self.check_dependencies()
        if dependency_message:
            valid = False
            print(dependency_message)

        expression_message = self.check_expressions()
        if expression_message:
            valid = False
            print(expression_message)

        return valid

    def eval_expressions(self, type_map):
        for x in self._statements:
            if x.is_conditional():
                print(x.get_condition().pretty_print())
                print(x.evaluate_condition(type_map))
                print("----------")


