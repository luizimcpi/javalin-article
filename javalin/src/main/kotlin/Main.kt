import exception.NotFoundException
import io.javalin.Javalin
import io.javalin.apibuilder.ApiBuilder.*
import web.CarController
import web.HealthController

fun main(args: Array<String>) {

    val app = Javalin.create().start(7000)

    app.routes {
        path("health") {
            get(HealthController::getHealthStatus)
        }
        path("cars") {
            get(CarController::getAllCars)
            post(CarController::createCar)
            path(":id"){
                get(CarController::getCarById)
            }
        }
    }
}
