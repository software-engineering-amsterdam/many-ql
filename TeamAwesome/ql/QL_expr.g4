grammar QL_expr;

expr
    :   '(' expr ')'
    |   op=('+' | '-' | '!') right=expr
    |   left=expr op='^' right=expr
    |   left=expr op=('*' | '/' | '%') right=expr
    |   left=expr op=('+' | '-') right=expr
    |   left=expr op=('<' | '<=' | '>' | '>=') right=expr
    |   left=expr op=('==' | '!=') right=expr
    |   left=expr op='&&' right=expr
    |   left=expr op='||' right=expr
    |   left=atom
    ;