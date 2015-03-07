# statement interface with uninitialized methods


class IStatement:

    # init
    def __init__(self):
        raise NotImplementedError("Not implemented by sub class")

    # pretty print ast, with level giving the indentation
    def pretty_print(self, level=0):
        raise NotImplementedError("Not implemented by sub class")

    # return all ids in the statement
    def id_collection(self):
        raise NotImplementedError("Not implemented by sub class")

    # return all labels in the statement
    def label_collection(self):
        raise NotImplementedError("Not implemented by sub class")

    # return if the statement is a conditional
    def is_conditional(self):
        raise NotImplementedError("Not implemented by sub class")

    # return all the dependencies in the statement of other _statements
    def get_dependency_collection(self, dependencies):
        raise NotImplementedError("Not implemented by sub class")

    # return all sub (expressions)
    def return_expressions(self):
        raise NotImplementedError("Not implemented by sub class")

    # Get the parent id of the statement
    def get_parent_id(self):
        raise NotImplementedError("Not implemented by sub class")

    # set the parent id, only set once
    def set_parent_id(self, pid):
        raise NotImplementedError("Not implemented by sub class")

    # set the order number of the statement, only set once
    def set_order(self, order_num):
        raise NotImplementedError("Not implemented by sub class")

    def set_element(self, gui):
        raise NotImplementedError("Not implemented by sub class")

    # return a dictionary of the ids as keys and types as value in the statement
    def get_id_type_collection(self):
        raise NotImplementedError("Not implemented by sub class")

    # Get the order of elements in the statement
    def get_order(self):
        raise NotImplementedError("Not implemented by sub class")

    def get_element(self):
        raise NotImplementedError("Not implemented by sub class")    
        
    def get_statement_dict(self):
        raise NotImplementedError("Not implemented by sub class")