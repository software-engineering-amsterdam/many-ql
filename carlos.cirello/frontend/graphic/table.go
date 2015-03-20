package graphic

import "gopkg.in/qml.v1"

type objectTable struct {
	objects         map[string]qml.Object
	updateCallbacks map[string]func(v string)
}

func newObjectTable() *objectTable {
	return &objectTable{
		objects:         make(map[string]qml.Object),
		updateCallbacks: make(map[string]func(v string)),
	}
}

func (o *objectTable) add(k string, v qml.Object) {
	o.objects[k] = v
}

func (o *objectTable) has(k string) (qml.Object, bool) {
	question, ok := o.objects[k]
	return question, ok
}

func (o *objectTable) get(k string) qml.Object {
	q, ok := o.has(k)
	if !ok {
		return nil
	}
	return q
}

func (o *objectTable) updateFor(k, v string) {
	o.updateCallbacks[k](v)
}

func (o *objectTable) setUpdate(k string, cb func(nv string)) {
	o.updateCallbacks[k] = cb
}
