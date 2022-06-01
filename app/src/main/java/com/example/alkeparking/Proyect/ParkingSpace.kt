package com.example.alkeparking.Proyect

import java.util.*
import kotlin.math.ceil


const val MINUTES_IN_MILLISECONDS = 60000

/*  This class is in charge of performing the corresponding calculations
    to generate the rate that must be charged for the parking service
    provided, it receives as parameters a vehicle type object and an
    instance of the Parking class. */
data class ParkingSpace(
    var vehicle: Vehicle,
    val parking: Parking
) {
    val parkedTime: Long
        get() {
            return (Calendar.getInstance().timeInMillis - vehicle.checkInTime.timeInMillis) / MINUTES_IN_MILLISECONDS
        }

    /*  This function allows the vehicle to leave the parking lot,
        using the find function that returns the first element that
        matches, or in its case null if no element is found, to later
        collect the fee. */
    fun checkOutVehicle(plate: String) {
        val vehicleToRemove = parking.vehicles.find { it.plate == plate }
        vehicleToRemove?.let {
            var hasDincountCard = false
                vehicle.discountCard?.let { hasDincountCard = true }

            val amount = calculateFee(vehicle.type, hasDincountCard)
            onSuccess(amount)
            parking.removeVehicle(vehicle)
        }?: onError()
    }

    /*  This function allows calculating the fee to be paid by the vehicle that will be removed
        from the parking lot, it receives as parameters an object of type VehicleType and a boolean
        that tells us if they have any type of discount card, and in turn returns the value of the
        rate that will be charged, in this function the ceil function is used that allows us to
        approximate or round values. */
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
        println("${vehicle.type} ${vehicle.plate} Your fee is $amount. Come back soon. ")
        parking.pair = Pair(parking.pair.first + 1, parking.pair.second + amount)
    }

    fun onError() {
        println("Sorry the check-out failed")
    }
}
