package me.mementomorri

import aboutPage
import me.mementomorri.layout.articles.article
import me.mementomorri.layout.homePage
import me.mementomorri.layout.profilePage
import me.mementomorri.layout.shared.footer
import me.mementomorri.layout.shared.headerNav
import me.mementomorri.layout.users.editorPage
import me.mementomorri.layout.users.loginPage
import me.mementomorri.layout.users.registerPage
import me.mementomorri.layout.users.settingsPage
import io.kvision.Application
import io.kvision.html.header
import io.kvision.html.main
import io.kvision.module
import io.kvision.pace.Pace
import io.kvision.pace.PaceOptions
import io.kvision.panel.ContainerType
import io.kvision.panel.root
import io.kvision.require
import io.kvision.startApplication
import me.mementomorri.ConduitManager.aboutPage

class App : Application() {

    override fun start() {
        Pace.init(require("pace-progressbar/themes/green/pace-theme-bounce.css"))
        Pace.setOptions(PaceOptions(manual = true))
        ConduitManager.initialize()
        root("root", containerType = ContainerType.NONE, addRow = false) {
            header(ConduitManager.conduitStore) { state ->
                headerNav(state)
            }
            main(ConduitManager.conduitStore) { state ->
                if (!state.appLoading) {
                    when (state.view) {
                        View.HOME -> {
                            homePage(state)
                        }
                        View.ARTICLE -> {
                            article(state)
                        }
                        View.PROFILE -> {
                            profilePage(state)
                        }
                        View.LOGIN -> {
                            loginPage(state)
                        }
                        View.REGISTER -> {
                            registerPage(state)
                        }
                        View.EDITOR -> {
                            editorPage(state)
                        }
                        View.SETTINGS -> {
                            settingsPage(state)
                        }
                        View.ABOUT ->{
                            aboutPage()
                        }
                    }
                }
            }
            footer()
        }
    }
}

fun main() {
    startApplication(::App, module.hot)
}
