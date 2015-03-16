# AST for if_block
import QL.AST.Statements.statement as statement
import QL.AST.Expressions.Operations.not_op as not_operation

class IfBlock(statement.IStatement):

    #
    # override methods of statement
    #

    # init
    def __init__(self, condition, statements):
        self._condition = condition
        self._statements = statements
        self._element = None

    # pretty print ast, with level giving the indentation
    def pretty_print(self, level=0):
        s = "\n" + "   " * level + "If (" + self._condition.pretty_print(0) + ")"
        for x in self._statements:
            s += "   " * level + x.pretty_print(level + 1)
        return s

    # return all ids in the statement
    def id_collection(self):
        ids = []
        for x in self._statements:
            ids += x.id_collection()
        return ids

    # return all labels in the statement
    def label_collection(self):
        labels = []
        for x in self._statements:
            labels += x.label_collection()
        return labels

    # return if the statement is a conditional
    def is_conditional(self):
        return True

    # return all the _dependencies in the statement of other _statements
    def get_dependency_collection(self, dependencies):
        ids = self.id_collection()
        new_dep = self._condition.get_dependency_collection()
        for i in ids:
            if i in dependencies:
                dependencies[i] = dependencies[i] + new_dep
            else:
                dependencies[i] = new_dep
        for x in self._statements:
            dependencies = dict(list(dependencies.items()) + list(x.get_dependency_collection(dependencies).items()))
        return dependencies

    # set the _order number of the statement, only set once
    def set_order(self, order_num):
        c = order_num
        for s in self._statements:
            c = s.set_order(c)
        return c

    # return a dictionary of the ids as keys and types as value in the statement
    def get_id_type_collection(self):
        d = {}
        for s in self._statements:
            d = dict(list(d.items()) + list(s.get_id_type_collection().items()))
        return d

    # Get a dictionary with ids and statements
    def get_statement_dict(self):
        d = {}
        for s in self._statements:
            d = dict(list(d.items()) + list(s.get_statement_dict().items()))
        return d

    def valid_type_message(self, td):
        message = self._condition.is_valid_expression_message(td)
        for x in self._statements:
            message += x.valid_type_message(td)
        return message

    #
    # Getters of the if statement
    #

    # Getters of if _statements
    def get_c_statements(self):
        return self._statements

    def get_condition(self):
        return self._condition

    def get_e_statements(self):
        return []

    def get_reverted_condition(self):
        return not_operation.Not("not", self._condition)


