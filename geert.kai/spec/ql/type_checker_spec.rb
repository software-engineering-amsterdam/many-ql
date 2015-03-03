require_relative "spec_helper"

describe "Type checker" do
  it "detects duplicate labels" do
    question = Question.new("Wat is uw leeftijd?", "leeftijd", "integer")
    form = Form.new("dubbel label", [question, question])
    expect(DuplicateLabelChecker.new(form).errors.first.message).to match /Duplicate label: Wat is uw leeftijd?/
    expect(DuplicateLabelChecker.new(form).errors.count).to eq 1
  end

  it "detects if the type doesn't match up" do
    question = Question.new("Wat is je naam?", "naam", "string")
    conditional = If.new(GreaterThan.new(Variable.new("naam"), IntegerLiteral.new(8)), [])
    form = Form.new("Test", [question, conditional])
    expect(TypeChecker.new(form).errors.first.message).to match /doesn't match any of/
    expect(TypeChecker.new(form).errors.count).to eq 1
  end

  it 'complains if expression of a conditional is not of type boolean' do
    conditional = If.new(IntegerLiteral.new(3), [])
    form = Form.new("Test", [conditional])
    expect(TypeChecker.new(form).errors.first.message).to match /not a boolean/
    expect(TypeChecker.new(form).errors.count).to eq 1
  end

  it 'detects undefined variables' do
    conditional = If.new(Equal.new(Variable.new("naam"), StringLiteral.new("Geert")), [])
    form = Form.new("Test", [conditional])
    expect(TypeChecker.new(form).errors.first.message).to match /naam/ 
    expect(TypeChecker.new(form).errors.count).to eq 1
  end
end
