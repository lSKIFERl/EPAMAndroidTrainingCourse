package com.skifer

import com.skifer.transport.Color
import com.skifer.transport.Transport

typealias Bike = Transport.MotorCycle
typealias Car = Transport.Car

fun main() {

    var car = Car(
        model = "Ford Focus-Pocus",
        color = Color.WHITE,
        VIN = "А123АА")
    var bike = Bike(
        model = "Yamaha",
        color = Color.BLUE,
        VIN = "А777АА"
    )

    val garageCar: Garage<Car> = Garage(car)
    val garageBike: Garage<Bike> = Garage(bike)

    garageBike.addTransport(car)
    garageBike.addTransport(bike)

    println(garageBike.getTransport())
}
