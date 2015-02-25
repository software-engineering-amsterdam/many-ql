# Factory which expects tokens and uses the ast classes to return a parsed ast
# Everything is static (pipeline style)

from AST.complexexpression import *
from AST.question import *
from AST.conditional import *
from AST.form import *

from AST.operators import *
from Main.converters import *


class ExpressionFactory:

    @staticmethod
    def make_variable(tokens):
        return Variable(tokens[0])

    @staticmethod
    def make_number(tokens):
        return Number(int(tokens[0]))

    @staticmethod
    def make_calc_operator(tokens):
        return CalcOperator(tokens[0])

    @staticmethod
    def make_comp_operator(tokens):
        return CompareOperator(tokens[0])

    @staticmethod
    def make_bool(tokens):
        if tokens[0] == "True":
            return Bool(True)
        else:
            return Bool(False)

    @staticmethod
    def make_sub_expression(tokens):
        e = SimpleExpression(tokens)
        return e

    @staticmethod
    def make_expression(tokens):
        x = ComplexExpression(tokens)
        return x


class FormFactory:
    @staticmethod
    def make_sentence(tokens):
        return ' '.join(tokens)

    @staticmethod
    def make_question(tokens):
        number = tokens[0]
        question = tokens[1]
        answer_type = tokens[2]
        return Question(number, question, answer_type)

    @staticmethod
    def make_if(tokens):
        condition = tokens[0]
        questions = []
        m = Converters.get_md5(str(tokens))
        for i in range(1, len(tokens)):
            tokens[i].set_parent_id(m)
            questions.append(tokens[i])
        return IfBlock(condition, questions, m)

    @staticmethod
    def make_else(tokens):
        condition = tokens[0]
        questions = [] 
        k = 1
        m = Converters.get_md5(str(tokens))
        for i in range(1, len(tokens) + 1):
            if tokens[i] == "else":
                break
            else:
                tokens[i].set_parent_id(m)
                questions.append(tokens[i])
                k += 1
        else_questions = []
        for i in range(k + 1, len(tokens)):
            tokens[i].set_parent_id(m)
            else_questions.append(tokens[i])
        x = IfElseBlock(condition, questions, else_questions, m)
        return x

    @staticmethod
    def make_form(tokens):
        name = tokens[0]
        introduction = FormFactory.make_sentence(tokens[1])
        questions = []
        for i in range(2, len(tokens)):
            questions.append(tokens[i])
        x = Form(name, introduction, questions)
        return x