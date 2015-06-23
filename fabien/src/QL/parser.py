
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
             | STRING ID ':' TYPE WIDGET
             | STRING TYPE WIDGET
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
             | '(' leaf ')'
    '''
    if len(p) == 4:
        p[0] = p[2]


def p_ID(p):
    '''
    leaf : ID
    '''
    p[0] = nodes.ID(p, p[1])


def p_String(p):
    '''
    leaf : STRING
    '''
    p[0] = nodes.String(p, p[1])


def p_Number(p):
    '''
    leaf : NUMBER
    '''
    p[0] = nodes.Number(p, p[1])


def p_Boolean(p):
    '''
    leaf : BOOL
    '''
    p[0] = nodes.Boolean(p, p[1])


def p_function(p):
    '''
    expr : leaf
         | function
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
    '''expr : '!' ID %prec NOT
            | '!' expr %prec NOT
    '''
    p[0] = nodes.UnaryExpression(p, p[2], 'NOT')


def p_error(p):
    raise ParseError(p)

class Parser:
    def __init__(self, debug=False):
        self.debug  = debug
        self.parser = ply.yacc.yacc()

        self.errors = []

    def parse(self, text=None):
        self.errors = []
        self.lexer  = Lexer()

        try:
            return self.parser.parse(text.strip(), debug=self.debug)
        except ParseError as err:
            self.errors.append(err)

        return None

    @property
    def hasErrors(self):
        return len(self.errors) > 0

    def getErrorMessages(self):
        return [str(err) for err in self.errors]
