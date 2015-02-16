
import ply.yacc

from src.QL import nodes
from src.typechecker.errors import ParseError

from tokens import tokens


# Precedence is ordered from low to high
precedence = (
    ('left','OR'),
    ('left','AND'),

    ('left', '<', '>', 'LT_EQ', 'GT_EQ'),
    ('left','EQ', 'NEQ'),

    ('left','+','-'),
    ('left','*','/'),

    ('right','UMINUS', 'NOT'),
)


def p_form(p):
    '''formdef : FORM ID block'''
    p[0] = nodes.Form(p[2], p[3])


def p_block(p):
    '''block : '{' '}'
             | '{' statements '}'
    '''
    if len(p) == 4:
        p[0] = p[2]

def p_statements(p):
    '''statements : statement
                  | statements statement
    '''
    if len(p) == 2:
        p[0] = [p[1]]
    elif isinstance(p[1], list):
        p[0] = p[1] + [p[2]]
    else:
        p[0] = p[1:]


def p_statement(p):
    '''statement : question
                 | ifdef
    '''
    p[0] = p[1]


def p_question_simple(p):
    '''question : STRING'''
    p[0] = nodes.Question(p[1])


def p_question_with_type(p):
    '''question : STRING TYPE
                | STRING TYPE function
    '''
    p[0] = nodes.Question(p[1], p[2], None, p[3])


def p_question_typed_label(p):
    '''question : STRING ID ':' TYPE
                | STRING ID ':' TYPE function
    '''
    if len(p) == 5:
        p[0] = nodes.Question(p[1], p[4], p[2])
    else:
        p[0] = nodes.Question(p[1], p[4], p[2], p[5])


def p_if(p):
    '''ifdef : IF function block
             | IF function block ELSE block
    '''
    if len(p) == 4:
      p[0] = nodes.Branch(p[2], p[3], [])
    else:
      p[0] = nodes.Branch(p[2], p[3], p[5])


def p_grouped_expression(p):
    '''
    function : '(' ')'
             | '(' expr ')'
    '''
    if len(p) == 4:
        p[0] = p[2]


def p_single_term_expression(p):
    '''expr : ID
            | NUMBER
            | STRING
            | function
    '''
    p[0] = p[1]


def p_binary_expression(p):
    '''expr : expr '>' expr
            | expr '<' expr

            | expr EQ expr
            | expr NEQ expr
            | expr LT_EQ expr
            | expr GT_EQ expr

            | expr AND expr
            | expr OR  expr

            | expr '+' expr
            | expr '-' expr
            | expr '*' expr
            | expr '/' expr
    '''
    p[0] = nodes.Expression(p[2], p[1], p[3])


def p_unary_minus_expression(p):
    '''expr : '-' expr %prec UMINUS'''
    p[0] = nodes.UnaryExpression(p[2], 'MIN')


def p_not_expression(p):
    '''expr : '!' expr %prec NOT'''
    p[0] = nodes.UnaryExpression(p[2], 'NOT')


def p_error(p):
    print "Syntax error at '%s'" % p
    raise ParseError(p)


class Parser:
    def __init__(self, debug=0):
        self.debug  = debug
        self.parser = ply.yacc.yacc()


    def parse(self, text=""):
        return self.parser.parse(text, debug=self.debug)
