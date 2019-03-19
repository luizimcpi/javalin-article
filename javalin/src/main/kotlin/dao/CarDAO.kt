package dao

import model.Car
import java.util.concurrent.atomic.AtomicInteger

class CarDAO {

    val cars = hashMapOf(
        0 to Car(id = 0, name = "Fiat", model = "Uno", carPlate = "AAA-1999"),
        1 to Car(id = 1, name = "Ford", model = "Focus", carPlate = "BBB-1998")
    )

    var lastId: AtomicInteger = AtomicInteger(cars.size - 1)

    fun save(name: String, model: String, carPlate: String) {
        val id = lastId.incrementAndGet()
        cars.put(id, Car(id = id, name = name, model = model, carPlate = carPlate))
    }

    fun update(id: Int, car: Car){
        cars.put(id, Car(id = id, name = car.name, model = car.model, carPlate = car.carPlate))
    }

    fun findById(id: Int): Car? {
        return cars[id]
    }
}