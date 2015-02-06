grammar KLQ;

file :
    group+
    ;

group
    :
    groupBegin options+ END NEWLINE+
    ;

options
    : id
    | type
    | value     //optional
    | text      //optional
    | requires  //optional
    | only      //optional, for *Requires*
    ;

questionType
    : RADIO
    | BOOLEAN
    | DATE
    | CURRENCY
    | DROPDOWN
    | STRING
    | NUMERAL
    ;

groupBegin
    : PAGE
    | SECTION
    | QUESTION
    | QUESTIONS
    ;

id
    : ID ':' QuestionId NEWLINE
    ;

text
    : TEXT ':' [^\n]+ NEWLINE
    ;

type
    : TYPE ':' questionType NEWLINE
    ;

value
    : VALUE ':' answers NEWLINE
    ;

requires
    : REQUIRES ':' questionId NEWLINE
    ;

only
    : ONLY ':' [^\n\r]+ NEWLINE
    ;

questionId
    : letter letterOrDigit*
    ;

//Keywords
PAGE        : 'page' ;
SECTION     : 'section' ;
QUESTION    : 'question' ;
QUESTIONS   : 'questions' ;
END         : 'end' ;

ID          : 'id' ;
TEXT        : 'text' ;
TYPE        : 'type' ;
VALUE       : 'value' ;
REQUIRES    : 'requires' ;
ONLY        : 'only' ;

RADIO       : 'radio' ;
BOOLEAN     : 'boolean' ;
DATE        : 'date' ;
CURRENCY    : 'currency' ;
DROPDOWN    : 'dropdown' ;
STRING      : 'string' ;
NUMERAL     : 'numeral' ;

fragment letter
    : [a-zA-Z]
    ;

fragment letterOrDigit
    : [a-zA-Z0-9]
    ;

fragment digit
    : [0-9]
    ;

answers
    : [^,] (',' [^,])*
    ;

// Whitespace and comments
NEWLINE
    : '\r' '\n' | '\n' | '\r' | '\f'
    ;

WS  : [\t\r]+ -> skip
    ;

COMMENT
    : '/*' .*? '*/' -> skip
    ;

LINE_COMMENT
    : '//' ~[\r\n]* -> skip
    ;