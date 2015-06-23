import QL.AST.Statements.if_statement as if_statement
import QL.AST.Expressions.Types.bool_type as bool_type


class IfElseBlock(if_statement.IfBlock):

    def __init__(self, condition, statements, else_statements):
        self._condition = condition
        self._statements = statements
        self._else_statements = else_statements

    # pretty formatted string, with level giving the indentation
    def string_presentation(self, level=0):
        s = "\n" + "   " * level + "If %s" % str(self._condition)
        for x in self._statements:
            s += "   " * level + x.string_presentation(level+1)

        s += "   " * level + "else"
        for x in self._else_statements:
            s += "   " * level + x.string_presentation(level+1)
        return s

    # return all ids in both if and else statements, same approach for methods below
    def ids(self):
        ids = []
        for x in self._statements:
            ids += x.ids()
        for x in self._else_statements:
            ids += x.ids()
        return ids

    def labels(self):
        labels = []
        for x in self._statements:
            labels += x.labels()
        for x in self._else_statements:
            labels += x.labels()
        return labels

    # dictionary of id to types, same for methods below with statements
    def id_type_map(self):
        d = {}
        for s in self._statements:
            # fuse the old dictionary with the new one
            d = dict(list(d.items()) + list(s.id_type_map().items()))
        for s in self._else_statements:
            d = dict(list(d.items()) + list(s.id_type_map().items()))
        return d

    def id_statement_map(self):
        d = {}
        for s in self._statements:
            d = dict(list(d.items()) + list(s.id_statement_map().items()))
        for s in self._else_statements:
            d = dict(list(d.items()) + list(s.id_statement_map().items()))

        return d

    def expressions_type_error_messages(self, td):
        error_messages = self._condition.type_error_messages(td)
        for x in self._statements:
            error_messages += x.expressions_type_error_messages(td)
        for x in self._else_statements:
            error_messages += x.expressions_type_error_messages(td)
        if not self._condition.return_type(td) == bool_type.Bool():
            error_messages.append("the return type of the expression: %s is not of type bool" % str(self._condition))
        return error_messages

    def get_else_statements(self):
        return self._else_statements


