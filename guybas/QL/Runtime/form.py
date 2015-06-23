import QL.AST.form as ast_form
import QL.Runtime.assignment as assignment

import QL.AST.Expressions.Operations.Logical.and_op as and_op
import importlib


class Form:
    def __init__(self, form_ast):
        assert isinstance(form_ast, ast_form.Form), "Input must be an AST"
        self._form_ast = form_ast

        self._statements = []
        self.create_flattened_statements(self._form_ast.statements(), importlib.import_module('QL.Runtime.question'))

    # Structure is given as parameter so it can be overridden in QLS
    def create_flattened_statements(self, statements, structure, conditions=[], order=0):
        for statement in statements:
            if statement.is_conditional():

                # flatten if block
                statement_conditions = list(conditions)
                statement_conditions.append(statement.get_condition())
                order = self.create_flattened_statements(statement.get_if_statements(), structure, statement_conditions, order)

                # flatten else block
                else_statement_conditions = list(conditions)
                else_statement_conditions.append(statement.get_inverted_condition())
                order = self.create_flattened_statements(statement.get_else_statements(), structure, else_statement_conditions, order)

            # create runtime assignment or runtime question with order and condition
            elif statement.is_assignment():
                a = \
                    assignment.Assignment(statement, order, Form.combine_expressions(conditions))
                self._statements.append(a)
            else:
                order += 1
                enriched_question = \
                    structure.Question(statement, order, Form.combine_expressions(conditions))
                self._statements.append(enriched_question)
        return order

    # from a list of expressions combine them using the and operation to create one expression
    @staticmethod
    def combine_expressions(expressions):
        if len(expressions) == 0:
            return None
        expr = expressions[0]
        for x in range(1, len(expressions), 2):
            expr = and_op.And(expr, expressions[x])
        return expr

    def statements(self):
        return self._statements

    def ast(self):
        return self._form_ast

    def form(self):
        return self

    def name(self):
        return self._form_ast.name()

    def introduction(self):
        return self._form_ast.introduction()

    def statement_map(self):
        d = {}
        for s in self.statements():
            d = dict(list(d.items()) + list(s.id_statement_map().items()))
        return d

