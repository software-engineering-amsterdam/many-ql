# Grammar

from pyparsing import *
from QL.factory import *

class BasicTypes:
    '''
    word        :: [0-9a-zA-Z()[]{},@#$%^&*-+=/\'\"`~_]
    endSign     :: . | ? | !
    sentence    :: word+ endSign
    sentences   :: sentence+
    '''

    endSign         = oneOf(". ? !")
    endSignEsc      = Suppress("\\") + endSign
    
    characters      = Word("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890()[]{},@#$%^&*-+=/\'\"`~_")
    word            = endSignEsc | characters  
    
    sentence        = (OneOrMore(word) + endSign).setParseAction(ASTReady.make_sentence)
    
    sentences       = OneOrMore(sentence)
    comment         = Literal("//") + restOfLine | cStyleComment


class Expressions:
    '''
    bool        :: True | False
    integer     :: [0123456789]
    text        :: sentences

    value       :: bool | integer | text
    compare     :: > | >= | < | <= | ==
    operators   :: + | - | / | *

    atom        :: value | (expr)
    expr        :: atom (operator expr)*
    condition   :: expr compare expr
    '''
    bool            = Literal("True") | Literal("False")
    integer         = Word(nums)
    text            = BasicTypes.sentences
    
    value           = bool.setParseAction(ASTReady.make_bool) | \
                      integer.setParseAction(ASTReady.make_int) | \
                      text

    compare         = oneOf("> >= < <= ==")
    operator        = oneOf('+ - / *')

    expr            = Forward()
    atom            = value | Group(Suppress("(") + expr + Suppress(")"))
    expr            << atom + ZeroOrMore(operator + expr)
    
    condition       = Group(expr + compare + expr)


class FormFormat:
    """
    id          :: characters
    label       :: sentence

    answerR     :: "bool" | "integer" | "text"
    question    :: Question id ( answerR ) : label
    questions   :: question+

     pIf          :: if ( condition ) { aQuestions }
    pIfElse      :: if ( condition ) { aQuestions } else { aQuestions }
    aQuestions   :: pIf | pIfElse | questions

    introduction :: sentences
    form         :: id introduction? aQuestions
    """

    id              = BasicTypes.characters
    label           = BasicTypes.sentence

    answerR         = Literal("bool") | Literal("integer") | Literal("text")
    question        = (Suppress("Question") + id + Suppress("(") + answerR + Suppress(")") + Suppress(":") + label
                       ).setParseAction(ASTReady.make_question)
    questions       = OneOrMore(question)
    
    aQuestions      = Forward()
    condition       = Expressions.condition.setParseAction(ASTReady.make_expression)
    pIf             = (Suppress("if" + Literal("(")) + condition + Suppress(")") + Suppress("{") +
                       OneOrMore(aQuestions) + Suppress("}"))
                       
    pIfElse         = (Suppress("if" + Literal("(")) + condition + Suppress(")") + Suppress("{") +
                       OneOrMore(aQuestions) + Suppress("}")) + Literal("else") + Suppress("{") + aQuestions + Suppress("}")
    
    aQuestions      <<= OneOrMore(
                          (pIfElse.setParseAction(ASTReady.make_else))
                        | (pIf).setParseAction(ASTReady.make_if)
                        | questions)
                      
    introduction    = Group(Suppress("Introduction" + Literal(":")) + BasicTypes.sentences)
    form            = id + Optional(introduction) + aQuestions