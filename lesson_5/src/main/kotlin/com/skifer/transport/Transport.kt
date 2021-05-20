package com.skifer.transport

/**
 * Simple Transport abstract class
 */
sealed class Transport {

    /**
     * Model name
     */
    abstract val model: String

    /**
     * Transport color
     */
    abstract val color: Color

    /**
     * Vehicle Identification Number
     */
    abstract val VIN: String

    /**
     * Simple Car class
     */
    class Car (
        override val model: String,
        override val color: Color,
        override val VIN: String,
         /** Is this car dirty? */
        var needsCleaning: Boolean = false
        ): Transport()

    /**
     * Simple Bike class
     */
    class MotorCycle(
        override val model: String,
        override val color: Color,
        override val VIN: String,
        /** Does this motorcycle need refueling? */
        var isOutOfFuel: Boolean = false
        ): Transport()

}
