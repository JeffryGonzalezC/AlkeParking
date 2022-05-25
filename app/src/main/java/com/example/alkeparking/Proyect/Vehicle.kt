package com.example.alkeparking.Proyect

data class Vehicle(val plate: String){

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
}
