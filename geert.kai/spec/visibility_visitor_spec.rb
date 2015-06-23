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
    # wat is je naam?
    # wat is je oogkleur?
    #
    # if naam == "Geert"
    #   if oogkleur == "bruin"
    #     hoe heet je moeder?
    #   else
    #     hoe heet je vader?
    # else
    #   wat is je leeftijd?
    # end
    #

    second_question = Question.new("Wat is je oogkleur?", "oogkleur", :string) 
    nested_if_question = Question.new("Hoe heet je moeder?", "naam_moeder", :string)
    nested_else_question = Question.new("Hoe heet je vader?", "naam_vader", :string)

    nested_conditional = IfElse.new( Equal.new(Variable.new("oogkleur"), StringLiteral.new("bruin")), [nested_if_question], [nested_else_question] )
    conditional = IfElse.new( Equal.new(Variable.new("naam"), StringLiteral.new("Geert")), [nested_conditional], [@else_question] )

    form = Form.new("Form with nested if", [@first_question, second_question, conditional])

    answers = {"naam" => "Kai", "oogkleur" => "bruin"}
    result = form.accept( VisibilityVisitor.new(answers) )
    expect(result).to eq( [@first_question, second_question, @else_question] )

    answers = {"naam" => "Geert", "oogkleur" => "bruin"}
    result = form.accept( VisibilityVisitor.new(answers) )
    expect(result).to eq( [@first_question, second_question, nested_if_question] )

    answers = {}
    result = form.accept( VisibilityVisitor.new(answers) )
    expect(result).to eq( [@first_question, second_question] )
  end
end
