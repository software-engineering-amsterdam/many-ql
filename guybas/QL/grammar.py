# Grammar

from pyparsing import *
from factory import *


class TypesIdentifiers:
    bool            = "bool"
    text            = "text"
    integer         = "integer"
    # boolean = []
    # boolean['name'] = "bool"
    # boolean['type'] = bool
    #
    # text = []
    # text['name']    = "text"
    # text['type']    = str
    #
    # integer = []
    # integer['name'] = "integer"
    # integer['type'] = int


class BasicTypes:
    """
    word        :: [0-9a-zA-Z()[]{},@#$%^&*-+=/\'\"`~_]
    endSign     :: . | ? | !
    sentence    :: word+ endSign
    sentences   :: sentence+

    bool        :: True | False
    integer     :: [0123456789]
    text        :: sentences
    """

    endSign         = oneOf(". ? !")
    endSignEsc      = Suppress("\\") + endSign
    
    characters      = Word("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890()[]{},@#$%^&*-+=/\'\"`~_")
    word            = endSignEsc | characters
    
    sentence        = (OneOrMore(word) + endSign).setParseAction(ASTReady.make_sentence)
    
    sentences       = OneOrMore(sentence)
    comment         = Literal("//") + restOfLine | cStyleComment

    boolean         = {'name': 'bool', 'value': Literal("True") | Literal("False")}
    integer         = {'name': 'integer', 'value': Word(nums)}
    text            = {'name': 'text', 'value': sentences}


class Expressions:
    """
    value       :: bool | integer | text
    compare     :: > | >= | < | <= | ==
    operators   :: + | - | / | *

    atom        :: value | (expr)
    expr        :: atom (operator expr)*
    condition   :: expr compare expr
    """
    
    value           = BasicTypes.boolean['value'] | BasicTypes.integer['value'] | BasicTypes.text['value']
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
    
    answerR         = Literal(TypesIdentifiers.bool) | Literal(TypesIdentifiers.integer) | Literal(TypesIdentifiers.text)
    question        = (Suppress("Question") + id + Suppress("(") + answerR + Suppress(")") + Suppress(":") + label
                       ).setParseAction(ASTReady.make_question)
    questions       = OneOrMore(question)
    
    aQuestions      = Forward()
    condition       = Expressions.condition.setParseAction(ASTReady.make_expression)
    pIf             = (Suppress("if" + Literal("(")) + condition + Suppress(")") + Suppress("{") +
                       OneOrMore(aQuestions) + Suppress("}"))
                       
    pIfElse         = (Suppress("if" + Literal("(")) + condition + Suppress(")") + Suppress("{") +
                       OneOrMore(aQuestions) + Suppress("}")) + Literal("else") + Suppress("{") + aQuestions + Suppress("}")
    
    aQuestions      <<= OneOrMore((pIfElse.setParseAction(ASTReady.make_else))
                                  | pIf.setParseAction(ASTReady.make_if)
                                  | questions)
                      
    introduction    = Group(Suppress("Introduction" + Literal(":")) + BasicTypes.sentences)
    form            = id + Optional(introduction) + aQuestions