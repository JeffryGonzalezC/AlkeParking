package com.example.alkeparking.Proyect

import java.util.*
/*  The constructor of the vehicle class receives 4 parameters
    that are essential for the vehicle to be allowed to enter
    the parking lot. */
data class Vehicle(val plate: String,val type: VehicleType,
                   val checkInTime: Calendar,
                   val discountCard: String? = null){


    //Function state that two Vehicles are equal if their plates are equal
    override fun equals(other: Any?): Boolean {
        if (other is Vehicle){
            return this.plate == other.plate
        }

        return super.equals(other)
    }

    //Function state that the hashCode (Used internally in search functions
    //in sets and arrays) is the hashCode of the plate
    override fun hashCode(): Int = this.plate.hashCode()

    enum class VehicleType(val fee: Int) {
        CAR(20), MOTORCYCLE(15), MINIBUS(25), BUS(30)
    }
}