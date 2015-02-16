# Abstract syntax
from ast import *


class ASTReady:
    def make_sentence(tokens):
        return ' '.join(tokens)

    def sub_expression(tokens):
        e = ""
        for token in tokens:
            if isinstance(token, list):
                e += "(" + ASTReady.sub_expression(token) + ")"
            else:
                e += str(token) + " "
        return e  
        
    def make_expression(tokens):
        return Expression(ASTReady.sub_expression(tokens.asList())) 

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
        return AdvancedQuestions(condition, questions)


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
        x = AdvancedQuestions(condition, questions)
        x.add_else(else_questions)
        return x
        
    def make_form(tokens):
        name = tokens[0]
        introduction = ASTReady.make_sentence(tokens[1])
        questions = []
        for i in range(2, len(tokens)):
            questions.append(tokens[i])
        x = Form(name, introduction, questions)
        return x