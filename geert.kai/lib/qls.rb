require "require_all"
require "stringio"

if RUBY_ENGINE == "jruby"
  require "ruby-debug"
  require "jrubyfx"
else
  require "byebug"
end

require_all "lib/qls"
require_relative "ql"


module QLS
  def self.parse(path)
    input     = StringIO.new(File.read(path))
    tokenizer = Tokenizer.new input
    parser    = Parser.new(tokenizer)
    result    = parser.parse
    result
  end

  def self.check_qls(ql_ast, qls_ast)
    ql_question_names = QL::Runner::QuestionVisitor.new(ql_ast).questions.map &:variable_name
    errors = Checking::QuestionChecker.new(qls_ast).errors(ql_question_names)

    { errors: errors }
  end
end
