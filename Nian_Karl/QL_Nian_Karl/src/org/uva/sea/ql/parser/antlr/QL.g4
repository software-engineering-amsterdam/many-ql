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

QuestionType :('Int' | 'Str' | 'Cur' | 'Bool');
	
WS  :	(' ' | '\t' | '\n' | '\r') -> channel(HIDDEN) 
    ;

COMMENT 
     : '/*' .*? '*/' -> channel(HIDDEN)
     ;

Bool: ['true' | 'false'];

Ident: [a-zA-Z][a-zA-Z0-9_]*;

Int: [0-9]+;

Str: '"' .*? '"';

//Date: ('0');
//
//Float: ('0');
//
//Cur: ('0');
