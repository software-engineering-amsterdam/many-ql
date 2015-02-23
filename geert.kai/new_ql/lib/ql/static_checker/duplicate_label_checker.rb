require_relative "static_checker"

class DuplicateLabelChecker < StaticChecker
  def visit_conditional(conditional)
    conditional.accept(self)
  end

  def visit_question(question) 
    question.description
  end

  def check
    descriptions = visit(@base)  
    duplicates = descriptions.each_with_object({}) do |desc, counts|
      counts[desc] = counts.fetch(desc, 0) + 1
    end.select { |desc, count| count > 1 }.keys

    { valid: duplicates.empty?, labels: duplicates }
  end
end
