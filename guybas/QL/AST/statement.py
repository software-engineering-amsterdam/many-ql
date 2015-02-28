# statement interface with uninitialized methods


class IStatement:

    # init
    def __init__(self):
        pass

    # pretty print ast, with level giving the indentation
    def pretty_print(self, level=0):
        pass

    # return all ids in the statement
    def id_collection(self):
        pass

    # return all labels in the statement
    def label_collection(self):
        pass

    # return if the statement is a conditional
    def is_conditional(self):
        pass

    # return all the dependencies in the statement of other _statements
    def dependency_collection(self, dependencies):
        pass

    # return all sub (expressions)
    def return_expressions(self):
        pass

    # Get the parent id of the statement
    def get_parent_id(self):
        pass

    # set the parent id, only set once
    def set_parent_id(self, pid):
        pass

    # set the order number of the statement, only set once
    def set_order(self, order_num):
        pass

    # return a dictionary of the ids as keys and types as value in the statement
    def id_type_collection(self):
        pass

    # Get the order of elements in the statement
    def get_order(self):
        pass
