package web

import dao.CarDAO
import io.javalin.Context
import io.javalin.NotFoundResponse
import model.Car

object CarController {

    val carDAO = CarDAO()

    fun createCar(ctx: Context) {
        val car = ctx.body<Car>()
        println("Conteúdo Recebido com sucesso: $car")
        carDAO.save(car.name, car.model, car.carPlate)
        ctx.status(201)
    }

    fun getAllCars(ctx: Context) {
        ctx.json(carDAO.cars)
    }

    fun getCarById(ctx: Context) {
        try{
            ctx.json(carDAO.cars[ctx.pathParam(":id").toInt()])
        }catch (e: IndexOutOfBoundsException){
            throw NotFoundResponse("Car Not Found")
        }
    }
}