require_relative "duplicate_label_checker"

class StaticChecker < BaseVisitor
  def initialize(form)
    @form = form
  end

  private

  attr_reader :form
end
