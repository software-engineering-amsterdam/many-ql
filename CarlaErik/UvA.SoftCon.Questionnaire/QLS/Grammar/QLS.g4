/** Grammars always start with a grammar header. This grammar is called
*   QLS and must match the filename: QLS.g4
*/
grammar QLS;

//Rules

StyleSheet: 'stylesheet' STRING Page;									    
Page:		'page' STRING '{' Section | Default '}';
Section:	'section "' STRING '" {' Question | Section'}';     // who works with definition of STRING itself and the ""? STRING : '"' (ESC|.)*? '"' ;       // match anything in "..." (nongreedy)
Question:	'question' STRING  Defaultproperties | Widget;
Widget:		'widget' STRING('(' STRING+ | INT | BOOL ')')?;		// all default values for widget properties
Default:	'default' TYPE (Widget)?;
Defaultproperties: Default	'{'
							'width:'	INT
							'font:'		STRING
							'fontsize:' INT
							'color:'	HEXACOLOR
							Widget								// I am not sure, but if is one of the other one, in both cases there is a widget link to question
							'}'
							;
/*
 *   Lexer Rules
 */

 HEXACOLOR : '#' DIGIT+;										// of better by ql?


 // Copied from ql, is there other way?
INT    : '-'? DIGIT+ ;             
BOOL   : 'true' | 'false' ;  
STRING : '"' (ESC|.)*? '"' ;       
DIGIT  : [0-9] ;
LETTER : [a-zA-Z] ;
ESC    : '\\"' | '\\\\' ;

TYPE : 'int' | 'string' | 'bool' | 'date';