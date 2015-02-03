
import ply.lex as lex
import ply.yacc as yacc

from nodes import Node, Question
from typecheck import ParseError

class QL():

    def __init__(self):
        lex.lex(module=self)
        yacc.yacc(module=self)

    def parse(self, text):
        return yacc.parse(text)

    ### Tokens ###

    tokens = (
        'FORM',
        'NAME',
        'NUMBER',
        'STRING',
        'TYPE',
        'PLUS',
        'MINUS',
        'MULT',
        'DIV',
        'EQ',
        'LT',
        'GT',
        'COLON',
        'LPAR',
        'RPAR',
        'LBRACKET',
        'RBRACKET'
    )

    RESERVED = {
      "form"    : "FORM",
      "if"      : "IF",

      "int"     : "TYPE",
      "bool"    : "TYPE",
      "boolean" : "TYPE",
      "float"   : "TYPE",
      "string"  : "TYPE"
    }

    t_ignore = " \t"

    # Tokens

    t_COLON     = r':'
    t_EQ        = r'=='
    t_LT        = r'<'
    t_GT        = r'>'
    t_PLUS      = r'\+'
    t_MINUS     = r'-'
    t_MULT      = r'\*'
    t_DIV       = r'/'
    t_LPAR      = r'\('
    t_RPAR      = r'\)'
    t_LBRACKET  = r'\{'
    t_RBRACKET  = r'\}'
    t_STRING    = r'("[^"]*")|(\'[^\']*\')'
    t_TYPE      = r'int|integer|float|bool|boolean|string|money'

    def t_NUMBER(self, t):
        r'\d+'
        try:
            t.value = int(t.value)
        except ValueError:
            print "Integer value too large", t.value
            t.value = 0

        return t

    def t_NAME(self, t):
        r'[a-zA-Z_][a-zA-Z0-9_]*'
        t.type = self.RESERVED.get(t.value, "NAME")
        return t

    # Track line numbers to use in error messages
    def t_NEWLINE(self, t):
        r'\n+'
        t.lexer.lineno += len(t.value)
        pass

    def t_SINGLE_COMMENT(self, t):
        r'(\#|//).*'
        pass


    def t_error(self, t):
        print "Illegal character '%s'" % t.value[0]
        t.lexer.skip(1)


    ### Parsing rules ###

    def p_form(self, p):
        '''formdef : FORM NAME block'''
        p[0] = Node("form", p[3], p[2])


    def p_block(self, p):
        '''
        block : LBRACKET RBRACKET
              | LBRACKET questions RBRACKET
        '''
        if len(p) == 4:
            p[0] = Node('question-list', p[2])
        else:
            p[0] = Node('question-list', [])


    def p_questions(self, p):
        '''
        questions : questions question
                  | question
        '''
        # single question
        if len(p) == 2:
            p[0] = p[1]
        # question-list has multiple entries
        elif isinstance(p[1], list):
            p[0] = p[1] + [p[2]]
        else:
            p[0] = p[1:]

    def p_question_simple(self, p):
        '''
        question : STRING
        '''
        p[0] = Question(p[1])


    def p_question_with_type(self, p):
        '''
        question : STRING TYPE
        '''
        p[0] = Question(p[1], p[2])


    def p_question_typed_label(self, p):
        '''
        question : STRING NAME COLON TYPE
        '''
        p[0] = Question(p[1], p[4], p[2])


    def p_error(self, p):
        print "Syntax error at '%s'" % p
        raise ParseError('Syntax?')

