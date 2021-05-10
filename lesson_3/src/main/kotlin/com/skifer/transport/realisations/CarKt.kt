package com.skifer.transport.realisations

import com.skifer.transport.TransportKt

class CarKt(
        override var color: String,
        override var name: String,
        override var wheels: Int,
        override var capacity: Int): TransportKt(color, name, wheels, capacity) {

    override fun getInfo() {
        println("Аааааавтомобиль! \n" + super.toString())
    }

}