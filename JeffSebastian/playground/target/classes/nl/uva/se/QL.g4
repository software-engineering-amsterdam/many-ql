grammar QL;

options {
	language = Java;
	output = AST;
}

@lexer::header {
	package nl.uva.se.parsers;
}

@parser::header {
	package nl.uva.se.parsers;
}

expression : SALUTATION ENDSYMBOL;

SALUTATION:'Hello word';  
ENDSYMBOL:'!';