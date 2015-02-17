grammar QLMain;

/* Form Structure */

 form           : 'form' formSection
;formSection    : '{' formObject* '}' 
;formObject     : formElement
                | conditional
;formElement    : 'question' id typeName keyValuePairs
; conditional   : 'enable when' expression formSection
;

/* Types */ 
 typeName          : genericTypeName
                   | primitiveTypeName
;genericTypeName   : 'list[' primitiveTypeName ']'
;primitiveTypeName : 'bool'
                   | 'string'
                   | 'date'
                   | 'int'
                   | 'decimal'
                   | 'money'
;value             : type
                   | expression
;type              : bool
                   | string
                   | date
                   | num
                   | list
;bool              : 'True'
                   | 'False'
;date              : 'date(' year '/' month '/' day ')'
                   | 'date(' year '/' month')' 
                   | 'date(' year ')'
;num               : int
                   | money
                   | decimal
;list              : '[' (type (',' type )*)? ']'
;

/* Literal Types*/
 year           : YEAR 
;month          : MONTH
;day            : DAY
;string         : STRING
;int            : INT
;decimal        : DECIMAL
;money          : MONEY
;id             : ALPHANUMERIC
;

/* KeyValPairs */   
 keyValuePairs  : '{' keyValuePair (',' keyValuePair)* '}'
;keyValuePair   : key '=' value
;key            : ALPHANUMERIC
;

/* Expression & arithmetic */
 expression     : '(' expression ')'
                | bool
                | id
                |'!' expression
                | expression '&&' expression
                | expression '||' expression 
                | expression ( '!=' | '==' ) expression
                | comparison

;comparison     : '(' comparison ')' 
                | arithmetic ( '>' | '<' | '>=' | '<=' ) arithmetic

;arithmetic     : '(' arithmetic ')'
                | arithmetic ( '*' | '/' ) arithmetic 
                | arithmetic ( '-' | '+' ) arithmetic
                | id
                | num
                ;

/*Lexer rules*/
INT     : '-'?[0-9]+;
DECIMAL : '-'?[0-9]+ '.' [0-9]+;
MONEY   : '-'?[0-9]+ '.' [0-9][0-9];

YEAR  : [0-9]+;
MONTH : [0-9][0-9];
DAY   : [0-9][0-9];

ALPHANUMERIC : [a-zA-Z0-9]+;
STRING : '"' .*? '"';

/* White Space & Comments */
 WS             : (' ' | '\r' | '\n') -> channel(HIDDEN)
;BLOCK_COMMENT  : '/*' .*? '*/'       -> channel(HIDDEN)
;LINE_COMMENT   : '--' ~[\r\n]*       -> channel(HIDDEN)
;