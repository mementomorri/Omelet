package me.mementomorri.layout.shared

import me.mementomorri.ConduitState
import me.mementomorri.View
import io.kvision.core.Container
import io.kvision.html.div
import io.kvision.html.image
import io.kvision.html.li
import io.kvision.html.link
import io.kvision.html.nav
import io.kvision.html.ul

fun Container.headerNav(state: ConduitState) {
    nav(className = "navbar navbar-light") {
        div(className = "container") {
            link("Omelet", "#${View.HOME.url}", className = "navbar-brand")
            if (!state.appLoading) {
                ul(className = "nav navbar-nav pull-xs-right") {
                    li(className = "nav-item") {
                        link("Home", "#${View.HOME.url}", className = "navbar-nav")
                    }
                    if (state.user == null) {
                        li(className = "nav-item") {
                            link("Sign in", "#${View.LOGIN.url}", className = "navbar-nav")
                        }
                        li(className = "nav-item") {
                            link("Sign up", "#${View.REGISTER.url}", className = "navbar-nav")
                        }
                    } else {
                        li(className = "nav-item") {
                            link(
                                "New Post",
                                "#${View.EDITOR.url}",
                                "ion-compose",
                                separator = "&nbsp;",
                            )
                        }
                        li(className = "nav-item") {
                            link(
                                "Settings",
                                "#${View.SETTINGS.url}",
                                "ion-gear-a",
                                separator = "&nbsp;",
                            )
                        }
                        if (state.user.username != null) {
                            li(className = "nav-item") {
                                link(
                                    state.user.username,
                                    "#/@${state.user.username}",
                                    labelFirst = false,
                                ) {
                                    if (!state.user.image.isNullOrBlank()) {
                                        image(state.user.image, state.user.username, className = "user-pic")
                                    }
                                }
                            }
                        }
                    }
                    li (className = "nav-item"){
                        link("About dev", "#${View.ABOUT.url}", className = "navbar-nav")
                    }
                }
            }
        }
    }
}
