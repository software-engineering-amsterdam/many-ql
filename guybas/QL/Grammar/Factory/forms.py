# Factory for creating Form elements out of parsed subtrees

from QL.AST.Statements import *
import QL.AST.form as form


def make_sentence(tokens):
    return ' '.join(tokens)


def make_question(subtrees):
    number = subtrees[0]
    q = subtrees[1]
    answer_type = subtrees[2]
    return question.Question(number, q, answer_type)


def make_if(subtrees):
    condition = subtrees[0]
    questions = []
    for i in range(1, len(subtrees)):
        questions.append(subtrees[i])
    return if_statement.IfBlock(condition, questions)


def make_else(subtrees):
    condition = subtrees[0]
    questions = []
    k = 1
    for i in range(1, len(subtrees) + 1):
        if subtrees[i] == "else":
            break
        else:
            questions.append(subtrees[i])
            k += 1
    else_questions = []
    for i in range(k + 1, len(subtrees)):
        else_questions.append(subtrees[i])
    x = if_else_statement.IfElseBlock(condition, questions, else_questions)
    return x


def make_assignment(subtrees):
    qid = subtrees[0]
    qtype = subtrees[1]
    expression = subtrees[2]
    return assignment.Assignment(qid, qtype, expression)


def make_form(subtrees):
    name = subtrees[0]
    if len(subtrees) > 2:
        introduction = make_sentence(subtrees[1])
        statements = subtrees[2]
        return form.Form(name, introduction, statements)
    else:
        statements = subtrees[1]
        return form.Form(name, "", statements)
