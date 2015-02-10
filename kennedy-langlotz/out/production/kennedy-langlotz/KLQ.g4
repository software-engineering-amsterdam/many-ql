grammar KLQ;

//Keywords
PAGE        : 'page' ;
SECTION     : 'section' ;
QUESTION    : 'question' ;
END         : 'end' ;
ID          : 'id' ;
TYPE        : 'type' ;
VALUE       : 'value' ;
TEXT        : 'text' ;
REQUIRES    : 'requires' ;
ONLY        : 'only' ;
SET         : 'set' ;
BOOLEAN     : 'boolean' ;
DATE        : 'date' ;
CURRENCY    : 'currency' ;
STRING      : 'string' ;
NUMERAL     : 'numeral' ;
TODAY       : 'today' ;
NOW         : 'now' ;
ANSWER      : 'answer' ;

//Operators
ADD : '+' ;
SUB : '-' ;
MUL : '*' ;
DIV : '/' ;
G   : '>' ;
L   : '<' ;
GT  : '>=' ;
LT  : '<=' ;

questionaire
    : question+
    ;

question
    : questionBegin specification+ questionEnd
    ;

questionBegin
    : 'question' NEWLINE
    ;

questionEnd :
    'end'
        ( NEWLINE+
        | EOF
        )
    ;

specification
    :
    ( 'id'       ':' QuestionId
    | 'type'     ':' questionType
    | 'value'    ':' answers        //optional
    | 'text'     ':' String         //optional
    | 'requires' ':' QuestionId     //optional
    | 'only'     ':' answers        //optional, for *requires*
    ) NEWLINE
    ;

QuestionId
    : Letter LetterOrDigit*
    ;

questionType
    : 'set'
    | 'boolean'
    | 'date'
    | 'currency'
    | 'string'
    | 'numeral'
    ;


String
    : '"' StringCharacter* '"'
    ;

Number
    : Int
    | Decimal
    ;
Date
    : Int ( '.' | '-' | '/' ) Int ( '.' | '-' | '/' ) Int?
    | 'today'
    ;

Time
    : Int ( '.' | '-' | ':' ) Int
    | 'now'
    ;

answer
    : expr
    | Number
    | String
    ;

expr
    : expr ( '*' | '/' ) expr
    | expr ( '+' | '-' ) expr
    | expr ( '>=' | '>' | L | LT ) expr
    | Number
    | Date
    | String
    | 'answer'
    |'(' expr ')'
    ;

answers
    : answer (', ' answer)*
    ;

Int : Digit+
    ;

Decimal
    : Digit+ '.' Digit*
    ;



fragment StringCharacter
    : ~[\\"]                    //TODO define possible Escape things.
    ;

fragment Letter
    : [a-zA-Z]
    ;

fragment LetterOrDigit
    : [a-zA-Z0-9]
    ;

fragment Digit
    : [0-9]
    ;

//New lines
NEWLINE
    : '\r'? '\n' | '\f'
    ;

// Whitespace and comments
WS  : [ \t]+ -> skip
    ;

COMMENT
    : '/*' .*? '*/' -> skip
    ;

LINE_COMMENT
    : '//' ~[\r\n]* -> skip
    ;