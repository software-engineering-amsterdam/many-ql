module QL
  module VisitorPattern
    class BaseVisitor
      # def visit(subject)
      #   method_name = :"visit_#{snake_case(subject.class.name)}"
      #   send(method_name, subject)
      # end
      #
      # def snake_case(string)
      #   string.split("::").last.
      #   gsub(/([A-Z]+)([A-Z][a-z])/,'\1_\2').
      #   gsub(/([a-z\d])([A-Z])/,'\1_\2').
      #   downcase
      # end

      def visit_statement(statement)
        if statement.kind_of?(QL::AST::Question)
          visit_question(statement)
        elsif statement.kind_of?(QL::AST::ComputedQuestion)
          visit_computed_question(statement)
        elsif statement.kind_of?(QL::AST::IfElse)
          visit_if_else(statement)
        else
          ["snor"]
        end
      end

      def visit_expression(expresion)
        if expresion.kind_of?(QL::AST::BinaryExpression)
          visit_binary_expression(expresion)
        elsif expresion.kind_of?(QL::AST::Variable)
          visit_variable(expresion)
        elsif expresion.kind_of?(QL::AST::Literal)
          visit_literal(expresion)
        else
          ["snor"]
        end
      end
    end
  end
end
