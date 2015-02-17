require_relative "visitor"

class StaticChecker < BaseVisitor
  def initialize(form)
    @form = form
  end

  private

  attr_reader :form
end
