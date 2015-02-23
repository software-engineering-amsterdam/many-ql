require_relative "../lib/ql/static_checker/static_checker"
require_relative "../lib/ql/ast/ast"


describe "Type checker" do
  it "detects duplicate labels" do
    question = Question.new(description: "Wat is uw leeftijd?", variable_name: "leeftijd", type: "integer")
    form = Form.new(statements: [question, question], name: "dubbel_label")
    expect(DuplicateLabelChecker.new(form).check).to eq ( { :valid => false, :labels => ["Wat is uw leeftijd?"] } )
  end

  it "detects if the type doesn't match up" do
    question = Question.new(description: "Wat is je naam?", variable_name: "naam", type: "string")
    conditional = If.new(expression: GreaterThan.new(Variable.new("naam"), IntegerLiteral.new(8)), statements: [])
    form = Form.new(name: "Test", statements: [question, conditional])
    expect { TypeChecker.new(form).check }.to raise_error TypeError, /doesn't match/
  end

  it 'complains if expression of a conditional is not of type boolean' do
    conditional = If.new(expression: IntegerLiteral.new(3), statements: [])
    form = Form.new(name: "Test", statements: [conditional])
    expect { TypeChecker.new(form).check }.to raise_error TypeError, /not a boolean/
  end

  it 'detects undefined variables' do
    conditional = If.new(expression: Equal.new(Variable.new("naam"), StringLiteral.new("Geert")), statements: [])
    form = Form.new(name: "Test", statements: [conditional])
    expect { TypeChecker.new(form).check }.to raise_error NameError, /naam/ 
  end
end
