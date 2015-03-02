package ast

func (v *Visitor) setDefaultFor(t, w string) {
	if _, ok := v.defaults[t]; !ok {
		v.defaults[t] = w
	}
}

func (v *Visitor) setVisibleFor(t string) {
	if _, ok := v.visible[t]; !ok {
		v.visible[t] = true
	}
}
