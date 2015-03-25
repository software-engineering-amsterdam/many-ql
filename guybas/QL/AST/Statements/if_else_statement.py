import QL.AST.Statements.if_statement as if_statement


class IfElseBlock(if_statement.IfBlock):

    #
    # override methods of statement
    #

    # init
    def __init__(self, condition, statements, else_statements):
        self._condition = condition
        self._statements = statements
        self._else_statements = else_statements

    # pretty print ast, with level giving the indentation
    def string_presentation(self, level=0):
        s = "\n" + "   " * level + "If %s" % str(self._condition)
        for x in self._statements:
            s += "   " * level + x.string_presentation(level+1)

        s += "   " * level + "else"
        for x in self._else_statements:
            s += "   " * level + x.string_presentation(level+1)
        return s

    # return all ids in the statement
    def id_collection(self):
        ids = []
        for x in self._statements:
            ids += x.id_collection()
        for x in self._else_statements:
            ids += x.id_collection()
        return ids

    # return all labels in the statement
    def label_collection(self):
        labels = []
        for x in self._statements:
            labels += x.label_collection()
        for x in self._else_statements:
            labels += x.label_collection()
        return labels

    # return a dictionary of the ids as keys and types as value in the statement
    def get_id_type_collection(self):
        d = {}
        for s in self._statements:
            d = dict(list(d.items()) + list(s.get_id_type_collection().items()))
        for s in self._else_statements:
            d = dict(list(d.items()) + list(s.get_id_type_collection().items()))
        return d

    # Get a dictionary with ids and statements
    def get_statement_dict(self):
        d = {}
        for s in self._statements:
            d = dict(list(d.items()) + list(s.get_statement_dict().items()))
        for s in self._else_statements:
            d = dict(list(d.items()) + list(s.get_statement_dict().items()))

        return d

    def valid_expression_messages(self, td):
        messages = self._condition.is_valid_messages(td)
        for x in self._statements:
            messages += x.valid_expression_messages(td)
        for x in self._else_statements:
            messages += x.valid_expression_messages(td)
        return messages

    def get_else_statements(self):
        return self._else_statements


