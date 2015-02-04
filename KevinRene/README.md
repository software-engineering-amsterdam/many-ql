# Software construction

Hi there, thank you for traveling with KevinRene. During your flight you're free to enjoy our delicious recycled beverages, meals made of roadkill, and some weird ass games.

In case of emergency please headbutt your neighbor, take a chill pill, and drop dat beat.

We hope you have a pleasant flight.

~ Jesus and Buddha

![Our plane](http://www.studentsoftheworld.info/sites/misc/img/28740_weird-plane[1].jpg)


## QL

### Grammar


top : expr { result = $1; };

form : FORM IDENTIFIER 

question : IDENTIFIER ':' type '{' STRINGLITERAL '}' 
		 | IDENTIFIER ':' type '{' STRINGLITERAL assignment '}'
		 ;

assignment : 'assign(' expr ')'
		   ;

expr : '+' expr	%prec UPLUS { $$ = new Pos($2); }
	 | '-' expr	%prec UMIN  { $$ = new Neg($2); }
	 | '!' expr %prec UNOT  { $$ = new Not($2); }
	 | expr '*' expr		{ $$ = new Mul($1, $3); }
	 | expr '/' expr 		{ $$ = new Div($1, $3); }
	 | expr '+' expr		{ $$ = new Add($1, $3); }
	 | expr '-' expr		{ $$ = new Sub($1, $3); }
	 | expr EQ expr		    { $$ = new Eq($1, $3); }
	 | expr NEQ expr		{ $$ = new NEq($1, $3); }
	 | expr '>' expr		{ $$ = new GT($1, $3); }
	 | expr '<' expr		{ $$ = new LT($1, $3); }
	 | expr GEQ expr		{ $$ = new GEq($1, $3); }
	 | expr LEQ expr		{ $$ = new LEq($1, $3); }
	 | expr AND expr	    { $$ = new And($1, $3); }
	 | expr OR expr  		{ $$ = new Or($1, $3); }
	 | INT					{ $$ = $1; }
	 | IDENT         		{ $$ = $1; }
	 | '(' expr ')'			{ $$ = $2; }
	 ;

### Examples

form taxOfficeExample { 
	hasSoldHouse: boolean {
		"Did you sell a house in 2010?"
	}
	hasBoughtHouse: boolean {
		"Did you buy a house in 2010?"
	}
	hasMaintLoan: boolean {
		"Did you enter a loan?"
	}
	

	if (hasSoldHouse) {
		sellingPrice: money {
			"What was the selling price?"
		}
		privateDebt: money {
			"Private debts for the sold house:"	
		}

		valueResidue: money {
			"Value residue:"
			assign(sellingPrice - privateDebt)
		}
	}
}