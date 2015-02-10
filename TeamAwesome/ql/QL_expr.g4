grammar QL_expr;

expr
    :   '(' expr ')'
    |   ('+' | '-' | '!') expr
    |   expr '^' expr
    |   expr ('*' | '/' | '%') expr
    |   expr ('+' | '-') expr
    |   expr ('<' | '<=' | '>' | '>=') expr
    |   expr ('==' | '!=') expr
    |   expr '&&' expr
    |   expr '||' expr
    |   atom
    ;