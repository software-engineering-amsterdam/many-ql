package stylelang

// Page is the strucht that represents one tab (page) in the form
type Page struct {
	name     string
	defaults map[string]string
	visible  map[string]bool
	pages    map[string]*Page
}

// NewPage is the constructor for Page
func NewPage(name string) *Page {
	return &Page{
		name:     name,
		defaults: make(map[string]string),
		visible:  make(map[string]bool),
		pages:    make(map[string]*Page),
	}
}

// Name returns the name of the page
func (p *Page) Name() string {
	return p.name
}

// Pages return all nested pages of this page
func (p *Page) Pages() map[string]*Page {
	return p.pages
}

func (p *Page) HasNestedPages() bool {
	return len(p.pages) > 0
}

// Visibles returns the visibility of all fields belonging to this page, but not
// its subpages.
func (p *Page) Visibles() map[string]bool {
	return p.visible
}

// Defaults returns the default widget configuration for this page, but does not
// trickle down to subpages.
func (p *Page) Defaults() map[string]string {
	return p.defaults
}

// AddPage adds a nested page to the given page
func (p *Page) AddPage(name string, page *Page) {
	p.pages[name] = page
}

// SetDefaultFor sets a default (w)idgte for a particular (t)ype of question
func (p *Page) SetDefaultFor(t, w string) {
	if _, ok := p.defaults[t]; !ok {
		p.defaults[t] = w
	}
}

// SetVisibleFor sets whether a question is visible or not within the page.
// Useful for having calculated questions that are not supposed to be view
// on the screen.
func (p *Page) SetVisibleFor(t string) {
	if _, ok := p.visible[t]; !ok {
		p.visible[t] = true
	}
}
