#require "citrus"
#Citrus.load("query_language")

require_relative "lib/query_language/preprocessor.rb"
@string = Preprocessor.process("spec/source_files/if_statement.ql")

