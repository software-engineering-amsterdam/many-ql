require "stringio"

require_relative "ast/form"
require_relative "ast/expression"
require_relative "ast/types"

require_relative "checkers/type_checker"
require_relative "checkers/duplicate_label_checker"
require_relative "checkers/undefined_variable_checker"
require_relative "checkers/duplicate_variable_declaration_checker"

require_relative "parser/parser"
require_relative "parser/tokenizer"

require_relative "runtime/visibility_visitor"
require_relative "runtime/renderer_visitor"
require_relative "runtime/expression_evaluator"

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
    errors += ql_ast.accept(Checkers::DuplicateVariableDeclarationChecker.new)

    warnings = ql_ast.accept(Checkers::DuplicateLabelChecker.new)

    { errors: errors, warnings: warnings }
  end
end
