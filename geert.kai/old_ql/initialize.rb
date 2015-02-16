require "citrus"
require "awesome_print"
Citrus.load("lib/query_language")
@match = QueryLanguage.parse(File.read("spec/preprocessed_source_files/if_statement.ql"))
