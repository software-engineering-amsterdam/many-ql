require_relative "spec_helper"

describe "Type checker" do
  it "detects duplicate labels" do
    question = QL::AST::Question.new("Wat is uw leeftijd?", "leeftijd", IntegerType.new)
    form = Form.new("dubbel label", [question, question])

    errors = form.accept(DuplicateLabelChecker.new)
    expect(errors.first.message).to match /Duplicate label: Wat is uw leeftijd?/
    expect(errors.size).to eq 1
  end

  xit "detects if the type doesn't match up" do
    question = QL::AST::Question.new("Wat is je naam?", "naam", StringType.new)
    conditional = IfElse.new(GreaterThan.new(Variable.new("naam"), IntegerLiteral.new(8)), [], [])
    form = Form.new("Test", [question, conditional])
    errors = form.accept(TypeChecker.new)

    expect(errors.first.message).to match /not a valid argument type/
    expect(errors.size).to eq 1
  end

  it 'complains if expression of a conditional is not of type boolean' do
    conditional = IfElse.new(IntegerLiteral.new(3), [], [])
    form = Form.new("Test", [conditional])
    errors = form.accept(TypeChecker.new)

    expect(errors.first.message).to match /not a boolean/
    expect(errors.size).to eq 1
  end

  it 'detects undefined variables' do
    conditional = IfElse.new(Equal.new(Variable.new("naam"), StringLiteral.new("Geert")), [], [])
    form = Form.new("Test", [conditional])
    errors = form.accept(UndefinedVariableChecker.new)

    expect(errors.first.message).to match /naam/
    expect(errors.size).to eq 1
  end
end
