package net.contextfw.web.views

import net.contextfw.web.application.component.Component
import net.contextfw.web.application.component.Element
import net.contextfw.web.application.lifecycle.PageScoped
import net.contextfw.web.application.lifecycle.View
import net.contextfw.web.application.lifecycle.ViewComponent
import net.contextfw.web.application.lifecycle.ViewContext

[View]
[PageScoped]
public open class RootView(): Component(), ViewComponent {

    [Element]
    private var child: Component? = null

    public override fun initialize(context: ViewContext?): Unit {
        if (context?.getChildClass() != null) {
            child = context?.initChild()
            registerChild(child)
        }
    }
}
