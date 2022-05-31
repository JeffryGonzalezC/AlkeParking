package com.example.alkeparking.Proyect

import java.util.*
import kotlin.math.ceil

const val MINUTES_IN_MILLISECONDS = 60000


data class ParkingSpace(
    var vehicle: Vehicle,
    val checkInTime: Calendar,
    val discountCard: String?,
    val parking: Parking
) {
    val parkedTime: Long
        get() {
            //return (8160000)
            return (Calendar.getInstance().timeInMillis - checkInTime.timeInMillis) / MINUTES_IN_MILLISECONDS
        }

    fun checkOutVehicle(plate: String) {
        if(parking.queryplate(plate)){
            var hasDincountCard = false
                vehicle.discountCard?.let { hasDincountCard = true }

            val amount = calculateFee(vehicle.type, hasDincountCard)
            onSuccess(amount)
        }else onError()
    }

    private fun calculateFee(type: Vehicle.VehicleType, hasDincountCard: Boolean): Int {
        var amount = type.fee
        var time = (parkedTime / 60000)
        if (time > 120){
            val extraTime = time - 120
            val auxAmount = ceil(extraTime.toDouble() / 15)

            val extraAmount = auxAmount * 5

            amount += extraAmount.toInt()
        }

        if (hasDincountCard)
            amount -= (amount * 0.15).toInt()

        return amount
    }

    fun onSuccess(amount: Int) {
        println("valor total $amount")
    }

    fun onError() {

    }
}
