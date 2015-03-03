require_relative "spec_helper"

def source(file_name)
  "spec/qls/source_files/#{file_name}.qls"
end

describe "Parsing" do
  it "parses the name of a stylesheet with one declaration" do
    stylesheet = QLS.parse( source("one_declaration") )
    expect(stylesheet.name).to eq "Trouwerij"

    
  end
end

