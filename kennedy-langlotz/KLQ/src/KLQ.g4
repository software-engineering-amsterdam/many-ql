grammar KLQ;

//Keywords
QUESTION    : 'question' ;
END         : 'end' ;
ID          : 'id' ;
TEXT        : 'text' ;
TYPE        : 'type' ;
VALUE       : 'value' ;

BOOLEAN     : 'boolean' ;
DATE        : 'date' ;
STRING      : 'string' ;
NUMERAL     : 'numeral' ;

IF          : 'if' ;
THEN        : 'then' ;

//Operators
ADD : '+' ;
SUB : '-' ;
MUL : '*' ;
DIV : '/' ;
GT  : '>' ;
LT  : '<' ;
GE  : '>=' ;
LE  : '<=' ;
EQ  : '==' ;
NEQ : '!=' ;
AND : '&&' ;
OR  : '||' ;

questionnaire
    : question+
    ;

question
    : uncondQuestion
    | condQuestion
    ;

condQuestion
    : 'if' expr 'then' NEWLINE question+ End
    ;

uncondQuestion
    : 'question' NEWLINE
          'id'       ':' id=QuestionId      NEWLINE
          'text'     ':' text=String        NEWLINE
          'type'     ':' type=questionType  NEWLINE
         ('value'    ':' expr               NEWLINE)?
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
    : 'boolean'
    | 'date'
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
    : Int ( '.' | '-' | '/' ) Int ( '.' | '-' | '/' ) Int
    ;

expr
    : expr operator=( '*' | '/' ) expr #MulDiv
    | expr operator=( '+' | '-' ) expr #AddSub
    | expr operator=( '>=' | '>' | '<=' | '<' | '==' | '!=' ) expr #Comparators
    | expr '&&'  expr #And
    | expr '||' expr #Or
    | '(' expr ')' #Parens
    | Number #Number
    | Date #Date
    | String #String
    | QuestionId #id
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