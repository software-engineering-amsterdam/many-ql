import QL.AST.form as ast_form
import QL.Tools.exceptions as e
import QL.Runtime.question as runtime_question
import QL.Tools.exceptions as exc
import QL.AST.Expressions.Operations.and_op as and_op


class Form:
    def __init__(self, ast_obj):
        if not isinstance(ast_obj, ast_form.Form):
            raise e.QException("Input must be an AST!")
        self.ast = ast_obj

        # cookbook - must be in the following order
        self.__ast_questions = []
        self.__q_conditions_dict = {}
        self.__flatten_ast(self.ast.get_statements())
        self.__combine_expressions()

        self.questions = []
        self.__enrich_questions()

    def get_questions(self):
        return self.questions

    def get_ast(self):
        return self.ast

    def get_form(self):
        return self

    def __flatten_ast(self, statements, conditions=[]):
        for statement in statements:
            if statement.is_conditional():
                c_statement_c = conditions
                c_statement_c.append(statement.get_condition())
                self.__flatten_ast(statement.get_c_statements(), c_statement_c)
                e_statement_c = conditions
                e_statement_c.append(statement.get_inverted_condition())
                self.__flatten_ast(statement.get_e_statements(), e_statement_c)
            else:
                self.__ast_questions.append(statement)
                self.__q_conditions_dict[statement.get_id()] = conditions

    def __enrich_questions(self):
        order = 0
        for basic_question in self.__ast_questions:
            qid = basic_question.get_id()
            if qid not in self.__q_conditions_dict:
                raise exc.QException("Fatal Error: id does not exist in the dict!")
            enriched_question = runtime_question.Question(basic_question, order, self.__q_conditions_dict[qid])
            self.questions.append(enriched_question)
            order += 1

    def __combine_expressions(self):
        for q_id in self.__q_conditions_dict:
            conditions_list = self.__q_conditions_dict[q_id]
            expr = conditions_list[0]
            for x in range(1, len(conditions_list), 2):
                expr = and_op.And("and", expr, conditions_list[x])
            self.__q_conditions_dict[q_id] = expr