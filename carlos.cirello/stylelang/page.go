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
func (v *Page) Name() string {
	return v.name
}

// Pages return all nested pages of this page
func (v *Page) Pages() map[string]*Page {
	return v.pages
}

// Visibles returns the visibility of all fields belonging to this page, but not
// its subpages.
func (v *Page) Visibles() map[string]bool {
	return v.visible
}

// Defaults returns the default widget configuration for this page, but does not
// trickle down to subpages.
func (v *Page) Defaults() map[string]string {
	return v.defaults
}

// AddPage adds a nested page to the given page
func (v *Page) AddPage(name string, page *Page) {
	v.pages[name] = page
}

// SetDefaultFor sets a default (w)idgte for a particular (t)ype of question
func (v *Page) SetDefaultFor(t, w string) {
	if _, ok := v.defaults[t]; !ok {
		v.defaults[t] = w
	}
}

// SetVisibleFor sets whether a question is visible or not within the page.
// Useful for having calculated questions that are not supposed to be view
// on the screen.
func (v *Page) SetVisibleFor(t string) {
	if _, ok := v.visible[t]; !ok {
		v.visible[t] = true
	}
}
