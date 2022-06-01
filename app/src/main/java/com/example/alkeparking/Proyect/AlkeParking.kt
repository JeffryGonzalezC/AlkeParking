package com.example.alkeparking.Proyect

import android.util.Log
import java.util.*

val parking = Parking(mutableSetOf(), pair = Pair(0, 0))
lateinit var vehiclesArray: Array<Vehicle>

fun main() {


    val car1 = Vehicle("CC1223", Vehicle.VehicleType.CAR, Calendar.getInstance(), "DISCOUNT001")
    val car2 = Vehicle("CC1224", Vehicle.VehicleType.CAR, Calendar.getInstance())
    val car3 = Vehicle("CC1225", Vehicle.VehicleType.CAR, Calendar.getInstance())
    val car4 = Vehicle("CC1226", Vehicle.VehicleType.CAR, Calendar.getInstance(), "DISCOUNT002")
    val moto1 = Vehicle("MM0010", Vehicle.VehicleType.MOTORCYCLE, Calendar.getInstance())
    val moto2 = Vehicle("MM0011", Vehicle.VehicleType.MOTORCYCLE, Calendar.getInstance())
    val bus1 = Vehicle("BB0011", Vehicle.VehicleType.BUS, Calendar.getInstance(), "DISCOUNT003")
    val bus2 = Vehicle("BB0022", Vehicle.VehicleType.BUS, Calendar.getInstance())
    val miniBus1 = Vehicle("MB1020", Vehicle.VehicleType.MINIBUS, Calendar.getInstance())
    val miniBus2 = Vehicle("MB1021", Vehicle.VehicleType.MINIBUS, Calendar.getInstance())


    vehiclesArray = arrayOf(car1, car2, car3, car4, moto1, moto2, bus1, bus2, miniBus1, miniBus2)

    //The vehicle entry function is created
    checkIn()

    val parkingSpace = ParkingSpace(car1, car1.checkInTime, car1.discountCard, parking)
    parkingSpace.checkOutVehicle(car1.plate)

    //Show earnings of vehicles already retired
    parking.showEarnings(parking.pair)

    //Show the list of vehicles remaining in parking
    parking.listVehicles(parking.vehicles)


}

fun checkIn() {

    vehiclesArray.forEach {
        if (parking.addVehicle(it)) {
            println("welcome, to AlkeParking!")
        } else {
            println("Sorry, the check-in failed")
        }
    }


}
