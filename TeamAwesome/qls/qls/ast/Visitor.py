from patterns.Visitor import Visitor as GenericVisitor


class StatementVisitor(GenericVisitor):
    def _visitQLS(self, node):
        for statement in node.statements:
            self.visit(statement)

    def _visitStylesheetStatement(self, node):
        for statement in node.statements:
            self.visit(statement)

    def _visitDefaultStatement(self, node):
        pass

    def _visitPageStatement(self, node):
        for statement in node.statements:
            self.visit(statement)

    def _visitSectionStatement(self, node):
        for statement in node.statements:
            self.visit(statement)

    def _visitQuestionStatement(self, node):
        pass


class AttributeVisitor(GenericVisitor):
    def _visitStyleAttribute(self, node):
        self.visit(node.value)

    def _visitWidget(self, node):
        pass

    def _visitInt(self, node):
        pass

    def _visitStr(self, node):
        pass

    def _visitColor(self, node):
        pass


class FullVisitor(GenericVisitor):
    def _visitQLS(self, node):
        for statement in node.statements:
            self.visit(statement)
    
    def _visitStylesheetStatement(self, node):
        for statement in node.statements:
            self.visit(statement)

    def _visitDefaultStatement(self, node):
        for attribute in node.attributes:
            self.visit(attribute)

    def _visitPageStatement(self, node):
        for statement in node.statements:
            self.visit(statement)

    def _visitSectionStatement(self, node):
        for statement in node.statements:
            self.visit(statement)

    def _visitQuestionStatement(self, node):
        for attribute in node.attributes:
            self.visit(attribute)

    def _visitStyleAttribute(self, node):
        self.visit(node.value)

    def _visitWidget(self, node):
        pass

    def _visitInt(self, node):
        pass

    def _visitStr(self, node):
        pass

    def _visitColor(self, node):
        pass


class Visitor(FullVisitor):
    pass
