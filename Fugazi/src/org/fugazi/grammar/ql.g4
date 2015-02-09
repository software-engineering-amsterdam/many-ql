grammar ql;

// TODO describe each statement with a comment
// TODO put all the comments either above or to the right - be consistent

// complete form - topmost node
form: 'form' ID '{' stat+ '}';


stat : question
     | ifstat
     | NEWLINE
     ;

ifstat : 'if' '(' expr ')' '{' question+ '}';

expr: ID        // A boolean variable.
    | LOGICAL_EXPORESSION expr
    | ID LOGICAL_EXPORESSION expr
    | '(' expr ')'  // this supports nested expressions even though every
                    //nested logical statement can be translated into a one-level statement
    ;

// single expression form
question: type ID '(' WORD ')' ';'
        | type ID '(' WORD ')' ASSIGN assignee ';'
        ;

type: 'bool'
    | value
    ;

value : ID
      | INT
      | FLOAT
      ;

// allowed assignable expressions
assignee    : value
            | value ARITHMETIC_EXPRESSION value;

ARITHMETIC_EXPRESSION   : MUL
                        | DIV
                        | ADD
                        | SUB;

MUL     :   '*' ;
DIV     :   '/' ;
ADD     :   '+' ;
SUB     :   '-' ;
ASSIGN  :   '=' ;

LOGICAL_EXPORESSION     : AND | OR | NOT
                        | LT | LE | ST | SE| EQ | NE;

AND : '&&';
OR  : '||';
NOT : '!';
LT  : '>';
LE  : '>=';
ST  : '<';
SE  : '<=';
EQ  : '==';
NE  : '!=';

ID  :   [a-zA-Z]+;      // match identifiers

WORD :  '"' (ESC | ~["\\])* '"' ;

BOOLEAN: ["true"|"false"];

INT : DIGIT+ ;              // match integers

FLOAT : DIGIT+ '.' DIGIT*   // match 1. 39. 3.14159 etc...
      | '.' DIGIT+          // match .1 .14159
      ;

NEWLINE :'\r'? '\n' ;     // return newlines to parser (is end-statement signal)

COMMENT
    :   '/*' .*? '*/'    -> channel(HIDDEN) // match anything between /* and */
    ;

WS  :   [ \r\t\u000C\n]+ -> channel(HIDDEN)
    ;

LINE_COMMENT
    : '//' ~[\r\n]* '\r'? '\n' -> channel(HIDDEN)
    ;

fragment ESC :   '\\' (["\\/bfnrt] | UNICODE) ;
fragment UNICODE : 'u' HEX HEX HEX HEX ;
fragment HEX : [0-9a-fA-F] ;
fragment DIGIT   : [0-9] ; // match single digit