require_relative "spec_helper"

describe "Runner" do
  before(:each) do
    @question = Question.new("Wat is je naam?", "naam", :string)
    @second_question = Question.new("Wat is je leeftijd?", "leeftijd", :string)

    @conditional = If.new(Equal.new(Variable.new("naam"), StringLiteral.new("Geert")), [@second_question])
    @form = Form.new("Test form", [@question, @conditional])
  end

  xit "gives the first question at the beginning" do
    runner = Runner.new(@form)
    expect( runner.questions ).to eq [@question, @second_question]


    expect( runner.calculate_visibilities ).to eq ({ @question => true, @second_question => false })
    runner.update_variable("naam", "Geert")
    expect( runner.calculate_visibilities ).to eq ({ @question => true, @second_question => true })

    runner.update_variable("naam", "Kai")
    expect( runner.calculate_visibilities ).to eq ({ @question => true, @second_question => false })
  end  
end

describe "Evaluator" do
  before(:each) do
    @expression = Equal.new(Variable.new("naam"), StringLiteral.new("Geert"))
  end

  it "evaluates a true expression" do
    result = Evaluator.run(@expression, {"naam" => "Geert"})
    expect(result).to eq true
  end

  it "evaluates a false expression" do
    result = Evaluator.run(@expression, {"naam" => "Kai"})
    expect(result).to eq false
  end

  it "evaluates an undefined expression" do
    result = Evaluator.run(@expression, {})
    expect(result).to eq nil
  end
end
