package qls.ast.visitor.pagebuilder;

import java.util.List;

import ql.ast.visitor.TypeVisitor;
import ql.gui.Component;
import qls.ast.Statement;
import qls.ast.statement.Page;
import qls.ast.statement.Question;
import qls.ast.statement.Section;
import qls.ast.statement.Stylesheet;
import qls.ast.visitor.ExpressionVisitor;
import qls.ast.visitor.ProcessedCache;
import qls.ast.visitor.StatementVisitor;
import qls.ast.visitor.WidgetEnvironment;
import qls.ast.visitor.domaincreator.ConditionalDomain;
import qls.gui.structure.TabbedPanel;
import qls.gui.structure.UIPage;
import qls.gui.structure.UISection;

public class PageBuilder extends StatementVisitor<Component> implements ExpressionVisitor<Void>, TypeVisitor<Void> {
	private ProcessedCache<Component> processedComponents;
	private WidgetEnvironment widgetEnvironment;
	private List<ConditionalDomain> domains;
	
	private PageBuilder(List<ConditionalDomain> domains, WidgetEnvironment widgetEnvironment) {
		super.setExpressionVisitor(this);
		super.setTypeVisitor(this);
		
		this.domains = domains;
		this.widgetEnvironment = widgetEnvironment;
		processedComponents = new ProcessedCache<Component>();
	}
	
	public static Component build(Statement tree, List<ConditionalDomain> domains, WidgetEnvironment widgetEnvironment) {
		PageBuilder builder = new PageBuilder(domains, widgetEnvironment);
		
		return tree.accept(builder);
	}
	
	private void scopeDown() {
		processedComponents = new ProcessedCache<Component>(processedComponents);
	}
	
	private void scopeUp() {
		processedComponents = processedComponents.getParent();
	}
	
	@Override
	public Component visit(Page pageNode) {
		scopeDown();
		super.visit(pageNode);
		UIPage page = new UIPage(pageNode.getIdentifier());
		page.setSections(processedComponents.getProcessedObjects());
		scopeUp();
		
		processedComponents.addObject(page);
		return null;
	}

	@Override
	public Component visit(Question questionNode) {
		processedComponents.addObject(widgetEnvironment.resolve(questionNode.getIdentifier()));
		
		return null;
	}

	@Override
	public Component visit(Section sectionNode) {
		scopeDown();
		super.visit(sectionNode);
		UISection section = new UISection(sectionNode.getHeader());
		section.setComponents(processedComponents.getProcessedObjects());
		scopeUp();
		
		processedComponents.addObject(section);
		return null;
	}

	@Override
	public Component visit(Stylesheet stylesheetNode) {
		scopeDown();
		super.visit(stylesheetNode);
		TabbedPanel stylesheet = new TabbedPanel(stylesheetNode.getIdentifier(), domains);
		stylesheet.setPages(processedComponents.getProcessedObjects());
		scopeUp();
		
		return stylesheet;
	}
}
