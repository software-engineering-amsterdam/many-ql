# AST for if_block
import QL.AST.Statements.statement as statement
import QL.Main.converters as converters


class IfBlock(statement.IStatement):

    # init
    def __init__(self, condition, statements):
        self._condition = condition
        self._statements = statements
        self._element = None
        self._parent_id = None
        self._expressions = IfBlock.expression_collection(self._condition, self._statements)
        self._statement_dict = IfBlock.statement_dict(self._statements)
        self._id_type_dict = IfBlock.id_type_collection(self._statements)

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

    # return all the dependencies in the statement of other _statements
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
        return self._expressions

    # Get the parent _id of the statement
    def get_parent_id(self):
        return self._parent_id

    # set the parent _id, only set once
    def set_parent_id(self, pid):
        self._parent_id = pid
        m = converters.Converters.get_md5(str(self))
        for s in self._statements:
            s.set_parent_id(m)
            s.set_parent_condition(self._condition)

    # set the order number of the statement, only set once
    def set_order(self, order_num):
        c = order_num
        for s in self._statements:
            c = s.set_order(c)
        return c

    def set_element(self, gui):
        pass

    # return a dictionary of the ids as keys and types as value in the statement
    def get_id_type_collection(self):
        return self._id_type_dict

    # Get the order of elements in the statement
    def get_order(self):
        raise NotImplementedError("Not implemented by sub class")

    def get_element(self):
        return self._element

    def get_statement_dict(self):
        return self._statement_dict

    def set_parent_condition(self, condition):
        pass

    # Getters of if _statements
    def get_c_statements(self):
        return self._statements

    def get_id(self):
        return None

    def get_condition(self):
        return self._condition

    def get_str_condition(self):
        return self._condition.pretty_print()

    def get_e_statements(self):
        return []

    @staticmethod
    def expression_collection(condition, statements):
        s = [condition]
        for x in statements:
            s += x.return_expressions()
        return s

    @staticmethod
    def statement_dict(statements):
        d = {}
        for s in statements:
            d = dict(list(d.items()) + list(s.get_statement_dict().items()))
        return d

    @staticmethod
    def id_type_collection(statements):
        d = {}
        for s in statements:
            d = dict(list(d.items()) + list(s.get_id_type_collection().items()))
        return d


