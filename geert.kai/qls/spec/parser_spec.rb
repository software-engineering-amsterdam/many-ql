require_relative "spec_helper"

def source(file_name)
  "spec/source_files/#{file_name}.qls"
end

describe "Parsing" do
  it "parses a stylesheet with one declaration" do
    stylesheet = QLS.parse( source("one_declaration") )
    expect(true).to eq false
  end
end

