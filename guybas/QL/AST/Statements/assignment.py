import QL.AST.Statements.statement as statement


class Assignment(statement.IStatement):
    # init
    def __init__(self, qid, qtype, expression):
        self.id = qid
        self.type = qtype
        self.expression = expression
        self.parent_id = None
        self.order = None
        self.element = None

    # pretty print ast, with level giving the indentation
    def pretty_print(self, level=0):
        s = "\n" + "   " * level + "Assignment\n"
        s += "   " * (level + 1) + "Assignment id: " + self.id + "\n"
        s += "   " * (level + 1) + "Assignment number: "+ str(self.order) + "\n"
        s += "   " * (level + 1) + "Assignment itself: " + self.expr + "\n"
        s += "   " * (level + 1) + "Assignment type: " + str(self.type)
        s += "\n"
        return s

    # return all ids in the statement
    def id_collection(self):
        return [self.id]

    # return all labels in the statement
    def label_collection(self):
        return []

    # return if the statement is a conditional
    def is_conditional(self):
        return False

    # return all the dependencies in the statement of other _statements
    def dependency_collection(self, dependencies):
        if self.id not in dependencies:
            dependencies[self.id] = []
        return dependencies

    # Override
    def return_expressions(self):
        return []

    # Override
    def get_parent_id(self):
        return self.parent_id

    # Override
    def set_parent_id(self, pid):
        self.parent_id = pid

    def set_parent_condition(self, condition):
        self.parent_condition = condition

    # Override
    def set_order(self, order_num):
        if not self.order:
            self.order = order_num
            return self.order + 1
        else:
            print("Warning: order set more than once")
        return self.order + 1

    def set_element(self, gui):
        ...

    # Override
    def id_type_collection(self):
        return {self.id: self.type}

    # Override
    def get_order(self):
        return self.order

    def get_type(self):
        return self.type

    def get_id(self):
        return self.id

    def get_label(self):
        return self.expression.pretty_print()

    def get_element(self):
        return self.element

    def get_statement_dict(self):
        return {self.id: self}
