class RJSON::Parser2
  token STRING INTEGER BOOLEAN
  rule
    document
      : forms
      ;
    forms
      : forms whitespace form
      | form
      ;
    form
      : 'form' whitespace '{' statements '}'
      ;
    statements
      : statements whitespace statement
      | statement
      ;
    statement
      : /"(.*)"/ 
      ;
    opening_bracket
      : whitespace '{' whitespace
      ;
    closing_bracket
      : whitespace '}' whitespace
      ;
    whitespace
      : [ \t\n]*
      ;
    statement
      : conditional
      | query
      ;
    condittional
      : if (else | "")
      ;
    if
      : space 'if' whitespace variable opening_bracket statements closing_bracket
      ;
    else
      : whitespace 'else' opening_bracket statement closing_bracket
      ;
    query
      : whitespace text opening_bracket answers closing_braket
      ;
    answers
      : answers whitespace statement
      | answer
      ;
    answer
      : variable ":" whitespace type
      ;
    type
      : 'integer' 
      | 'boolean' 
      | 'string'
      ;
    variable
      : [a-zA-Z?_]+
      ;
    rule text
      : /"(.*)"/
      ;
end

