
#TODO test of het ancestor gedoe daadwerkelijk nodig is
class BaseVisitor
  def visit(subject)
    subject.class.ancestors.each do |ancestor|  
      method_name = :"visit_#{ancestor.name.underscore}"  
      next unless respond_to?(method_name)
      return send(method_name, subject)
    end  
                                                         
    raise "Can't handle #{subject.class}"  
  end
end

class String
  def underscore
    word = self.dup
    word.gsub!(/::/, '/')
    word.gsub!(/([A-Z]+)([A-Z][a-z])/,'\1_\2')
    word.gsub!(/([a-z\d])([A-Z])/,'\1_\2')
    word.tr!("-", "_")
    word.downcase!
    word
  end
end
