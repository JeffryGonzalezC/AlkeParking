package com.example.alkeparking.Proyect

data class Parking(val vehicles: MutableSet<Vehicle>, var pair: Pair<Int, Int>) {
    //Value that defines the maximum number of parking spaces
    val MAXSPACES = 20

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

    /*  This function allows removing from the list the vehicle
        that has already been removed from the parking lot, after
        having made its respective payment. */
     fun removeVehicle(vehicle: Vehicle){
        if (vehicles.contains(vehicle))
            vehicles.remove(vehicle)
    }



    /*  This function allows you to search for a vehicle by its license plate
        since it is its unique identifier, using the find function that returns
        the first element that matches the received parameter, this function receives
        as a parameter the license plate of the vehicle to be searched for and returns
        a boolean that indicates whether the vehicle was found or not. */
    fun queryplate(plate: String): Boolean {
        vehicles.find { return it.plate == plate }
        return false
    }
}
