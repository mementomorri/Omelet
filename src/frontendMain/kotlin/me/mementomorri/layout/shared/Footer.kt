package me.mementomorri.layout.shared

import me.mementomorri.View
import io.kvision.core.Container
import io.kvision.html.*

fun Container.footer() {
    footer {
        div(className = "container") {
            ul(className = "icons")  {
                li(className = "icons") { link("","https://github.com/mementomorri",className = "fa fa-github")  }
                li(className = "icons") { link("","https://mementomorri.github.io/",className = "fa fa-dribbble") }
            }
        }
    }
}
