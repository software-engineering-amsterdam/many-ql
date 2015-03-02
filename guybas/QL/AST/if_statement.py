# AST for if_block
from QL.AST.statement import *


class IfBlock(IStatement):

    # Override
    def __init__(self, condition, statements, tid):
        self.condition = condition
        self.statements = statements
        self.parent_id = tid

    # Override
    def pretty_print(self, level=0):
        s = "\n" + "   " * level + "If (" + self.condition.pretty_print(0) + ")"
        for x in self.statements:
            s += "   " * level + x.pretty_print(level + 1)
        return s

    # Override
    def id_collection(self):
        ids = []
        for x in self.statements:
            ids += x.id_collection()
        return ids

    # Override
    def label_collection(self):
        labels = []
        for x in self.statements:
            labels += x.label_collection()
        return labels

    # Override
    def is_conditional(self):
        return True

    # Override
    def dependency_collection(self, dependencies): # TODO : change inefficiency
        ids = self.id_collection()
        for i in ids:
            if i in dependencies:
                dependencies[i] = dependencies[i] + self.condition.get_dependencies()
            else:
                dependencies[i] = self.condition.get_dependencies()
        for x in self.statements:
            dependencies = dict(list(dependencies.items()) + list(x.dependency_collection(dependencies).items()))
        return dependencies

    # Override
    def return_expressions(self):
        s = [self.condition]
        for x in self.statements:
            s += x.return_expressions()
        return s

    # Override
    def get_parent_id(self):
        return self.parent_id

    # Override
    def set_parent_id(self, pid):
        self.parent_id = pid

    # Override
    def set_order(self, order_num):
        c = order_num
        for s in self.statements:
            c = s.set_order(c)
        return c

    # Override
    def id_type_collection(self):
        d = {}
        for s in self.statements:
            d = dict(list(d.items()) + list(s.id_type_collection().items()))
        return d

    # Getters of if statements
    def get_c_statements(self):
        return self.statements

    def get_id(self):
        return None

    def get_condition(self):
        return self.condition

    def get_str_condition(self):
        return self.condition.pretty_print()

    def get_e_statements(self):
        return []

