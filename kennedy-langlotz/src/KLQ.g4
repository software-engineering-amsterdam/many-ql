grammar KLQ;

questionaire
    : group+
    ;

group
    : groupBegin specification+ groupEnd NEWLINE+
    ;

groupBegin
    : 'page'
    | 'section'
    | 'questions'
    | 'question'
    ;

groupEnd
    : 'end'
    ;

specification
    :   (   'id'        ':' QuestionId
        |   'type'      ':' questionType
        |   'value'     ':' Answers     //optional
        |   'text'      ':' NONEWLINE   //optional
        |   'requires'  ':' QuestionId  //optional
        |   'only'      ':' Answers     //optional, for *Requires*
        )   NEWLINE
    ;

QuestionId
    : Letter LetterOrDigit*
    ;

Letter
    : [a-zA-Z]
    ;

LetterOrDigit
    : [a-zA-Z0-9]
    ;

Digit
    : [0-9]
    ;

questionType
    : 'radio'
    | 'boolean'
    | 'date'
    | 'currency'
    | 'dropdown'
    | 'string'
    | 'numeral'
    ;

Answers
    : [^,] (',' [^,])*
    ;

//New lines
NEWLINE
    : '\r'? '\n' | '\n' | '\r' | '\f'
    ;

NONEWLINE
    : [^\n]+
    ;

// Whitespace and comments
WS  : [\t]+ -> skip
    ;

COMMENT
    : '/*' .*? '*/' -> skip
    ;

LINE_COMMENT
    : '//' ~[\r\n]* -> skip
    ;