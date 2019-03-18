package web

import io.javalin.Context
import web.response.HealthResponse

object HealthController {

    fun getHealthStatus(ctx: Context) {
        ctx.json(HealthResponse())
    }
}