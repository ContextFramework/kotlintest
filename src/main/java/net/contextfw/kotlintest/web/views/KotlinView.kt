package net.contextfw.web.views

import net.contextfw.web.application.component.Component
import net.contextfw.web.application.lifecycle.View
import net.contextfw.web.application.lifecycle.PageScoped
import net.contextfw.web.application.component.Attribute

[View(
    url=Array<String?>(1, {"/kotlin"}),
    parent=javaClass<RootView>()
)]
[PageScoped]
class KotlinView() : Component() {

    [Attribute(
            name= "Muu"
    )]
    var test = "Test"
}
