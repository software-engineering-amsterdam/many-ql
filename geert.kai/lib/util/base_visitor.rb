
class BaseVisitor
  def visit(subject)
    method_name = :"visit_#{snake_case(subject.class.name)}"
    send(method_name, subject)
  end

  def snake_case(string)
    string.split("::").last.
    gsub(/([A-Z]+)([A-Z][a-z])/,'\1_\2').
    gsub(/([a-z\d])([A-Z])/,'\1_\2').
    downcase
  end
end
