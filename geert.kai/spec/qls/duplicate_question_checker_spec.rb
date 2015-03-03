require_relative "spec_helper"

describe DuplicateQuestionChecker do
  it "detects a duplicate question" do
    question = Question.new("jarig?", [])
    stylesheet = Stylesheet.new("Verjaardag", [question, question])
    
    errors = DuplicateQuestionChecker.new(stylesheet).errors 

    expect(errors.size).to eq 1
    expect(errors.first.message).to match /defined more than once/
  end
end
