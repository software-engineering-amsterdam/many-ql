require_relative "visitor"
require_relative "../ast/form"

# class PrettyPrinter < BaseVisitor
#   def visit_form(form)
#     "form\n  " + map_accept(form.statements).join
#   end

#   def visit_if(condititional)
#     "if\n  " + map_accept(condititional.statements).join
#   end

#   def visit_if_else(condititional)
#     "if\n  " + map_accept(condititional.statements_true).join +
#     " else " + map_accept(condititional.statements_false).join
#   end

#   def visit_question(question)
#     "question\n"
#   end
# end
