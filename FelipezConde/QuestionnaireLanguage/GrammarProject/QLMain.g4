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
 
id : alphaNumeric+
   ;
   
alphaNumeric : [a-zA-Z0-9]
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
             
value : bool
      | string
      | date 
      | num
      ;
     
bool : 'True'
     | 'False'
     ;
     
BOOL : [True|False];     

string : '"' [A-z]* '"'
       ;
 
date   : 'date(' year '.' month '.' day ')'
       | 'date(' year '.' month ')' 
       | 'date(' year ')'
       ;

year  : [0-9]{4, };
month : [0-9]{1,2};
day   : [0-9]{1,2};
       
num : INT 
    | DECIMAL 
    | MONEY
    ;

INT     : [0-9]+;
DECIMAL : [0-9]+ ',' [0-9]{1};
MONEY   : [0-9]+ ',' [0-9]{2};
 
// keyValPairs //////////////////////////////////////    
    
keyValPairs : '{' keyValPair (',' keyValPair)* '}'
            ;
              
keyValPair : type key ':' val     
           ;

key : alphaNumeric+;
val : type;

// conditional //////////////////////////////////////     
   
// this grammatical formulation allows for nested conditionals. do we want this ?   
conditional : 'enable when' expresion formsection
            ;
            
expression : boolean
           | comparison
           | arithmetic
           ;
           
boolean : '(' boolean ')'
        | bool
        | '!' boolean
        | boolean '&&' boolean
        | boolean '||' boolean 
        | id 
        | comparison 
        ;
        
comparison :
    | '(' comparison ')'
    | arithmetic ('>' | '<' | '>=' | '<=') arithmetic
    | expression ('!=' | '==') expression  
    ;
    
arithmetic :
    | '(' arithmetic ')'
    | arithmetic ('*'|'/'|'-'|'+') arithmetic
    | num
    | id 
    ;
