require_relative "../lib/ql.rb"

def source(file_name)
  "spec/source_files/#{file_name}.ql"
end

describe "Parsing" do
  it "parses a one query form" do
    form = QL.parse( source("one_query") ).first
    expect(form.name).to eq "Naam"
    expect(form.statements.size).to eq 1

    question = form.statements.first
    expect(question.description).to eq "Wat is je naam?"
    expect(question.variable_name).to eq "naam"
    expect(question.type).to eq "string"
  end
end
