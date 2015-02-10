grammar KLQ;

questionaire
    : question+
    ;

question
    : 'question' NEWLINE specification* end
    ;


end : 'end'
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

String
    : '"' StringCharacter* '"'
    ;

Number
    : Int
    | Decimal
    ;

answer
    : expr
    | Number
    | String
    ;

expr
    : expr ( '*' | '/' ) expr
    | expr ( '+' | '-' ) expr
    | Number
    |'(' expr ')'
    ;

answers
    :   answer (', ' answer)*
    ;


fragment StringCharacter
    : ~[\\"]                    //TODO define possible Escape things.
    ;

questionType
    : 'set'
    | 'boolean'
    | 'date'
    | 'currency'
    | 'string'
    | 'numeral'
    ;

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

ADD : '+' ;
SUB : '-' ;
MUL : '*' ;
DIV : '/' ;

QuestionId
    : Letter LetterOrDigit*
    ;

Int : Digit+
    ;

Decimal
    : Digit+ '.' Digit*
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