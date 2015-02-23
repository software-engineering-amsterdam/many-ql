require_relative "../lib/ql"

describe "Runner" do
  before(:each) do
    @question = Question.new(description: "Wat is je naam?", variable_name: "naam", type: :string)
    @conditional = If.new(expression: Equal.new(Variable.new("naam"), StringLiteral.new("Geert")))
    @form = Form.new(name: "Test form", statements: [@question, @conditional])
  end

  xit "gives the first question at the beginning" do
    expect( Evaluator.new(@form).next_question ).to eq @question
  end  

  xit "knows when it's finished" do
  end
end

describe "Evaluator" do
  before(:each) do
    @expression = Equal.new(Variable.new("naam"), StringLiteral.new("Geert"))
  end

  it "evaluates an expression" do
    result = Evaluator.evaluate(expression: @expression, values: { "naam" => "Geert" })
    expect(result).to eq true
  end
end
