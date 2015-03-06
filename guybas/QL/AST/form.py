# AST format of the Form
import QL.Main.converters as converters
import QL.AST.Elements.constants as constants


class Form:
    def __init__(self, name, introduction, statements):
        self._name = name
        self._introduction = introduction
        self._statements = Form.set_question_ordering(statements)
        self._type_dict = self.create_statement_dict(self._statements)
        self._ids = Form.id_collection(self._statements)
        self._labels = Form.label_collection(self._statements)
        self._dependencies = Form.dependency_collection(self._statements)
        self._expressions = Form.expression_collection(self._statements)
        self._statement_dict = Form.id_statement_dict(self._statements)
        self._parent_id = Form.set_statement_ids(str(self), self._statements)

    # Pretty print the form
    def pretty_print(self):
        s = self._name + "\n"
        s += self._introduction + "\n"
        for x in self._statements:
            s += x.pretty_print(1)
        return s

    # Return all _statements
    def get_statements(self):
        return self._statements

    # Return the name of the form
    def get_name(self):
        return self._name

    # Return the introduction
    def get_introduction(self):
        return self._introduction

    # return all ids in the _statements
    def get_ids(self):
        return self._ids

    # return all labels in the _statements
    def get_labels(self):
        return self._labels

    # Get a dictionary of ids and their dependencies
    def get_dependencies(self):
        return self._dependencies

    # Return all expressions present in the form
    def get_expressions(self):
        return self._expressions

    # Return a dictionary with ids as keys and types as values
    def get_type_dict(self):
        return self._type_dict

    def get_statement_dict(self):
        return self._statement_dict

    #########################
    # static helper methods #
    #########################

    # Set the ordering of questions for display
    @staticmethod
    def set_question_ordering(statements):
        c = 0
        for s in statements:
            c = s.set_order(c)
        return statements

    @staticmethod
    def id_statement_dict(statements):
        d = {}
        for s in statements:
            d = dict(list(d.items()) + list(s.get_statement_dict().items()))
        return d

    @staticmethod
    def set_statement_ids(string, statements):
        m = converters.Converters.get_md5(str(string))
        for s in statements:
            s.set_parent_id(m)
        return statements

    @staticmethod
    def id_collection(statements):
        ids = []
        for s in statements:
            ids += (s.id_collection())
        return ids

    @staticmethod
    def label_collection(statements):
        labels = []
        for s in statements:
            labels += s.label_collection()
        return labels

    @staticmethod
    def dependency_collection(statements):
        dependencies = {}
        for s in statements:
            new_dependencies = s.get_dependency_collection({})
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

    @staticmethod
    def expression_collection(statements):
        expressions = []
        for x in statements:
            expressions += x.return_expressions()
        return expressions

    # Create a dictionary with ids as keys and types as values
    @staticmethod
    def create_statement_dict(statements):
        d = {}
        for s in statements:
            d = dict(list(d.items()) + list(s.get_id_type_collection().items()))

        # The types and ids of these are the same
        d[constants.ElementsConstants.COMP_OP] = constants.ElementsConstants.COMP_OP
        d[constants.ElementsConstants.CALC_OP] = constants.ElementsConstants.CALC_OP
        d[constants.ElementsConstants.BOOL] = constants.ElementsConstants.BOOL
        d[constants.ElementsConstants.NUMBER] = constants.ElementsConstants.NUMBER

        return d