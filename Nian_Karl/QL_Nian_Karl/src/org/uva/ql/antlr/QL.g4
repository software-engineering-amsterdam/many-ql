grammar QL;


@parser::header
{
package org.uva.sea.ql.parser.antlr;
import org.uva.sea.ql.ast.expr.*;
import org.uva.sea.ql.ast.stat.*;
import org.uva.sea.ql.ast.form.*;
}

@lexer::header
{
package org.uva.sea.ql.parser.antlr;
}

form : (question)+;

question: Ident Str QuestionType;

QuestionType :[INT | STR | CUR | BOOL];
	
WS  :	(' ' | '\t' | '\n' | '\r') -> channel(HIDDEN);

COMMENT : '/*' .*? '*/' -> channel(HIDDEN);

Bool: [TRUE | FALSE];

Ident: [a-zA-Z][a-zA-Z0-9_]*;

Int: [0-9]+;

Str: '"' .*? '"';

Float: Int'.'Int;

//Date: ('0');
//
//Float: ('0');
//
//Cur: ('0');

/* TOKENS */
INT:			'Int';
STR:			'Str';
CUR:			'Cur';
BOOL:			'Bool';
TRUE: 			'true';
FALSE: 			'false';
IF: 			'if';
GREATER: 		'>';
EQUAL_GREATER: 	'>='; 
EQUAL: 			'==';
EQUAL_SMALLER: 	'<=';
SMALLER: 		'<';
LEFT_BRACES:	'{';
RIGHT_BRACES:	'}';
LEFT_PARENTHESES:	'(';
RIGHT_PARENTHESES:	')';

