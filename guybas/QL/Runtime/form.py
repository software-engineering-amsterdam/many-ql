import QL.AST.form as ast_form
import QL.Tools.exceptions as e
import QL.Runtime.question as runtime_question


class Form:
    def __init__(self, ast_obj):
        if not isinstance(ast_obj, ast_form.Form):
            raise e.QException("Input must be an AST!")
        self.ast = ast_obj

        self.__ast_questions = []
        self.__q_conditions_dict = {}
        self.__flatten_ast(self.ast.get_statements())
        print(self.__q_conditions_dict)
        # self.questions = []
        # self.__enrich_questions()

    def get_questions(self):
        return self.questions

    def get_ast(self):
        return self.ast

    # @staticmethod
    # def __flatten_ast(statements):
    #     questions = []
    #     for statement in statements:
    #         if statement.is_conditional():
    #             questions += Form.__flatten_ast(statement.get_c_statements())
    #             questions += Form.__flatten_ast(statement.get_e_statements())
    #         else:
    #             questions.append(statement)
    #     return questions

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

    @staticmethod
    def __enrich_questions(basic_questions):
        questions = []
        order = 0
        for basic_question in basic_questions:
            enriched_question = runtime_question.Question(basic_question, order)
            questions.append(enriched_question)
            order += 1
        return questions

