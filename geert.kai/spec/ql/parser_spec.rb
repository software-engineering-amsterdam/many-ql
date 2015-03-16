require_relative "spec_helper"

describe "Parsing" do
  it "parses a one query form" do
    form = QL.parse( "spec/ql/source_files/one_query.ql" )
    expect(form.name).to eq "Naam"
    expect(form.statements.size).to eq 1

    question = form.statements.first
    expect(question.description).to eq "Wat is je naam?"
    expect(question.variable_name).to eq "naam"
    expect(question.type).to eq StringType.new
  end
end

describe "Expression" do
  it "parses a simple expression" do
    form = QL.parse( "spec/ql/source_files/expression_query.ql" )
    
    expression = form.statements[1].expression
    expect(expression.lhs.value).to eq 10
    expect(expression.rhs.value).to eq 18
    expect(expression.operator).to eq :<
  end
end
