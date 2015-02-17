grammar KLQ;

//Keywords
QUESTION    : 'question' ;
END         : 'end' ;
ID          : 'id' ;
TEXT        : 'text' ;
TYPE        : 'type' ;
VALUE       : 'value' ;

SET         : 'set' ;
BOOLEAN     : 'boolean' ;
DATE        : 'date' ;
CURRENCY    : 'currency' ;
STRING      : 'string' ;
NUMERAL     : 'numeral' ;
ANSWER      : 'answer' ;

IF          : 'if' ;
THEN        : 'then' ;

//Operators
ADD : '+' ;
SUB : '-' ;
MUL : '*' ;
DIV : '/' ;
G   : '>' ;
L   : '<' ;
GT  : '>=' ;
LT  : '<=' ;
AND : '&&' ;
OR  : '||' ;

questionnaire
    :
    ( condQuestion
    | question
    )*
    ;

condQuestion
    : 'if' expr 'then' NEWLINE
    ( condQuestion
    | question
    ) End
    ;

question
    : 'question' NEWLINE
          'id'       ':' id=QuestionId      NEWLINE
          'text'     ':' String             NEWLINE
          'type'     ':' type=questionType  NEWLINE
         ('value'    ':' answerSet          NEWLINE)?
      End
    ;

End :
    'end'
        ( NEWLINE+
        | EOF
        )
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
    ;

Time
    : Int ( '.' | '-' | ':' ) Int
    ;

expr
    : expr ( '*' | '/' ) expr
    | expr ( '+' | '-' ) expr
    | expr ( '>=' | '>' | '<=' | '<' ) expr
    | expr '&&'  expr
    | expr '||' expr
    | '(' expr ')'
    | Number
    | Date
    | String
    | QuestionId
    ;

answerSet
    : expr (', ' expr)*
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