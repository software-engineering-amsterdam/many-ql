import QL.AST.form as ast_form
import QL.Runtime.question as runtime_question
import QL.Runtime.assignment as assigment

import QL.AST.Expressions.Operations.Logical.and_op as and_op


class Form:
    def __init__(self, form_ast):
        assert isinstance(form_ast, ast_form.Form), "Input must be an AST"
        self._form_ast = form_ast

        self._questions = []
        self.extract_statements(self._form_ast.statements())

    def extract_statements(self, statements, conditions=[], order=0):
        for statement in statements:
            if statement.is_conditional():

                # flatten if block
                statement_conditions = list(conditions)
                statement_conditions.append(statement.get_condition())
                order = self.extract_statements(statement.get_if_statements(), statement_conditions, order)

                # flatten else block
                else_statement_conditions = list(conditions)
                else_statement_conditions.append(statement.get_inverted_condition())
                order = self.extract_statements(statement.get_else_statements(), else_statement_conditions, order)

            elif statement.is_assignment():
                assignment = \
                    assigment.Assignment(statement, order, Form.combine_expressions(conditions))
                self._questions.append(assignment)
            else:
                order += 1
                enriched_question = \
                    runtime_question.Question(statement, order, Form.combine_expressions(conditions))
                self._questions.append(enriched_question)
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

    def questions(self):
        return self._questions

    def get_ast(self):
        return self._form_ast

    def get_form(self):
        return self

    def name(self):
        return self._form_ast.name()

    def introduction(self):
        return self._form_ast.introduction()

    def get_statement_dict(self):
        d = {}
        for s in self.questions():
            d = dict(list(d.items()) + list(s.id_statement_map().items()))
        return d

