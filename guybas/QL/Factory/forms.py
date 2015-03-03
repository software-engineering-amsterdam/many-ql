# Factory which expects tokens and uses the ast classes to return a parsed form
# Everything is static (pipeline style)

import QL.AST.Statements.question as question
import QL.AST.Statements.if_statement as if_statement
import QL.AST.Statements.else_statement as else_statement
import QL.AST.Statements.assignment as assignment

import QL.AST.form as form


class FormFactory:
    @staticmethod
    def make_sentence(tokens):
        return ' '.join(tokens)

    @staticmethod
    def make_question(tokens):
        number = tokens[0]
        q = tokens[1]
        answer_type = tokens[2]
        return question.Question(number, q, answer_type)

    @staticmethod
    def make_if(tokens):
        condition = tokens[0]
        questions = []
        for i in range(1, len(tokens)):
            questions.append(tokens[i])
        return if_statement.IfBlock(condition, questions)

    @staticmethod
    def make_else(tokens):
        condition = tokens[0]
        questions = []
        k = 1
        for i in range(1, len(tokens) + 1):
            if tokens[i] == "else":
                break
            else:
                questions.append(tokens[i])
                k += 1
        else_questions = []
        for i in range(k + 1, len(tokens)):
            else_questions.append(tokens[i])
        x = else_statement.IfElseBlock(condition, questions, else_questions)
        return x

    @staticmethod
    def make_assignment(tokens):
        return assignment.Assignment(tokens[0], tokens[1], tokens[2])

    @staticmethod
    def make_form(tokens):
        name = tokens[0]
        if len(tokens) > 2:
            return form.Form(name, FormFactory.make_sentence(tokens[1]), tokens[2])
        else:
            return form.Form(name, "", tokens[1])
