package com.example.alkeparking.Proyect

data class Parking(val vehicles: MutableSet<Vehicle>) {

    val MAXSPACES = 5

    fun addVehicle(vehicle: Vehicle): Boolean {
        //return vehicles.size < MAXSPACES

        if (vehicles.size < MAXSPACES){
            return vehicles.add(vehicle)
        }else{
            return false
        }

    }


    fun removeVehicle(vehicle: Vehicle){
        if (vehicles.contains(vehicle))
            vehicles.remove(vehicle)
    }
}
