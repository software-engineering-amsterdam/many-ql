
#TODO: test of het ancestor gedoe daadwerkelijk nodig is

module QLS
  module Checker
    class BaseVisitor
      
      def initialize(base)
        @base = base
        after_initialize(base)
        self
      end

      def after_initialize(base)
      end

      def visit(subject)
        subject.class.ancestors.each do |ancestor|  
          method_name = :"visit_#{ancestor.name.snake_case}"  
          next unless respond_to?(method_name)
          return send(method_name, subject)
        end  
                                                             
        raise "Can't handle #{subject.class}"  
      end
    end
  end
end

class String # TODO
  def snake_case
    gsub(/QL::AST::/, '').
    gsub(/([A-Z]+)([A-Z][a-z])/,'\1_\2').
    gsub(/([a-z\d])([A-Z])/,'\1_\2').
    tr("-", "_").
    downcase
  end
end
