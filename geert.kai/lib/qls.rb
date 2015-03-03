require "require_all"
require "stringio"

if RUBY_ENGINE == "jruby"
  require "ruby-debug"
  require "jrubyfx"
else
  require "byebug"
end

require_all "lib/qls"


module QLS
  def self.parse(path)
    input     = StringIO.new(File.read(path))
    tokenizer = Tokenizer.new input
    parser    = Parser.new(tokenizer)
    result    = parser.parse
    result
  end
end
