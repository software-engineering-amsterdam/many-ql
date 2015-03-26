# Factory for creating Form elements (name, introduction, statements) out of parsed subtrees

from QL.AST.Statements import *
import QL.AST.form as form


# from a list of words create a normal sentence
def make_sentence(tokens):
    return ' '.join(tokens)


def make_question(subtrees):
    number = subtrees[0]
    qid = subtrees[1]
    answer_type = subtrees[2]
    return question.Question(number, qid, answer_type)


def make_if(subtrees):
    condition = subtrees[0]
    statements = []
    # add statements
    for i in range(1, len(subtrees)):
        statements.append(subtrees[i])
    return if_statement.IfBlock(condition, statements)


def make_else(subtrees):
    condition = subtrees[0]
    statements = []
    k = 1
    # add statements
    for i in range(1, len(subtrees) + 1):
        if subtrees[i] == "else":
            break
        else:
            statements.append(subtrees[i])
            k += 1
    else_questions = []

    # add else statements
    for i in range(k + 1, len(subtrees)):
        else_questions.append(subtrees[i])
    x = if_else_statement.IfElseBlock(condition, statements, else_questions)
    return x


def make_assignment(subtrees):
    qid = subtrees[0]
    qtype = subtrees[1]
    expression = subtrees[2]
    return assignment.Assignment(qid, qtype, expression)


def make_form(subtrees):
    name = subtrees[0]

    # Check if an introduction text is given
    if len(subtrees) > 2:
        introduction = make_sentence(subtrees[1])
        statements = subtrees[2]
        return form.Form(name, introduction, statements)
    else:
        statements = subtrees[1]
        return form.Form(name, "", statements)
