class QL::Parser
token STRING VARIABLE_NAME
rule
  forms
    : forms form 
    | form
    ;
  form
    : 'form' form_name statements 'end' { result = Form.new(name: val[1], statements: val[2]) }
    ;
  form_name
    : VARIABLE_NAME 
    ;
  statements
    : statements statement { result = [ val[1] ] + val[0] }
    | statement { result = [val[0]] }
    ;
  statement
    : question
    | conditional
    ;
  question
    : string variable_name ':' type { result = Question.new(description: val[0], variable_name: val[1], type: val[2]) }
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
    : 'if' '(' expression ')' statements 'end' { result = If.new(expression: val[2], statements: val[4]) }
    ;
  if_else
    : 'if' '(' expression ')' statements 'else' statements 'end' { result = IfElse.new(expression: val[2], statements_true: val[4], statements_false: val[6]) }
    ;
  expression
    : VARIABLE_NAME
    ;
  string
    : STRING 
    ;
end

---- inner

  require_relative 'form'

  def initialize tokenizer
    @tokenizer = tokenizer
    super()
  end

  def next_token
    @tokenizer.next_token
  end

  def parse
    do_parse
  end
