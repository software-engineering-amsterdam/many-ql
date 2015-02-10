# Grammar
from pyparsing import *
from exceptions import *
from abstract import *
from ast import *

class BasicTypes:
    # Words, end signs and escaped signs
    endSignEsc      = Suppress("\\") + Literal("?") | Literal("/.") | Literal("/!")
    characters      = Word("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890()[]{},@#$%^&*-+=/\'\"`~_")
    word            = endSignEsc | characters  
    endSign         = oneOf(". ? !")
    
    # sentences consist of words and an end sign
    sentence        = (OneOrMore(word) + endSign).setParseAction(make_sentence)
    sentences       = OneOrMore(sentence)
    comment         = Literal("//") + restOfLine | cStyleComment

    
class Expressions: # TODO
    # Possible answers values
    bool            = Literal("bool")
    integer         = Word(nums)
    text            = BasicTypes.sentences
    
    # Expressions
    value           = bool | integer | text
    cOperators      = oneOf("> >= < <= ==")
    eOperators      = oneOf("+ - * / ")
    operator        = eOperators | cOperators
    parenthesis     = oneOf("( )")
    expr            = Forward()
    expr            <<= Group(expr + operator + expr) | value
    condition       = "1"

    
class FormFormat:
    # Question form: ID ANSWERTYPE LABEL
    id              = BasicTypes.characters
    label           = BasicTypes.sentence
    answerR         = Literal("bool") | Literal("integer") | Literal("text")  
    question        = ( Suppress("Question") + id + Suppress("(") + answerR + Suppress(")") + Suppress(":") + label
                      ).setParseAction(ASTReady.make_question)
    questions       = OneOrMore(question)
    
    # if/else form: IF CONDITION BLOCK (ELSE BLOCK)? 
    condition       = Expressions.condition
    pIf             = (Suppress("if" + Literal("(")) + condition + Suppress(")") + Suppress("{") + questions + Suppress("}"))
    pElse           = pIf + Literal("else") + Suppress("{") + questions + Suppress("}")
    
    # Advanced questions: (IF | ELSE) BLOCK | QUESTIONS
    aQuestions      = pElse.setParseAction(ASTReady.make_else) | \
                      pIf.setParseAction(ASTReady.make_if) | \
                      questions
                      
    # IDENTIFIER QUESTIONS
    form            = (id + Optional(Suppress("Introduction" + Literal(":") + BasicTypes.sentences)) + OneOrMore(aQuestions))

# Test
try:
    formAsParseResults = FormFormat.form.ignore(BasicTypes.comment).parseFile("ql_example.ql")
    form = ASTReady.make_form(formAsParseResults)
    
    #r = Expressions.condition.parseString("1 < 2")
    print(form)
except Exception as e:
    exceptions_handling(e)