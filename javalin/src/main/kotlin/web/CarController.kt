package web

import dao.CarDAO
import exception.NotFoundException
import io.javalin.Context
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
            throw NotFoundException("Car Not Found")
        }
    }
}