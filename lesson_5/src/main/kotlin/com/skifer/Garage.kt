package com.skifer

import com.skifer.transport.Transport

/**
 * Simple garage class, contains only 1 transport
 */
class Garage<T : Transport> (private val transport: T) {

    /**
     * List of transport contained in garage
     */
    private var transportList: MutableList<Transport> = mutableListOf()

    /**
     * Adds new transport to garage
     */
    fun addTransport(transport: Transport) {
        transportList.add(transport)
    }

    /**
     * Removes transport by VIN
     * @param VIN Vehicle Identification Number
     */
    fun removeTransport(VIN: String) {
        transportList.forEach{
            if (it.VIN == VIN)
                transportList.remove(it)
        }
    }

    /**
     * Returns unmutable list of transport
     * @return List of transport
     */
    fun getTransport(): List<Transport> {
        return transportList.toList()
    }

}

