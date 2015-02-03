require "citrus"
Citrus.load("query_language")

SOURCE_FILES = "spec/source_files/"

def source(name)
  File.read(SOURCE_FILES + name + ".ql")
end

describe "Query Language" do
  it "parses an empty form" do
    expect( QueryLanguage.parse( source("empty_form") ) ).to_not be_nil
  end

  it "parses text and answer fields in a one query form" do
    match = QueryLanguage.parse( source("one_query") )
    query = match.capture(:form).capture(:statement).capture(:query) 
    expect(query.capture(:text)).to eq "\"Wat is je naam?\""
    expect(query.capture(:answer).capture(:variable)).to eq "naam"
    expect(query.capture(:answer).capture(:type)).to eq "string"
  end
end
