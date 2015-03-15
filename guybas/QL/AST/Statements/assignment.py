import QL.AST.Statements.statement as statement


class Assignment(statement.IStatement):

    #################################
    # override method of statement  #
    #################################

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
        s += "   " * (level + 1) + "Assignment _id: " + self.id + "\n"
        s += "   " * (level + 1) + "Assignment number: "+ str(self.order) + "\n"
        s += "   " * (level + 1) + "Assignment itself: " + (self.expression).pretty_print() + "\n"
        s += "   " * (level + 1) + "Assignment _type: " + str(self.type)
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

    # return all the _dependencies in the statement of other _statements
    def get_dependency_collection(self, dependencies):
        d = self.expression.get_dependencies()
        if self.id not in dependencies:
            dependencies[self.id] = d
        else:
            dependencies[self.id] = dependencies[self.id] + self.parent_condition.get_dependencies()
        return dependencies

    # return all sub (expressions)
    def return_expressions(self):
        return []

    # set the _order number of the statement, only set once
    def set_order(self, order_num):
        if not self.order:
            self.order = order_num
            return self.order + 1
        else:
            print("Warning: _order set more than once")
        return self.order + 1

    # return a dictionary of the ids as keys and types as value in the statement
    def get_id_type_collection(self):
        return {self.id: self.type}

    # Get the _order of elements in the statement
    def get_order(self):
        return self.order

    # Get a dictionary with ids and statements
    def get_statement_dict(self):
        return {self.id: self}

    ##########################
    # Methods of assignment  #
    ##########################

    # TODO: change below

    def set_parent_condition(self, condition):
        self.parent_condition = condition

    def set_element(self, gui):
        ...

    def get_type(self):
        return self.type

    def get_id(self):
        return self.id

    def get_label(self):
        return self.expression.pretty_print()

    def get_element(self):
        return self.element

    def get_parent_condition(self):
        return self.parent_condition


