require_relative "../lib/ql/static_checker"
require_relative "../lib/ql/ast"


describe "Type checker" do
  it "detects duplicate labels" do
    question = Question.new(description: "Wat is uw leeftijd?", variable_name: "leeftijd", type: "integer")
    form = Form.new(statements: [question, question], name: "dubbel_label")
    expect(DuplicateLabelChecker.new(form).check).to eq ( { :valid => false, :labels => ["Wat is uw leeftijd?"] } )

  end
end
