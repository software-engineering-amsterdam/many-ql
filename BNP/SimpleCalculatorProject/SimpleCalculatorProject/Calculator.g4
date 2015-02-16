grammar Calculator;
// copied from http://programming-pages.com/2013/12/14/antlr-4-with-c-and-visual-studio-2012/
@parser::members
{
    protected const int EOF = Eof;
}
 
@lexer::members
{
    protected const int EOF = Eof;
    protected const int HIDDEN = Hidden;
}
 
/*
 * Parser Rules
 */
 
prog: expr+ ;
 
expr : expr op=('*'|'/') expr   # MulDiv
     | expr op=('+'|'-') expr   # AddSub
     | INT                  # int
     | '(' expr ')'         # parens
     ;
 
/*
 * Lexer Rules
 */
INT : [0-9]+;
MUL : '*';
DIV : '/';
ADD : '+';
SUB : '-';
WS
    :   (' ' | '\r' | '\n') -> channel(HIDDEN)
    ;