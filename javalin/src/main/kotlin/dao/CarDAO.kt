package dao

import model.Car
import java.util.concurrent.atomic.AtomicInteger

class CarDAO {

    val cars = mutableListOf(
        Car(id = 0, name = "Fiat", model = "Uno", carPlate = "AAA-1999"),
        Car(id = 1, name = "Ford", model = "Focus", carPlate = "BBB-1998")
    )

    var lastId: AtomicInteger = AtomicInteger(cars.size - 1)

    fun save(name: String, model: String, carPlate: String) {
        val id = lastId.incrementAndGet()
        cars.add(Car(id = id, name = name, model = model, carPlate = carPlate))
    }
}