require_relative "static_checker"

class DuplicateLabelChecker < StaticChecker
  visitor_for Conditional do |conditional|
    conditional.accept(self)
  end

  visitor_for Question do |question|
    question.description
  end

  def check
    descriptions = visit(form)  
    duplicates = descriptions.each_with_object({}) do |desc, counts|
      counts[desc] = counts.fetch(desc, 0) + 1
    end.select { |desc, count| count > 1 }.keys

    { valid: duplicates.empty?, labels: duplicates }
  end
end