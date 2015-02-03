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
end
