# AST format of the Form
import QL.Main.converters as converters
import QL.AST.Elements.constants as constants


class Form:
    def __init__(self, name, introduction, statements):
        # initialization variables
        self._name = name
        self._introduction = introduction

        # set the statement _order and the parent _id's
        self._statements = (
            Form.set_conditions(
                Form.set_question_ordering(statements))
        )

        # create dictionary of ids as keys and types as values
        self._type_dict = self.create_statement_dict(self._statements)

        # get all ids
        self._ids = Form.id_collection(self._statements)

        # get all labels
        self._labels = Form.label_collection(self._statements)

        # get all _dependencies (variables)
        self._dependencies = Form.dependency_collection(self._statements)

        # get all expressions
        self._expressions = Form.expression_collection(self._statements)

        # get a dictionary of ids as keys and _statements as values
        self._statement_dict = Form.id_statement_dict(self._statements)

    # Pretty print the _form
    def pretty_print(self):
        s = self._name + "\n"
        s += self._introduction + "\n"
        for x in self._statements:
            s += x.pretty_print(1)
        return s

    #########################
    # getters of the _form   #
    #########################

    def get_statements(self):
        return self._statements

    def get_name(self):
        return self._name

    def get_introduction(self):
        return self._introduction

    def get_ids(self):
        return self._ids

    def get_labels(self):
        return self._labels

    def get_dependencies(self):
        return self._dependencies

    def get_expressions(self):
        return self._expressions

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
    def set_conditions(statements):
        for s in statements:
            s.set_parent_condition(None)
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