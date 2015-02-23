require_relative "../lib/ql"

describe "Runner" do
  before(:each) do
    @question = Question.new(description: "Wat is je naam?", variable_name: "naam", type: :string)
    @second_question = Question.new(description: "Wat is je leeftijd?", variable_name: "leeftijd", type: :string)

    @conditional = If.new(expression: Equal.new(Variable.new("naam"), StringLiteral.new("Geert")), statements: [@second_question])
    @form = Form.new(name: "Test form", statements: [@question, @conditional])
  end

  it "gives the first question at the beginning" do
    runner = Runner.new(@form)
    expect( runner.next_question ).to eq @question
    runner.answered("Geert")
    # byebug
    expect( runner.next_question ).to eq @second_question
    runner.answered(22)
    # expect( runner.next_question ).to be_nil
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
