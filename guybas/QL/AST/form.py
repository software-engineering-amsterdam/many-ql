# AST format of the Form
import QL.AST.type_checker as type_checker
import QL.AST.exception_handling as exception_handling


class Form:
    def __init__(self, name, introduction, statements):
        self._name = name
        self._introduction = introduction
        self._statements = statements
        self.exception_handler = exception_handling.ExceptionHandling()

    # Pretty print the _form
    def string_presentation(self):
        s = self._name + "\n"
        s += self._introduction + "\n"
        for x in self._statements:
            s += x.string_presentation(1)
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
            new_dependencies = s.dependency_collection({})
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
            message.extend(x.valid_expression_message(td))
        return message

    #
    # Type checker stuff
    #

    def handle_exceptions(self):
        self.exception_handler.add_errors(type_checker.check_ids(self.get_ids()))
        self.exception_handler.add_warnings(type_checker.check_labels(self.get_labels()))
        self.exception_handler.add_errors(type_checker.check_dependencies(self.get_dependencies()))
        self.exception_handler.add_errors(self.check_expressions())
        self.exception_handler.execute()


