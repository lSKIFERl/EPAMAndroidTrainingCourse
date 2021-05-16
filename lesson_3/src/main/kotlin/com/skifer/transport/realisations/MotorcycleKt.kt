package com.skifer.transport.realisations

import com.skifer.enums.Color
import com.skifer.enums.MotorcycleType
import com.skifer.transport.TransportKt

class MotorcycleKt(
        override var color: Color,
        override var name: String,
        override var wheels: Int,
        override var capacity: Int,
        var type: MotorcycleType): TransportKt(color, name, wheels, capacity) {

    constructor(name: String): this(Color.BLACK, name, 2, 1, MotorcycleType.SCOOTER)

    override fun printInfo(){
        println("Быстро, шумно, круто \n$this")
    }

    override fun toString(): String {
        return "MotorcycleKt(color='$color', name='$name', wheels=$wheels, capacity=$capacity, type='$type')"
    }

}