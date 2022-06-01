package com.example.alkeparking.Proyect

import java.util.*

val parking = Parking(mutableSetOf(), pair = Pair(0, 0))
lateinit var vehiclesArray : Array<Vehicle>

fun main(){


    val car1 = Vehicle("CC1223", Vehicle.VehicleType.CAR, Calendar.getInstance(), "D")
    val car2 = Vehicle("CC1224", Vehicle.VehicleType.CAR, Calendar.getInstance())
    val car3 = Vehicle("CC1225", Vehicle.VehicleType.CAR, Calendar.getInstance())
    val car4 = Vehicle("CC1226", Vehicle.VehicleType.CAR, Calendar.getInstance())
    val moto1 = Vehicle("MM0010", Vehicle.VehicleType.MOTORCYCLE, Calendar.getInstance())
    val moto2 = Vehicle("MM0011", Vehicle.VehicleType.MOTORCYCLE, Calendar.getInstance())
    val bus1 = Vehicle("BB0011", Vehicle.VehicleType.BUS, Calendar.getInstance())
    val bus2 = Vehicle("BB0022", Vehicle.VehicleType.BUS, Calendar.getInstance())
    val miniBus1 = Vehicle("MB1020", Vehicle.VehicleType.MINIBUS, Calendar.getInstance())
    val miniBus2 = Vehicle("MB1021", Vehicle.VehicleType.MINIBUS, Calendar.getInstance())
    val miniBus3 = Vehicle("MB1022", Vehicle.VehicleType.MINIBUS, Calendar.getInstance())
    val miniBus4 = Vehicle("MB1023", Vehicle.VehicleType.MINIBUS, Calendar.getInstance())
    val miniBus5 = Vehicle("MB1024", Vehicle.VehicleType.MINIBUS, Calendar.getInstance())
    val miniBus6 = Vehicle("MB1025", Vehicle.VehicleType.MINIBUS, Calendar.getInstance())
    val moto3 = Vehicle("MM0012", Vehicle.VehicleType.MOTORCYCLE, Calendar.getInstance())
    val moto4 = Vehicle("MM0013", Vehicle.VehicleType.MOTORCYCLE, Calendar.getInstance())
    val moto5 = Vehicle("MM0014", Vehicle.VehicleType.MOTORCYCLE, Calendar.getInstance())
    val moto6 = Vehicle("MM0015", Vehicle.VehicleType.MOTORCYCLE, Calendar.getInstance())
    val bus3 = Vehicle("BB0012", Vehicle.VehicleType.BUS, Calendar.getInstance())
    val bus4 = Vehicle("BB0023", Vehicle.VehicleType.BUS, Calendar.getInstance())


    vehiclesArray =
        arrayOf(car1, car2, car3, car4, moto1, moto2, bus1, bus2, miniBus1, miniBus2,miniBus3,miniBus4,miniBus5,miniBus6,moto3,moto4,moto5,moto6,bus3,bus4)

    //The add vehicles function is called.
    checkIn()

    val parkingSpaceCar1 = ParkingSpace(car1, parking)
    parkingSpaceCar1.checkOutVehicle(car1.plate)

    val parkingSpaceCar2 = ParkingSpace(car2, parking)
    parkingSpaceCar2.checkOutVehicle(car2.plate)

    val parkingSpaceCar3 = ParkingSpace(car3, parking)
    parkingSpaceCar3.checkOutVehicle(car3.plate)

    val parkingSpaceCar4 = ParkingSpace(car4, parking)
    parkingSpaceCar4.checkOutVehicle(car4.plate)

    val parkingSpaceMoto1 = ParkingSpace(moto1, parking)
    parkingSpaceMoto1.checkOutVehicle(moto1.plate)

    val parkingSpaceMoto2 = ParkingSpace(moto2, parking)
    parkingSpaceMoto2.checkOutVehicle(moto2.plate)

    val parkingSpaceBus1 = ParkingSpace(bus1, parking)
    parkingSpaceBus1.checkOutVehicle(bus1.plate)

    val parkingSpaceBus2 = ParkingSpace(bus1, parking)
    parkingSpaceBus2.checkOutVehicle(bus1.plate)


    parking.showEarnings(parking.pair)
    parking.listVehicles(parking.vehicles)



}

    /*  This function allows you to enter the vehicles in the parking lot,
        using the addVehicle function of the paking class. */
    fun checkIn(){

    vehiclesArray.forEach {
        if (parking.addVehicle(it)) {
            println("welcome, to AlkeParking!")
        } else {
            println("Sorry, the check-in failed")
        }
    }
}
