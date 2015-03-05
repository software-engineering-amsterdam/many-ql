package ast

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

func (v *Page) addPage(name string, page *Page) {
	v.pages[name] = page
}

func (v *Page) setDefaultFor(t, w string) {
	if _, ok := v.defaults[t]; !ok {
		v.defaults[t] = w
	}
}

func (v *Page) setVisibleFor(t string) {
	if _, ok := v.visible[t]; !ok {
		v.visible[t] = true
	}
}
