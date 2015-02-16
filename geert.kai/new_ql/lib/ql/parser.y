class QL::Parser
token STRING VARIABLE_NAME INTEGER
rule
  forms
    : forms form { result = [ val[1] ] + val[0] }
    | form { result = [ val[0] ] }
    ;
  form
    : 'form' form_name statements 'end' { result = Form.new(name: val[1], statements: val[2]) }
    ;
  form_name
    : VARIABLE_NAME 
    ;
  statements
    : statements statement { result = [ val[1] ] + val[0] }
    | statement { result = [ val[0] ] }
    ;
  statement
    : question
    | conditional
    ;
  question
    : string variable_name ':' type { result = Question.new(description: val[0], variable_name: val[1], type: val[3]) }
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
    : 'if' '(' operator ')' statements 'end' { result = If.new(operator: val[2], statements: val[4]) }
    ;
  if_else
    : 'if' '(' operator ')' statements 'else' statements 'end' { result = IfElse.new(operator: val[2], statements_true: val[4], statements_false: val[6]) }
    ;
  operator
    : operator '==' operator { result = CompareOperator.new(method: :==, arguments: [val[0], val[2]]) }
    | operator '<=' operator { result = CompareOperator.new(method: :<=, arguments: [val[0], val[2]]) }
    | operator '<'  operator { result = CompareOperator.new(method: :<, arguments: [val[0], val[2]]) }
    | operator '>=' operator { result = CompareOperator.new(method: :>=, arguments: [val[0], val[2]]) }
    | operator '>'  operator { result = CompareOperator.new(method: :>, arguments: [val[0], val[2]]) }
    | operator '!=' operator { result = CompareOperator.new(method: :==,  arguments:[val[0], val[2]]) } #wrong at the moment
    | operator '&&' operator { result = BooleanOperator.new(method: :and, arguments: [val[0], val[2]]) }
    | operator '||' operator { result = BooleanOperator.new(method: :or, arguments: [val[0], val[2]]) }
    | operator '*'  operator { result =  NumberOperator.new(method: :* , arguments: [val[0], val[2]]) }
    | operator '/'  operator { result =  NumberOperator.new(method: :/ , arguments: [val[0], val[2]]) }
    | operator '+'  operator { result =  NumberOperator.new(method: :+ , arguments: [val[0], val[2]]) }
    | operator '-'  operator { result =  NumberOperator.new(method: :- , arguments: [val[0], val[2]]) }
    | '(' operator ')'
    | VARIABLE_NAME
    | INTEGER { result = val[0].to_i }
    ;
  string
    # TODO: get rid of double quotes in a nicer way.
    : STRING { result = val[0][1..-2] }
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
