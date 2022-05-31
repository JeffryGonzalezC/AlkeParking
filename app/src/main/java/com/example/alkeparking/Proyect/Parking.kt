package com.example.alkeparking.Proyect

data class Parking(val vehicles: MutableSet<Vehicle>, var pair: Pair<Int, Int>) {
    //Value that defines the maximum number of parking spaces
    val MAXSPACES = 5

    //Function that receives a vehicle objects and checks if there are spaces available and
    // if the number plate is already registered
    fun addVehicle(vehicle: Vehicle): Boolean {
        return vehicles.size < MAXSPACES && vehicles.add(vehicle)

    }

    //Function that receives a Pair as argument the first element correspond to the total of retired vehicles
    //and the seconds show the total profits
    fun showEarnings(pair: Pair<Int, Int>) {
        println("${pair.first} vehicles have checked out an have earnings of ${pair.second}")
    }

    //This function show the list of vehicles already registered
    //the joinToString function prints all elements separated by the default character " , "
    fun listVehicles(vehicles: MutableSet<Vehicle>) {
        println("List of vehicles remaining is: ")
        println(vehicles.joinToString { vehicle: Vehicle -> vehicle.plate })
    }


    /* fun removeVehicle(vehicle: Vehicle){
        if (vehicles.contains(vehicle))
            vehicles.remove(vehicle)
    }

     */

    fun queryplate(plate: String): Boolean {
        vehicles.find { return it.plate == plate }
        return false
    }
}
