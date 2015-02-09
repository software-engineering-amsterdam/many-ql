
import ply.lex as lex
import ply.yacc as yacc

from nodes import Node, Question, Expression
from src.typechecker.errors import ParseError

class Parser():

    def __init__(self, DEBUG=True):
        self.DEBUG = DEBUG

        lex.lex(module=self)
        yacc.yacc(module=self)

    def parse(self, text=""):
        return yacc.parse(text)


    ### Tokens ###

    reserved = {
      "form"    : "FORM",
      "if"      : "IF",
      "else"    : "ELSE",

      "or"      : "OR",
      "and"     : "AND",

      "int"     : "TYPE",
      "integer" : "TYPE",
      "bool"    : "TYPE",
      "boolean" : "TYPE",
      "float"   : "TYPE",
      "string"  : "TYPE",
      "money"   : "TYPE"
    }

    tokens = [
        'ID',
        'NUMBER',
        'STRING',

        'LPAR',
        'RPAR',
        'LBRACKET',
        'RBRACKET',

        'COLON',
        'PLUS',
        'MINUS',
        'TIMES',
        'DIVIDE',

        'EQ',
        'LT',
        'GT',

        'NEQ',
        'LT_EQ',
        'GT_EQ',

        'NOT'
    ] + list(set(reserved.values()))


    t_LPAR      = r'\('
    t_RPAR      = r'\)'
    t_LBRACKET  = r'\{'
    t_RBRACKET  = r'\}'

    t_COLON     = r':'

    t_PLUS      = r'\+'
    t_MINUS     = r'-'
    t_TIMES     = r'\*'
    t_DIVIDE    = r'/'

    t_EQ        = r'=='
    t_LT        = r'<'
    t_GT        = r'>'

    t_NEQ       = r'!='
    t_LT_EQ     = r'<='
    t_GT_EQ     = r'>='

    t_NOT       = r'!'
    t_OR        = r'\|\||or'
    t_AND       = r'&&|and'

    t_STRING    = r'("[^"]*")|(\'[^\']*\')'
    t_NUMBER    = r'[0-9]*\.?[0-9]+'
    t_TYPE      = r'int|integer|float|bool|boolean|string|money'


    precedence = (
        ('left','AND'),
        ('left','PLUS','MINUS'),
        ('left','TIMES','DIVIDE'),

        ('left','EQ','LT', 'GT'),
        ('left','OR'),

        ('right','UMINUS', 'NOT'),
    )


    def t_ID(self, t):
        r'[a-zA-Z_][a-zA-Z0-9_]*'
        t.type = self.reserved.get(t.value, "ID")
        return t

    # Track line numbers to use in error messages
    def t_NEWLINE(self, t):
        r'\n+'
        t.lexer.lineno += len(t.value)

    def t_COMMENT(self, t):
        r'(/\*(.|\n)*?\*/)|(//.*)|(\#.*)'
        pass

    def t_error(self, t):
        if self.DEBUG:
            print "Illegal character '%s'" % t.value[0]
        t.lexer.skip(1)

    t_ignore = " \t"


    ### Parsing rules ###

    def p_form(self, p):
        '''formdef : FORM ID block'''
        p[0] = Node("form", p[3], p[2])


    def p_block(self, p):
        '''block : LBRACKET RBRACKET
                 | LBRACKET statements RBRACKET
        '''
        if len(p) == 4:
            p[0] = p[2]


    def p_statements(self, p):
        '''statements : statements statement
                      | statement
        '''
        if len(p) == 2:
            p[0] = [p[1]]
        # question-list has multiple entries
        elif isinstance(p[1], list):
            p[0] = p[1] + [p[2]]
        else:
            p[0] = p[1:]


    def p_statement(self, p):
        '''statement : question
                     | ifdef
        '''
        p[0] = p[1]


    def p_question_simple(self, p):
        '''question : STRING'''
        p[0] = Question(p[1])


    def p_question_with_type(self, p):
        '''question : STRING TYPE'''
        p[0] = Question(p[1], p[2])


    def p_question_typed_label(self, p):
        '''question : STRING ID COLON TYPE'''
        p[0] = Question(p[1], p[4], p[2])


    def p_if(self, p):
        '''ifdef : IF expr block
                 | IF expr block ELSE block
        '''
        p[0] = Node("if", p[3], p[2])


    def p_single_term_expression(self, p):
        '''expr : ID
                | NUMBER
                | STRING
        '''
        p[0] = p[1]


    def p_binary_expression(self, p):
        '''expr : expr GT expr
                | expr LT expr
                | expr EQ expr

                | expr AND expr
                | expr OR  expr

                | expr PLUS expr
                | expr MINUS expr
                | expr TIMES expr
                | expr DIVIDE expr
        '''
        p[0] = Expression(p[2], p[1], p[3])


    def p_unary_minus_expression(self, p):
        '''expr : MINUS expr %prec UMINUS'''
        p[0] = "-" + p[2]


    def p_not_expression(self, p):
        '''expr : NOT expr %prec NOT'''
        p[0] = Expression("NOT", p[2])


    def p_grouped_expression(self, p):
        '''expr : LPAR expr RPAR'''
        p[0] = p[2]


    def p_empty_expression(self, p):
        '''expr : LPAR RPAR'''
        pass


    def p_error(self, p):
        if self.DEBUG:
            print "Syntax error at '%s'" % p

        raise ParseError(p)