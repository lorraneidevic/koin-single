package com.github.koinsingle.sample.config

import io.javalin.Javalin
import org.koin.core.KoinComponent
import org.koin.core.context.startKoin
import org.koin.core.inject

class ServerConfig : KoinComponent {

    private val router: Router by inject()

    fun setup() : Javalin {

        startKoin {
            modules(
                    manualGeneratedModule
            )
        }

        return Javalin.create().also {
            router.register(it)
        }

    }
}