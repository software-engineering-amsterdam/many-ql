
import ply.yacc

from src.QL import nodes
from src.Errors import ParseError

from tokens import tokens, Lexer


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
    p[0] = nodes.Form(p)


def p_block(p):
    '''block : '{' '}'
             | '{' statements '}'
    '''
    if len(p) == 4:
        p[0] = p[2]
    else:
        p[0] = []

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


def p_question(p):
    '''
    question : STRING
             | STRING TYPE
             | STRING TYPE function
             | STRING ID ':' TYPE
             | STRING ID ':' TYPE '=' function
    '''
    p[0] = nodes.Question(p)


def p_if(p):
    '''ifdef : IF expr block'''
    p[0] = nodes.Branch(p, p[3])


def p_ifElse(p):
    '''ifdef : IF expr block ELSE block'''
    p[0] = nodes.Branch(p, p[3], p[5])


def p_function_expression(p):
    '''
    function : '(' ')'
             | '(' expr ')'
    '''
    if len(p) == 4:
        p[0] = p[2]


def p_leaf(p):
    '''
    expr : ID
         | NUMBER
         | STRING
    '''
    p[0] = nodes.Leaf(p, p[1])


def p_function(p):
    '''
    expr : function
    '''
    p[0] = p[1]


def p_bool_expression(p):
    '''expr : expr '>' expr
            | expr '<' expr
            | expr EQ expr
            | expr NEQ expr
            | expr LT_EQ expr
            | expr GT_EQ expr

            | expr AND expr
            | expr OR  expr
    '''
    p[0] = nodes.BooleanExpression(p, p[2], p[1], p[3])


def p_operand_expression(p):
    '''expr : expr '+' expr
            | expr '-' expr
            | expr '*' expr
            | expr '/' expr
    '''
    p[0] = nodes.OperandExpression(p, p[2], p[1], p[3])


def p_unary_minus_expression(p):
    '''expr : '-' ID %prec UMINUS
            | '-' NUMBER %prec UMINUS
    '''
    p[0] = nodes.UnaryExpression(p, p[2], 'MIN')


def p_not_expression(p):
    '''expr : '!' ID %prec NOT'''
    p[0] = nodes.UnaryExpression(p, p[2], 'NOT')


def p_error(p):
    raise ParseError(p)


class Parser:
    def __init__(self, debug=False):
        self.debug  = debug
        self.parser = ply.yacc.yacc()

    def parse(self, text=None):
        self.lexer = Lexer()

        if text.strip():
            return self.parser.parse(text, debug=self.debug)

        return []
