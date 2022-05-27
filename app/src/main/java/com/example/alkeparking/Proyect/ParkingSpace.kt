package com.example.alkeparking.Proyect

import java.util.*
const val MINUTES_IN_MILLISECONDS = 60000


data class ParkingSpace(
    var vehicle: Vehicle,
    val checkInTime: Calendar,
    val discountCard: String?,
    val parking: Parking
) {
    val parkedTime: Long
        get() {
            return (4-2)
            //return (Calendar.getInstance().timeInMillis - checkInTime.timeInMillis) / MINUTES_IN_MILLISECONDS
        }

    fun checkOutVehicle(plate: String) {
        for (vehicle in parking.vehicles) {
            if (vehicle.plate == plate) {
                calculateTotal()

                onSuccess(0)
            } else onError()
        }
    }

    private fun calculateTotal(): Int {
        println(parkedTime)

        when(parkedTime){
            in 0..2 -> println("Tiempo parqueado cobrado 2 horas")
        }
        return 0

    }

    fun onSuccess(total: Int) {

    }

    fun onError() {

    }
}
