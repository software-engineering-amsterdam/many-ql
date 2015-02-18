grammar Ql;

form : 'form' ID '{' (question '\n'?)* (ifBlock '\n'?)* '}' ;
question : ID ':' label type (expr?) ;
ifBlock: IF '(' expr ')' '{' '}';

ID : [a-zA-Z_] [a-zA-Z_0-9]*;

label : STRING;

type : BOOLEAN
	 | STRING
	 | INTEGER
	 | DATE
	 | DECIMAL
	 | MONEY
	 ;
	 	
expr : ID
	 | '(' expr ')' 
	 | expr LOGIC expr
	 | '!' expr
	 | expr COMPARISON expr
	 | expr ARITHMETIC expr
	 ;
	 
IF : 'if';
 
BOOLEAN : TRUE
		| FALSE
		;
		
TRUE : 'TRUE'
	 | 'true'
	 ;

FALSE : 'FALSE'
	  | 'false';
				
STRING: '"' (ESC|.)*? '"' ;
fragment
ESC : '\\"' | '\\\\' ; // 2-char sequences \" and \\

INTEGER : '-'?['0-9']+;		  
DECIMAL: INTEGER'.'['0-9']+ ;
DATE: ;	  
MONEY : 'money';

LOGIC : '&&'
	  | '||'
	  | '!='
	  ;
	  	  	 	 
COMPARISON: '<'
		 	'>'
		 	'>='
		 	'<='
		 	'!='
		 	'==' 
		 	;
		 	
ARITHMETIC: '/'
			'*'
			'+'
			'-'	
 			;