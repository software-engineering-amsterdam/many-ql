Shoes.app do
  require "require_all"

  require_all "lib/"

  module QL
    def self.parse(path)
      input     = StringIO.new(File.read(path))
      tokenizer = QL::Tokenizer.new input
      parser    = QL::Parser.new tokenizer
      result    = parser.parse
      result
    end
  end

  button { "Push me" }
end
