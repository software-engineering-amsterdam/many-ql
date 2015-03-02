# Factory which expects tokens and uses the ast classes to return a parsed form
# Everything is static (pipeline style)

from QL.AST.Elements.operators import *
from QL.Main.converters import *
from QL.AST.Statements.question import *
from QL.AST.Statements.if_statement import *
from QL.AST.Statements.else_statement import *
from QL.AST.form import *


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