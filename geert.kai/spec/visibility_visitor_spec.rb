require_relative "spec_helper"

describe "VisibilityVisitor" do
  before(:each) do
    @first_question = Question.new("Wat is je naam?", "naam", :string)
    @second_question = Question.new("Wat is je leeftijd?", "leeftijd", :string)

    @conditional = IfElse.new(Equal.new(Variable.new("naam"), StringLiteral.new("Geert")), [@second_question], [])
    @form = Form.new("Test form", [@first_question, @conditional])
  end



  it "hides questions within falsy if statements" do
    result = @form.accept( VisibilityVisitor.new({}) )
    expect(result).to eq( { @first_question => true, @second_question => false } )
  end

  it "handles nested if statements" do
  end

  it "hides the whole if-else tree if the expression is undefined" do
  end

end
