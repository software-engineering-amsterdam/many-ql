grammar QLMain;     
    
form : 'form' formsection
     ;

formsection : '{' formElem* '}'
            ;

formElem : question
         | field
         | conditional
         ;

question : 'question' id type keyValPairs
         ;
        
field : 'field' id type keyValPairs
      ;
 

// id ////////////////////////////////////////////////
 
id : ALPHANUMERIC+
   ;
   

// type /////////////////////////////////////////////
 
          
// (Do we want to generalize this so people can create own types?)
type : 'bool'
     | 'string'
     | 'date'
     | 'int'
     | 'decimal'
     | 'money'
     ;
             
value : BOOL
      | STRING
      | date 
      | num
      ;

date   : 'date(' YEAR '.' MONTH '.' DAY ')'
       | 'date(' YEAR '.' MONTH ')' 
       | 'date(' YEAR ')'
       ;


num : INT
    | DECIMAL
    | MONEY
    ;


 
// keyValPairs //////////////////////////////////////
    
keyValPairs : '{' keyValPair (',' keyValPair)* '}'
            ;
              
keyValPair : type key ':' val
           ;

key : ALPHANUMERIC+;
val : value;

// conditional //////////////////////////////////////

// this grammatical formulation allows for nested conditionals. do we want this ?
conditional : 'enable when' expression formsection
            ;

expression : boolean
           | comparison
           | arithmetic
           ;

boolean : '(' boolean ')'
        | BOOL
        | '!' boolean
        | boolean '&&' boolean
        | boolean '||' boolean 
        | comparison
        | id
        ;

comparison :
    | '(' comparison ')'
    | arithmetic ('>' | '<' | '>=' | '<=') arithmetic
    | expression ('!=' | '==') expression
    ;

arithmetic :
    | '(' arithmetic ')'
    | arithmetic ('*'|'/'|'-'|'+') arithmetic
    | id
    | num
    ;

//Lexer rules
BOOL : [True|False];

INT     : [0-9]+;
DECIMAL : [0-9]+ ',' [0-9];
MONEY   : [0-9]+ ',' [0-9];

YEAR  : [0-9];
MONTH : [0-9];
DAY   : [0-9];

STRING : '"' [A-z]* '"';
ALPHANUMERIC : [a-zA-Z0-9];