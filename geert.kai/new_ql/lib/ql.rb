require_relative 'ql/tokenizer'
require_relative 'ql/parser'
require_relative 'ql/ast'
require_relative 'ql/visitor'

require "byebug"

module QL
  def self.parse(path)
    input     = StringIO.new(File.read(path))
    tokenizer = QL::Tokenizer.new input
    parser    = QL::Parser.new tokenizer
    result    = parser.parse
    result
  end
end
