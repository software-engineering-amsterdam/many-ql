def check(ast):
    """
    Typechecks the AST.

    Language features:
    - No nested form statements
    - No else statements

    - Unary and binary arithmetic can only be performed on numeric
      type
    - Logical negation can only be performed on boolean type
    - Less-than and greater-than comparison can only be performed on
      numeric type
    - Equality and inequality comparison can be performed on
      boolean, numeric and string type
    - Logical AND and OR can only be performed on boolean type

    Numeric types: integer, money

    Detailed features implemented:

    *Statements*
    - root can only contain form statements
      (should be caught by parser)
    - form statements can only contain if and question statements
    - if statements can only contain if and question statements
    - assigned default values of question_type statements must match
      the type

    *Expressions*
    - (See Language features)
    """
    pass