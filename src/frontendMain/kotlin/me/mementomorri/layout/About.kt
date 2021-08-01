import io.kvision.core.Container
import io.kvision.html.div
import io.kvision.html.span

fun Container.aboutPage() {
    div(className = "container page") {
        span("This app was solely designed to show what I can do as a junior developer, here is a link to my <a href=\"https://mementomorri.github.io\">portfolio</a>. ",
            rich=true)
    }
}