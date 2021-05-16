package com.skifer.transport.realisations

import com.skifer.enums.Color
import com.skifer.transport.TransportKt

class CarKt(
        override var color: Color,
        override var name: String,
        override var wheels: Int,
        override var capacity: Int): TransportKt(color, name, wheels, capacity) {

    override fun printInfo() {
        println("Аааааавтомобиль! \n" + super.toString())
    }

}