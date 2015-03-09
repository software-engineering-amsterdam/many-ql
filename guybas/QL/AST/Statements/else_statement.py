import QL.AST.Statements.if_statement as if_statement
import QL.Main.converters as converters


class IfElseBlock(if_statement.IfBlock):

    #################################
    # override method of statement  #
    #################################

    # init
    def __init__(self, condition, statements, else_statements):
        self._condition = condition
        self._statements = statements
        self.else_statements = else_statements
        self._element = None

    # pretty print ast, with level giving the indentation
    def pretty_print(self, level=0):
        s = "\n" + "   " * level + "If (" + self._condition.pretty_print(0) + ")"
        for x in self._statements:
            s += "   " * level + x.pretty_print(level+1)

        s += "   " * level + "else"
        for x in self.else_statements:
            s += "   " * level + x.pretty_print(level+1)
        return s

    # return all ids in the statement
    def id_collection(self):
        ids = []
        for x in self._statements:
            ids += x.id_collection()
        for x in self.else_statements:
            ids += x.id_collection()
        return ids

    # return all labels in the statement
    def label_collection(self):
        labels = []
        for x in self._statements:
            labels += x.label_collection()
        for x in self.else_statements:
            labels += x.label_collection()
        return labels

    # return all the _dependencies in the statement of other _statements
    def get_dependency_collection(self, dependencies):
        ids = self.id_collection()
        for i in ids:
            if i in dependencies:
                dependencies[i] = dependencies[i] + self._condition.get_dependencies()
            else:
                dependencies[i] = self._condition.get_dependencies()
        for x in self._statements:
            dependencies = dict(list(dependencies.items()) + list(x.get_dependency_collection(dependencies).items()))
        return dependencies

    # return all sub (expressions)
    def return_expressions(self):
        s = [self._condition]
        for x in self._statements:
            s += x.return_expressions()
        for x in self.else_statements:
            s += x.return_expressions()
        return s

    # set the _order number of the statement, only set once
    def set_order(self, order_num):
        c = order_num
        for s in self._statements:
            c = s.set_order(c)
        for s in self.else_statements:
            c = s.set_order(c)
        return c

    # return a dictionary of the ids as keys and types as value in the statement
    def get_id_type_collection(self):
        d = {}
        for s in self._statements:
            d = dict(list(d.items()) + list(s.get_id_type_collection().items()))
        for s in self.else_statements:
            d = dict(list(d.items()) + list(s.get_id_type_collection().items()))
        return d

    # Get a dictionary with ids and statements
    def get_statement_dict(self):
        d = {}
        for s in self._statements:
            d = dict(list(d.items()) + list(s.get_statement_dict().items()))
        for s in self.else_statements:
            d = dict(list(d.items()) + list(s.get_statement_dict().items()))

        return d

    ##############################
    # Method of else statement   #
    ##############################

    # TODO: change structure below

    # Override
    def set_parent_condition(self, condition):
        for s in self._statements:
            s.set_parent_condition(self._condition)
        for s in self.else_statements:
            s.set_parent_condition(self._condition.add_not())

    def set_element(self, gui):
        ...

    def get_e_statements(self):
        return self.else_statements

    def get_element(self):
        return self._element

