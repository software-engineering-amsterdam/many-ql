require_relative "../lib/ql/static_checker/pretty_printer"

describe "Pretty printer" do
  it "prints an empty tree" do
    question = Question.new(description: "wat is uw leeftijd", variable_name: "leeftijd", type: "string")
    tree = Form.new(statements: [question, question], name: "Leeftijd")
    output = PrettyPrinter.show(tree)
    expect(output).to eq "form\n  question\nquestion\n"
  end
end
