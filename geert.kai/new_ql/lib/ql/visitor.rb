# Visitables:
# Form
# Statement
# VariableDefinition
# Expression

module Visitable
  def accept(visitor)
    visitor.visit(self)
  end
end

# The Visitor class is our base class for all visitors.  It implements the  
# "visit" method which Object#accept will call.   
class BaseVisitor  
  # Dynamically create a visitor method for each class in +klasses+  
  def self.visitor_for(*klasses, &block)
    klasses.each do |klass|  
      define_method(:"visit_#{klass.name}", block)  
    end
  end  
  # This method will examine the class and ancestors of +thing+. For each  
  # class in the "ancestors" list, it will check to see if the visitor knows  
  # how to handle that particular class. If it can't find a handler for the  
  # +subject+ it will raise an exception.  
  def visit(subject)
    subject.class.ancestors.each do |ancestor|  
      method_name = :"visit_#{ancestor.name}"  
      next unless respond_to? method_name  
      return send method_name, thing  
    end  
                                                         
    raise "Can't handle #{thing.class}"  
  end
end

class QuestionsVisitor < BaseVisitor
  visitor_for Question do |question|
    question.statements
  end

  visitor_for Statement do |statement|
    statement.statements
  end

  visitor_for Object do |question|
    []
  end
end

