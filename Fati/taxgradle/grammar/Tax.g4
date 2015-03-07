grammar Tax;

@header {
package org.tax.taxgen;
}
import Common;

prog: (questionnaire NEWLINE*)*;

questionnaire : FORMTAG  variable LBRA  (questionlist | ifquestionlist)*  RBRA;

questionlist : ( question )+;

bracketedquestionlist  : LBRA  questionlist  RBRA;
ifquestionlist : IFTAG  LPAR  variable  RPAR   bracketedquestionlist;

question :  variable  ':'  questionStatement  type;

questionStatement 
       : STRING ;


type : primitiveType  (LPAR expression RPAR)? | enumeration  | range;

primitiveType : PRIMITIVETYPE;

enumeration : LBRA  enumItem   (','  enumItem)*  RBRA ;
enumItem : .*?;

expression : (LPAR .*? RPAR) | .*?;


STRING : '"' ( '\\' [\\"] | ~[\\"\r\n] )* '"';


range :
	INT '..' INT  ;

date :
   DIGIT DIGIT '-' DIGIT DIGIT '-' DIGIT DIGIT
   ;
   
PRIMITIVETYPE :   
            'boolean'
        |   'string'
        |   'integer'
        |   'date'
        |   'decimal'
        |   'money'
        ;
        

FORMTAG : 'form';
IFTAG : 'if';
WS  :  [ \t\r\n]+ -> skip;
COMMENT
    :   '/*' .*? '*/' -> skip
    ;