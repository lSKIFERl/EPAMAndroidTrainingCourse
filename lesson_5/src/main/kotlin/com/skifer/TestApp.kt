package com.skifer

import com.skifer.transport.Color
import com.skifer.transport.Transport
import com.skifer.transport.TransportUiModel as TransportUi

typealias Bike = Transport.MotorCycle
typealias Car = Transport.Car

fun Transport.toUi() = TransportUi(model, VIN)

fun main() {

    val car = Car(
        model = "Ford Focus-Pocus",
        color = Color.WHITE,
        VIN = "А123АА")
    val bike = Bike(
        model = "Yamaha",
        color = Color.BLUE,
        VIN = "А777АА"
    )

    val garageCar: Garage<Car> = Garage(car)
    val garageBike: Garage<Bike> = Garage(bike)

    garageBike.addTransport(car)
    garageBike.addTransport(bike)

    val transportList = garageBike.getTransport()
    println(transportList)

    val bikeList = transportList.filterIsInstance<Bike>().map { it.toUi() }
    println(bikeList)
}
