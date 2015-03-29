package qls.gui.structure;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JComponent;
import javax.swing.JTabbedPane;

import ql.Value;
import ql.ast.expression.Identifier;
import ql.gui.Component;
import qls.ast.visitor.domaincreator.ConditionalDomain;

public class TabbedPanel implements Component {
	private Identifier identifier;
	private JTabbedPane tabbedPanel;
	private List<ConditionalDomain> domains;
	private List<Component> pages;
	private Component handler;
	
	public TabbedPanel(Identifier identifier, List<ConditionalDomain> domains) {
		tabbedPanel = new JTabbedPane();
		pages = new ArrayList<Component>();
		
		this.identifier = identifier;
		this.domains = domains;
	}
	
	public void addPage(Component page) {
		pages.add(page);
		tabbedPanel.addTab(page.toString(), page.getComponent());
		page.setHandler(this);
		
		updateComponent();
	}
	
	public void setPages(List<Component> pages) {
		tabbedPanel.removeAll();
		
		this.pages = new ArrayList<Component>(pages);
		this.pages.stream().forEach(page -> tabbedPanel.addTab(page.toString(),
				page.getComponent()));
		this.pages.stream().forEach(page -> page.setHandler(this));
		
		updateComponent();
	}

	@Override
	public void setHandler(Component handler) {
		this.handler = handler;
	}

	@Override
	public void handleChange(Value changedValue, Component source) {
		if(handler != null) {
			handler.handleChange(changedValue, source);
		} else {
			updateComponent();
		}
	}

	@Override
	public void updateComponent() {
		domains.stream().forEach(domain -> domain.updateDomain());
		pages.stream().forEach(page -> page.updateComponent());
	}

	@Override
	public JComponent getComponent() {
		return tabbedPanel;
	}
	
	@Override
	public String toString() {
		return identifier.toString();
	}
}
