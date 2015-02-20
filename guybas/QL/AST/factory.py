# Factory which expects tokens and uses the ast classes to return a parsed ast
# Everything is static (pipeline style)

from AST.expression import *
from AST.question import *
from AST.conditional import *
from AST.form import *
from Main.converters import *


class BasicFactory:

    @staticmethod
    def make_sentence(tokens):
        return ' '.join(tokens)

    @staticmethod
    def make_bool(tokens):
        if tokens[0] == "True":
            return True
        else:
            return False
    @staticmethod
    def make_int(tokens):
        return int(tokens[0])


class ExpressionFactory:

    @staticmethod
    def make_operator(token):
        return Operator(token[0])

    @staticmethod
    def sub_expression(tokens):
        e = []
        for token in tokens:
            e += [token]
        return e

    @staticmethod
    def make_expression(tokens):
        x = Expression(ExpressionFactory.sub_expression(tokens.asList()))
        return x


class FormFactory:
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
        return IfBlock(condition, questions)

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
        x = IfElseBlock(condition, questions, else_questions)
        return x

    @staticmethod
    def make_form(tokens):
        name = tokens[0]
        introduction = BasicFactory.make_sentence(tokens[1])
        questions = []
        for i in range(2, len(tokens)):
            questions.append(tokens[i])
        x = Form(name, introduction, questions)
        return x