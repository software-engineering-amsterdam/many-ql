class QL::Parser
prechigh
  left     '*' '/'
  left     '+' '-'
  nonassoc '==' '!=' '<=' '<' '>=' '>'
  nonassoc '&&' '||' 
preclow

token STRING VARIABLE_NAME INTEGER
rule
  form
    : 'form' variable_name statements 'end' { result = AST::Form.new(val[1], val[2]) }
    ;
  statements
    : statements statement { result = val[0].push(val[1]) }
    | statement { result = [ val[0] ] }
    ;
  statement
    : question
    | conditional
    ;
  question
    : string variable_name ':' type { result = AST::Question.new(val[0], val[1], val[3].to_sym) }
    ;
  variable_name
    : VARIABLE_NAME 
    ;
  type
    : 'boolean'
    | 'integer'
    | 'string'
    ;

  conditional
    : if
    | if_else
    ;
  if
    : 'if' '(' expression ')' statements 'end' { result = AST::If.new(val[2], val[4]) }
    ;
  if_else
    : 'if' '(' expression ')' statements 'else' statements 'end' { result = AST::IfElse.new(val[2], val[4], val[6]) }
    ;

  expression
    : expression '==' expression { result = AST::Equal.new(val[0], val[2]) }
    | expression '<=' expression { result = AST::LessThanOrEqualTo.new(val[0], val[2]) }
    | expression '<'  expression { result = AST::LessThan.new(val[0], val[2]) }
    | expression '>=' expression { result = AST::GreaterThanOrEqualTo.new(val[0], val[2]) }
    | expression '>'  expression { result = AST::GreaterThan.new(val[0], val[2]) }
    | expression '!=' expression { result = AST::Inequal.new(val[0], val[2]) }
    | expression '&&' expression { result = AST::And.new(val[0], val[2]) }
    | expression '||' expression { result = AST::Or.new(val[0], val[2]) }
    | expression '*'  expression { result = AST::Multiplication.new(val[0], val[2]) }
    | expression '/'  expression { result = AST::Division.new(val[0], val[2]) }
    | expression '+'  expression { result = AST::Plus.new(val[0], val[2]) }
    | expression '-'  expression { result = AST::Minus.new(val[0], val[2]) }
    | '(' expression ')'
    | constant
    | variable_name { result = AST::Variable.new(val[0]) }
    ;

  constant
    : integer
    | string
    | boolean
    ;
 
  integer
    : INTEGER { result = AST::IntegerLiteral.new(val[0].to_i) }
    ;
  string
    # TODO: get rid of double quotes in a nicer way.
    : STRING { result = AST::StringLiteral.new(val[0][1..-2]) }
    ;
  boolean
    : 'true' { result = AST::BooleanLiteral.new(true) } 
    | 'false' { result = AST::BooleanLiteral.new(false) }
    ;
end

---- inner

  require_relative '../../ql'

  def initialize(tokenizer)
    @tokenizer = tokenizer
    super()
  end

  def next_token
    @tokenizer.next_token
  end

  def parse
    do_parse
  end
