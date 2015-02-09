grammar QL_expr;

expr
    :   booleanExpr
    |   arithmeticExpr
    ;

booleanExpr
    :   LPAREN booleanExpr RPAREN
    |   NOT booleanExpr
    |   booleanExpr AND booleanExpr
    |   booleanExpr OR booleanExpr
    |   atom
    ;

arithmeticExpr
    :   LPAREN arithmeticExpr RPAREN
    |   MINUS arithmeticExpr
    |   arithmeticExpr [MULTIPLY|DIVIDE] arithmeticExpr
    |   arithmeticExpr [PLUS|MINUS] arithmeticExpr
    |   atom
    ;