package com.example.alkeparking.Proyect

import java.util.*
const val MINUTES_IN_MILLISECONDS = 6000


data class ParkingSpace(
    var vehicle: Vehicle,
    val checkInTime: Calendar,
    val discountCard: String?,
    val parking: Parking
) {
    val parkedTime: Long
        get() {
            return (Calendar.getInstance().timeInMillis - checkInTime.timeInMillis) / MINUTES_IN_MILLISECONDS
        }

    fun checkOutVehicle(plate: String) {
        for (vehicle in parking.vehicles) {
            if (vehicle.plate == plate) {
                onSuccess(0)
            } else onError()
        }
    }

    fun onSuccess(total: Int) {

    }

    fun onError() {

    }
}
