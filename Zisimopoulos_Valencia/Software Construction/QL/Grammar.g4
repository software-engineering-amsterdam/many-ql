grammar Grammar;

@lexer::header	{ package antlr; }
@parser::header { package antlr; }

parse
 : block EOF
 ;

block
 : stat*
 ;

stat
 : assignment
 | if_stat
 | while_stat
 | log
 | OTHER {System.err.println("unknown char: " + $OTHER.text);}
 ;

assignment
 : ID '=' expr ';'
 ;

if_stat
 : IF condition_block (ELSE IF condition_block)* (ELSE stat_block)?
 ;

condition_block
 : expr stat_block
 ;

stat_block
 : '{' block '}'
 | stat
 ;

while_stat
 : WHILE expr stat_block
 ;

log
 : LOG expr ';'
 ;

expr
 : expr '^'<assoc=right> expr           	#powExpr
 | '-' expr                           		#unaryMinusExpr
 | '!' expr                             	#notExpr
 | expr op=('*' | '/' | '%') expr      		#multiplicationExpr
 | expr op=('+' | '-') expr          		#additiveExpr
 | expr op=('<=' | '>=' | '<' | '>') expr 	#relationalExpr
 | expr op=('==' | '!=') expr              	#equalityExpr
 | expr '&&' expr                       	#andExpr
 | expr '||' expr                         	#orExpr
 | atom                                 	#atomExpr
 ;

atom
 : '(' expr ')' #parExpr
 | (INT | FLOAT)  #numberAtom
 | (TRUE | FALSE) #booleanAtom
 | ID             #idAtom
 | STRING         #stringAtom
 ;


TRUE : 'true' | 'TRUE' | 'True';
FALSE : 'false' | 'FALSE' | 'false' ;
IF : 'if';
ELSE : 'else';
WHILE : 'while';
LOG : 'log';

ID
 : [a-zA-Z_] [a-zA-Z_0-9]*
 ;

INT
 : [0-9]+
 ;

FLOAT
 : [0-9]+ '.' [0-9]* 
 | '.' [0-9]+
 ;

STRING
 : '"' (~["\r\n] | '""')* '"'
 ;

COMMENT
 : ('//' ~[\r\n]*
 | '/*' .* '*/') -> channel(HIDDEN)
 ;

WS : [ \t\r\n]+ -> skip ; // skip spaces, tabs, newlines

OTHER
 : . 
 ;