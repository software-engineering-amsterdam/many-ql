# Factory which expects tokens and uses the ast classes to return a parsed form
# Everything is static (no state)

import QL.AST.Statements.question as question
import QL.AST.Statements.if_statement as if_statement
import QL.AST.Statements.else_statement as else_statement
import QL.AST.Statements.assignment as assignment
import QL.AST.form as form
import QL.AST.AnswerTypes.bool as a
import QL.AST.AnswerTypes.text as t
import QL.AST.AnswerTypes.number as n




class FormFactory:
    @staticmethod
    def make_sentence(tokens):
        return ' '.join(tokens)

    @staticmethod
    def make_bool_type(tokens):
        return a.Bool()

    @staticmethod
    def make_number_type(tokens):
        return n.Number()

    @staticmethod
    def make_text_type(tokens):
        return t.Text()

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
        qid = tokens[0]
        qtype = tokens[1]
        expression = tokens[2]
        return assignment.Assignment(qid, qtype, expression)

    @staticmethod
    def make_form(tokens):
        name = tokens[0]
        if len(tokens) > 2:
            introduction = FormFactory.make_sentence(tokens[1])
            statements = tokens[2]
            return form.Form(name, introduction, statements)
        else:
            statements = tokens[1]
            return form.Form(name, "", statements)
