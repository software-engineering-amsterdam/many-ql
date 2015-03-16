require 'strscan'

module QLS
  class Tokenizer
    COMMENT       = /\/\/.*$/
    WHITESPACE    = /\s+/
    KEYWORD       = /widget:|fontsize:|color:|font:|stylesheet|page|section|default|question|integer|boolean|string|checkbox|radio|dropdown|text|spinbox/
    VARIABLE_NAME = /[a-zA-Z_][a-zA-Z0-9?!_]*/
    INTEGER       = /[0-9]+/
    STRING        = /"(?:[^"\\]|\\(?:["\\\/bfnrt]|u[0-9a-fA-F]{4}))*"/
    COLOR         = /#[0-9a-fA-F]{6}/

    def initialize io
      @ss = StringScanner.new io.read
    end

    def next_token
      return nil if @ss.eos?

      case
      when text = @ss.scan(COMMENT)       then next_token
      when text = @ss.scan(WHITESPACE)    then next_token
      when text = @ss.scan(KEYWORD)       then [text, text]
      when text = @ss.scan(VARIABLE_NAME) then [:VARIABLE_NAME, text]
      when text = @ss.scan(STRING)        then [:STRING, text]
      when text = @ss.scan(INTEGER)       then [:INTEGER, text]
      else
        x = @ss.getch
        [x, x]
      end
    end
  end
end
