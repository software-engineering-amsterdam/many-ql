require_relative "spec_helper"

describe "VisibilityVisitor" do
  before(:each) do
    @first_question = Question.new("Wat is je naam?", "naam", :string)
    @if_question = Question.new("Wat is je leeftijd?", "leeftijd", :string)
    @else_question = Question.new("Wat is je leeftijd?", "leeftijd", :string)

    @conditional = IfElse.new(Equal.new(Variable.new("naam"), StringLiteral.new("Geert")), [@if_question], [@else_question])
    @form = Form.new("Test form", [@first_question, @conditional])
  end



  it "hides if-questions within falsy if statements" do
    result = @form.accept( VisibilityVisitor.new({"naam" => "Kai"}) )
    expect(result).to eq( [@first_question, @else_question] )
  end

  it "hides else-questions within true if statements" do
    result = @form.accept( VisibilityVisitor.new({"naam" => "Geert"}) )
    expect(result).to eq( [@first_question, @if_question] )
  end

  it "hides the whole if-else tree if the expression is undefined" do
    result = @form.accept( VisibilityVisitor.new({}) )
    expect(result).to eq( [@first_question] )
  end

  it "handles nested if statements" do

  end

end
