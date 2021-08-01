package me.mementomorri.helpers

import io.kvision.require

@Suppress("UnsafeCastFromDynamic")
val marked: (String, dynamic) -> String = require("marked")
