require 'byebug'

describe "Runner" do
  before(:each) do
    @question = Question.new("Wat is je naam?", "naam", :string)
    @second_question = Question.new("Wat is je leeftijd?", "leeftijd", :string)

    @conditional = If.new(expression: Equal.new(Variable.new("naam"), StringLiteral.new("Geert")), statements: [@second_question])
    @form = Form.new(name: "Test form", statements: [@question, @conditional])
  end

  it "gives the first question at the beginning" do
    runner = Runner.new(@form)
    byebug
    expect( runner.applicable_questions ).to eq [@question]
    runner.update_variable("naam", "Geert")
    expect( runner.applicable_questions ).to eq [@question, @second_question]
    runner.update_variable("naam", "Kai")
    expect( runner.applicable_questions ).to eq [@question]
  end  

  xit "knows when it's finished" do
  end
end

describe "Evaluator" do
  before(:each) do
    @expression = Equal.new(Variable.new("naam"), StringLiteral.new("Geert"))
  end

  it "evaluates an true expression" do
    @runner = Runner.new(@expression)
    @runner.update_variable("naam", "Geert")
    expect(@runner.visit(@expression)).to eq true
  end

  it "evaluates an false expression" do
    @runner = Runner.new(@expression)
    @runner.update_variable("naam", "Kai")
    expect(@runner.visit(@expression)).to eq false
  end

  it "evaluates an undefined expression" do
    @runner = Runner.new(@expression)
    expect(@runner.visit(@expression)).to eq :undefined
  end
end
