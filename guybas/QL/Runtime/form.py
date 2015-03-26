import QL.AST.form as ast_form
import QL.Runtime.question as runtime_question
import QL.AST.Expressions.Operations.Logical.and_op as and_op


class Form:
    def __init__(self, form_ast):
        assert isinstance(form_ast, ast_form.Form), "Input must be an AST"
        self._form_ast = form_ast

        # cookbook - must be in the following order
        self._ast_questions = []  # questions only, based on the ast (basic questions)
        self._q_conditions_dict = {}  # {question_id : parent conditions}
        self.assignments = []  # assignments

        self.__flatten_ast(self._form_ast.statements())
        self.__combine_expressions()

        self._questions = []  # list for new enriched questions
        self._enrich_questions()

    def questions(self):
        return self._questions

    def get_assignments(self):
        return self.assignments

    def get_ast(self):
        return self._form_ast

    def get_form(self):
        return self

    def get_statement_dict(self):
        d = {}
        for s in self.questions() + self.get_assignments():
            d = dict(list(d.items()) + list(s.id_statement_map().items()))
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
                statement_conditions = list(conditions)
                statement_conditions.append(statement.get_condition())
                self.__flatten_ast(statement.get_if_statements(), statement_conditions)

                # flatten else block
                else_statement_conditions = list(conditions)
                else_statement_conditions.append(statement.get_inverted_condition())
                self.__flatten_ast(statement.get_else_statements(), else_statement_conditions)
            elif statement.is_assignment():
                # TODO: GUY, should the condition not also be added to the assignment parent conditions?
                self.assignments.append(statement)
            else:
                self._ast_questions.append(statement)  # add question to the new flat list
                self._q_conditions_dict[statement.ids()[0]] = conditions  # add condition to questions parent conditions

    # For each question in the ast, create a new enriched question containing conditions and
    def _enrich_questions(self):
        order = 0
        for basic_question in self._ast_questions:
            qid = basic_question.ids()[0]
            enriched_question = runtime_question.Question(basic_question, order, self._q_conditions_dict[qid])
            self._questions.append(enriched_question)
            order += 1

    def __combine_expressions(self):
        for q_id in self._q_conditions_dict:
            conditions_list = self._q_conditions_dict[q_id]
            if not conditions_list:
                self._q_conditions_dict[q_id] = None
                continue
            expr = conditions_list[0]
            for x in range(1, len(conditions_list), 2):
                expr = and_op.And(expr, conditions_list[x])
            self._q_conditions_dict[q_id] = expr