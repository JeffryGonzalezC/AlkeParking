package com.example.alkeparking.Proyect

import java.util.*

val parking = Parking(mutableSetOf(), pair = Pair(0, 0))
lateinit var vehiclesArray : Array<Vehicle>

fun main(){


    val car = Vehicle("aa1223", Vehicle.VehicleType.AUTO, Calendar.getInstance(),"D")
    val moto1 = Vehicle("bb0101", Vehicle.VehicleType.MOTO, Calendar.getInstance())
    val moto2 = Vehicle("bb0102", Vehicle.VehicleType.MOTO, Calendar.getInstance())
    val moto3 = Vehicle("bb0103", Vehicle.VehicleType.MOTO, Calendar.getInstance())
    val moto4 = Vehicle("bb0104", Vehicle.VehicleType.MOTO, Calendar.getInstance())
    val bus = Vehicle("bb0104", Vehicle.VehicleType.BUS, Calendar.getInstance())


    vehiclesArray = arrayOf(car, moto1, moto2, moto3, moto4,bus)

    //Se crea funcion de ingreso de vehiculos
    checkIn()

    val parkingSpace = ParkingSpace(car, car.checkInTime, car.discountCard, parking)
    parkingSpace.checkOutVehicle(car.plate)

    //parking.vehicles.remove(car)



}

fun checkIn(){

    vehiclesArray.forEach {
        if (parking.addVehicle(it)) {
            //parking.vehicles.add(it)
            println("welcome, to AlkeParking!")
        } else {
            println("Sorry, the check-in failed")
        }
    }
    //Show earnings of vehicles already retired
    parking.showEarnings(parking.pair)

    //Show the list of vehicles remaining in parking
    parking.listVehicles(parking.vehicles)

}
