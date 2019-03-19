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
        ctx.json(carDAO.cars.toList())
    }

    fun getCarById(ctx: Context) {
        try{
            ctx.json(carDAO.findById(ctx.pathParam(":id").toInt())!!)
        }catch (e: Exception){
            throw NotFoundException("Car Not Found")
        }
    }

    fun updateCar(ctx: Context){
        val car = ctx.body<Car>()
        carDAO.update(
            id = ctx.pathParam(":id").toInt(),
            car = car
        )
        ctx.status(204)
    }

    fun deleteCar(ctx: Context){
        carDAO.delete(ctx.pathParam(":id").toInt())
        ctx.status(204)
    }
}