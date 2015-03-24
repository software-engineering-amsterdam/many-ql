import QL.AST.form as ast_form
import QL.Runtime.question as runtime_question
import QL.Tools.exceptions as exc
import QL.AST.Expressions.Operations.and_op as and_op


class Form:
    def __init__(self, ast_obj):
        assert isinstance(ast_obj, ast_form.Form), "Input must be an AST!"
        self.ast = ast_obj

        # cookbook - must be in the following order
        self.__ast_questions = []  # questions only based on the ast (basic questions)
        self.__q_conditions_dict = {}  # {question_id : parent conditions}
        self.assignments = []

        self.__flatten_ast(self.ast.get_statements())
        self.__combine_expressions()

        self.questions = []  # list for new enriched questions
        self.__enrich_questions()

    def get_questions(self):
        return self.questions

    def get_ast(self):
        return self.ast

    def get_form(self):
        return self

    def get_statement_dict(self):
        d = {}
        for s in self.get_questions():
            d = dict(list(d.items()) + list(s.get_statement_dict().items()))
        return d

    def __flatten_ast(self, statements, conditions=[]):
        """
        Gets an AST, flatten it to list of questions only,
        and collect parent conditions recursively for each question.
            self.__ast_questions = list of only questions based on the AST
            self.__q_conditions_dict = dict of the questions with their parent conditions
        :param statements: form statements / recursive blocks
        :param conditions: previous recursively collected conditions
        """
        for statement in statements:
            if statement.is_conditional():
                # flatten if block
                c_statement_c = list(conditions)
                c_statement_c.append(statement.get_condition())
                self.__flatten_ast(statement.get_c_statements(), c_statement_c)

                # flatten else block
                e_statement_c = list(conditions)
                e_statement_c.append(statement.get_inverted_condition())
                self.__flatten_ast(statement.get_e_statements(), e_statement_c)
                conditions = []
            elif statement.is_assignment():
                pass #TODO: fix assignments
            else:
                self.__ast_questions.append(statement)  # add question to the new flat list
                self.__q_conditions_dict[statement.get_id()] = conditions  # add condition to questions parent conditions

    def __enrich_questions(self):
        """
        takes the basic ast questions and generate new enriched question objects
        with gui element, order and other useful stuff for runtime.
            self.__ast_questions = list of questions based on the ast only
            self.__q_conditions_dict = dict of the questions with their parent conditions
            self.questions = new enriched questions
        """
        order = 0
        for basic_question in self.__ast_questions:
            qid = basic_question.get_id()
            assert qid in self.__q_conditions_dict, "id does not exist in the dict"
            enriched_question = runtime_question.Question(basic_question, order, self.__q_conditions_dict[qid])
            self.questions.append(enriched_question)
            order += 1

    # def __enrich_lib(self, basic_question, order, conditions):
    #     runtime_question.Question(basic_question, order, conditions)

    def __combine_expressions(self):
        """
        takes a shared variable list of expressions and join them together logically
            self.__q_conditions_dict = dict of the questions with their parent conditions.
        """
        for q_id in self.__q_conditions_dict:
            conditions_list = self.__q_conditions_dict[q_id]
            if not conditions_list:
                self.__q_conditions_dict[q_id] = None
                continue
            expr = conditions_list[0]
            for x in range(1, len(conditions_list), 2):
                expr = and_op.And(expr, conditions_list[x])
            self.__q_conditions_dict[q_id] = expr