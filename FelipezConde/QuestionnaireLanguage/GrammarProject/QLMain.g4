grammar QLMain;

form : 'form' formsection
     ;

formsection : '{' formElem* '}'
            ;

formElem : question
         | field
         | conditional
         ;

question : 'question' id typeName keyValPairs
         ;
        
field : 'field' id typeName keyValPairs
      ;
 

// id ////////////////////////////////////////////////
 
id : ALPHANUMERIC 
   ;

// type /////////////////////////////////////////////
 
          
// (Do we want to generalize this so people can create own types?)
typeName : 'bool'
     | 'string'
     | 'date'
     | 'int'
     | 'decimal'
     | 'money'
     ;

value : type
      | expression
      ;

type : bool
      |STRING
      |date
      |num
      |list
      ;

date   : 'date(' YEAR '.' MONTH '.' DAY ')'
       | 'date(' YEAR '.' MONTH ')' 
       | 'date(' YEAR ')'
       ;


num : INT
    | DECIMAL
    | MONEY
    ;

list : '[' (type (',' type )*)? ']';
 
// keyValPairs //////////////////////////////////////
    
keyValPairs : '{' keyValPair (',' keyValPair)* '}'
            ;

keyValPair : key '=' val
           ;

key : ALPHANUMERIC;
val : value;

// conditional //////////////////////////////////////

// this grammatical formulation allows for nested conditionals. do we want this ?
conditional : 'enable when' expression formsection
            ;

expression : '(' expression ')'
           | bool
           | id
           |'!' expression
           | expression '&&' expression
           | expression '||' expression 
           | expression ('!=' | '==') expression
           | arithmetic
           ;

bool : 'True'
     | 'False'
     ;

comparison :
    | '(' comparison ')'
    | arithmetic ('>' | '<' | '>=' | '<=') arithmetic
    | expression ('!=' | '==') expression
    ;

arithmetic :
    | '(' arithmetic ')'
    | arithmetic ('>' | '<' | '>=' | '<=') arithmetic
    | arithmetic ('*'|'/') arithmetic 
    | arithmetic ('-'|'+') arithmetic
    | id
    | num
    ;

//Lexer rules
INT     : [0-9]+;
DECIMAL : [0-9]+ ',' [0-9];
MONEY   : [0-9]+ ',' [0-9];

YEAR  : [0-9];
MONTH : [0-9];
DAY   : [0-9];

//STRING : '"' ( ~( '"' | '\\' ) | '\\' . )* '"';
STRING : '"' .*? '"';
ALPHANUMERIC : [a-zA-Z0-9]+;

WS : (' ' | '\r' | '\n') -> channel(HIDDEN);

BLOCK_COMMENT : '/*' .*? '*/' -> channel(HIDDEN);

LINE_COMMENT : '--' ~[\r\n]* -> channel(HIDDEN);