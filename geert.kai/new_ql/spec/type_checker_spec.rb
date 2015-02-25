require_relative "../lib/ql/static_checker/static_checker"
require_relative "../lib/ql/ast/ast"


describe "Type checker" do
  xit "detects duplicate labels" do
    question = Question.new("Wat is uw leeftijd?", "leeftijd", "integer")
    form = Form.new([question, question], "dubbel_label")
    expect(DuplicateLabelChecker.new(form).check.first.message).to match /Warning: Duplicate Label: Wat is uw leeftijd?/
    expect(DuplicateLabelChecker.new(form).check.count).to eq 1
  end

  xit "detects if the type doesn't match up" do
    question = Question.new("Wat is je naam?", "naam", "string")
    conditional = If.new(GreaterThan.new(Variable.new("naam"), IntegerLiteral.new(8)), [])
    form = Form.new("Test", [question, conditional])
    expect(TypeChecker.new(form).check.first.message).to match /doesn't match any of/
    expect(TypeChecker.new(form).check.count).to eq 1
  end

  xit 'complains if expression of a conditional is not of type boolean' do
    conditional = If.new(IntegerLiteral.new(3), [])
    form = Form.new("Test", [conditional])
    expect(TypeChecker.new(form).check.first.message).to match /not a boolean/
    expect(TypeChecker.new(form).check.count).to eq 1
  end

  xit 'detects undefined variables' do
    conditional = If.new(Equal.new(Variable.new("naam"), StringLiteral.new("Geert")), [])
    form = Form.new("Test", [conditional])
    expect(TypeChecker.new(form).check.first.message).to match /naam/ 
    expect(TypeChecker.new(form).check.count).to eq 1
  end
end
