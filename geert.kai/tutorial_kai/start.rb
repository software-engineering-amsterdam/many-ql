require_relative 'rsjon_tokenizer.rb'
tok = RJSON::Tokenizer.new StringIO.new '{"foo":null}'


#=> #<RJSON::Tokenizer:0x007fa8529fbeb8 @ss=#<StringScanner 0/12 @ "{\"foo...">>

tok.next_token #=> ["{", "{"]
tok.next_token #=> [:STRING, "\"foo\""]
tok.next_token #=> [":", ":"]
tok.next_token #=> [:NULL, "null"]
tok.next_token #=> ["}", "}"]
tok.next_token #=> nil}
