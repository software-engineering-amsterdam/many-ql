class RJSON::Parser
  token STRING NUMBER TRUE FALSE NULL
  rule
    document
     : object
      | array
      ;
    object
      : '{' '}'
      | '{' pairs '}'
      ;
    pairs
      : pairs ',' pair
      | pair
      ;
    pair : string ':' value ;
    array
      : '[' ']'
      | '[' values ']'
      ;
    values
      : values ',' value
      | value
      ;
    value
      : string
      | NUMBER
      | object
      | array
      | TRUE
      | FALSE
      | NULL
      ;
    string : STRING ;
end
