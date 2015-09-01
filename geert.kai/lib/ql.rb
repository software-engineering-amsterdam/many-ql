require "stringio"

require_relative "ast/expressions"
require_relative "ast/form"
require_relative "ast/if_else"
require_relative "ast/literals"
require_relative "ast/question"
require_relative "ast/computed_question"
require_relative "ast/types"
require_relative "ast/variable"

require_relative "checkers/type_checker"
require_relative "checkers/duplicate_label_checker"
require_relative "checkers/undefined_variable_checker"
require_relative "checkers/duplicate_variable_declaration_checker"

require_relative "parser/parser"
require_relative "parser/tokenizer"

require_relative "runtime/visibility_visitor"
require_relative "runtime/renderer_visitor"
require_relative "runtime/expression_evaluator"

require_relative "visitor_pattern/question_visitor"
require_relative "visitor_pattern/computed_question_visitor"

module QL
  def self.parse(path)
    input     = StringIO.new( File.read(path) )
    tokenizer = Tokenizer.new(input)
    parser    = Parser.new(tokenizer)
    result    = parser.parse

    result
  end

  def self.check(ql_ast)
    errors = ql_ast.accept(Checkers::TypeChecker.new)
    errors += ql_ast.accept(Checkers::UndefinedVariableChecker.new)
    errors += Checkers::DuplicateVariableDeclarationChecker.new.visit(ql_ast)

    warnings = ql_ast.accept(Checkers::DuplicateLabelChecker.new)

    { errors: errors, warnings: warnings }
  end
end
