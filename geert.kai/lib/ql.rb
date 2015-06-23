require "stringio"
#require "ruby-debug"
# require "jrubyfx"

require_relative "ast/form"
require_relative "ast/expression"
require_relative "ast/types"

require_relative "checkers/type_checker"
require_relative "checkers/duplicate_label_checker"

require_relative "parser/parser"
require_relative "parser/tokenizer"

require_relative "runner/visibility_visitor"
require_relative "runner/renderer_visitor"
require_relative "runner/expression_evaluator"

module QL
  def self.parse(path)
    input     = StringIO.new(File.read(path))
    tokenizer = Tokenizer.new input
    parser    = Parser.new(tokenizer)
    result    = parser.parse

    result
  end

  def self.check_ql(ql_ast)
    errors = ql_ast.accept(Checkers::TypeChecker.new)
    warnings = ql_ast.accept(Checkers::DuplicateLabelChecker.new)

    { errors: errors, warnings: warnings }
  end
end
