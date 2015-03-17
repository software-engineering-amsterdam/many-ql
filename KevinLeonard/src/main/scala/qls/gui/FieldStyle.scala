package qls.gui

import qls.ast._

class FieldStyle {

  def extract (s: Style, env: List[StyleProperty]): Style = s match {
    case Style(l, es) => Style(l, es.map(e => extract(e, env)))
  }

  def extract(e: StyleSheetElement, env: List[StyleProperty]): Page = e match {
    case Page(v, es) => Page(v, es.map(e => extractPageElement(e, env)))
  }

  def extractPageElement(e: PageElement, env: List[StyleProperty]): PageElement = e match {
    case Section(t, es) => Section(t, es.map(e => extract(e, env)))
  }

  def extract(e: SectionElement, env: List[StyleProperty]): SectionElement = e match {
    case Question(v, w) => Question(v, extract(w, env))
    case s: Section => extract(s, env)
  }

  def extract(w: Widget, env: List[StyleProperty]): Widget = w match {
    case Slider(p) => Slider(updateStyleProperties(env, p))
    case SpinBox(p) => SpinBox(updateStyleProperties(env, p))
    case Text(p) => Text(updateStyleProperties(env, p))
    case TextBlock(p) => TextBlock(updateStyleProperties(env, p))
    case Radio(p) => Radio(updateStyleProperties(env, p))
    case CheckBox(p) => CheckBox(updateStyleProperties(env, p))
    case DropDown(p) => DropDown(updateStyleProperties(env, p))
  }

  // TODO: Update property instead of merge style lists.
  def updateStyleProperties(defaultStyles: List[StyleProperty], styles: List[StyleProperty]): List[StyleProperty] = {
    val widgetStyleProperties = defaultStyles ++ styles

    // Check property in default styles and overwrite with widget style properties.
//    styles.foreach(style => widgetStyleProperties.find(y => y match {
//      case x: Width => widgetStyleProperties.dropWhile(x => x match {
//        case Width(_) => true
//        case _ => false
//      }); true
//      case x: FontSize => widgetStyleProperties.dropWhile(x => x match {
//        case FontSize(_) => true
//        case _ => false
//      }); true
//
//    }))

    widgetStyleProperties
  }


}
