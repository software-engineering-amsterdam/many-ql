# Abstract syntax

from ast import *

class ASTReady:
    def make_question(tokens):
        number = tokens[0]
        question = tokens[1]
        answertype = tokens[2]
        return Question(number, question, answertype)
        
    def make_if(tokens):
        condition = tokens[0]
        questions = []
        for i in range(1, len(tokens)):
            questions.append(tokens[i])
        return ConditionalQuestions(condition, questions)

    def make_else(tokens):
        condition = tokens[0]
        questions = [] 
        k = 1
        for i in range(1, len(tokens)):
            if i == "else":
                break
            else:
                questions.append(tokens[i])
                k += 1
        else_questions = []
        print(k)
        print(len(tokens))
        for i in range(k, len(tokens)):
            else_questions += tokens[i]
        return ConditionalQuestions(condition, questions).add_else(else_questions)
        
    def make_form(tokens):
        name = tokens[0]
        introduction = tokens[1]
        questions = []
        for i in range(2, len(tokens)):
            questions.append(tokens[i])
        x = Form(name, introduction, questions)
        return x