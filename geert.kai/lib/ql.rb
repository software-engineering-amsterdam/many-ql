require "require_all"
require "stringio"

if RUBY_ENGINE == "jruby"
  require "ruby-debug"
  require "jrubyfx"
else
  require "byebug"
end

require_all "lib/ql"

module QL
  def self.parse(path)
    input     = StringIO.new(File.read(path))
    tokenizer = Tokenizer.new input
    parser    = Parser.new(tokenizer)
    result    = parser.parse

    result
  end

  def self.check_ql(ql_ast)
    errors = Checking::TypeChecker.new(ql_ast).errors
    warnings = Checking::DuplicateLabelChecker.new(ql_ast).warnings

    { errors: errors, warnings: warnings }
  end
end
