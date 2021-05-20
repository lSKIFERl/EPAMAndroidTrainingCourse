package com.skifer

import com.skifer.transport.Color
import com.skifer.transport.Transport

typealias Bike = Transport.MotorCycle
typealias Car = Transport.Car

fun main() {
    val garageCar: Garage<Car> = Garage(
        Car(
            model = "Ford Focus-Pocus",
            color = Color.WHITE,
            VIN = "А123АА"
        )
    )
    val garageBike: Garage<Bike> = Garage(
        Bike(
            model = "Yamaha",
            color = Color.BLUE,
            VIN = "А777АА"
        )
    )
}
