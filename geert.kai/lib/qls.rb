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

  def self.check(ql_ast, qls_ast)
    #ql_question_names = QL::Runner::QuestionVisitor.run(ql_ast).map &:variable_name
    errors = Checking::QuestionChecker.run(ql_ast, qls_ast)

    { errors: errors }
  end
end

# ql = QL.parse("../bla.ql")
# qls = QLS.parse("../bla.qls")

# result = QL.check(ql)
# # raise errors

# result = QLS.check(ql, qls)
# # raise errors

# runner = QL::Runner.new(ql)
# questions = runner.questions
# stylesheet = QLS::Stylesheet.new(qls, questions)

# # goeie volgorde, met style info
# stylesheet.questions

# GUI.new(runner, stylesheet)