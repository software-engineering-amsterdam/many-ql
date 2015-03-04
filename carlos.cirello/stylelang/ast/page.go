package ast

type Page struct {
	name     string
	defaults map[string]string
	visible  map[string]bool
	pages    map[string]*Page
}

func NewPage(name string) *Page {
	return &Page{
		name:     name,
		defaults: make(map[string]string),
		visible:  make(map[string]bool),
		pages:    make(map[string]*Page),
	}
}

func (v *Page) Name() string {
	return v.name
}

func (v *Page) Pages() map[string]*Page {
	return v.pages
}

func (v *Page) Visibles() map[string]bool {
	return v.visible
}

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
