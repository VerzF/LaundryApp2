package com.trisulaforce.laundryapp.model

object DataPesanan {
    private val layanan1 = Layanan(id = 1, image = 0, title = "Kiloan Reguler", price = 8000)
    private val layanan2 = Layanan(id = 2, image = 0, title = "Cuci Selimut", price = 12000)

    private fun calculateTotalPrice(services: List<Layanan>): Int {
        return services.sumOf { it.price }
    }

    val orders = listOf(
        Pesanan(
            idPesanan = 1,
            date = "24 May 2024",
            customerName = "Iqbaal Ramadhan",
            services = listOf(layanan1, layanan2),
            duration = "2 hari",
            totalPrice = calculateTotalPrice(listOf(layanan1, layanan2)),
            perfume = "Serena",
            paymentMethod = "Tunai",
            status = "Selesai",
            notes = ""
        ),
        Pesanan(
            idPesanan = 2,
            date = "28 May 2024",
            customerName = "Laila Novitasari",
            services = listOf(layanan1),
            duration = "2 hari",
            totalPrice = calculateTotalPrice(listOf(layanan1)),
            perfume = "Serena",
            paymentMethod = "Tunai",
            status = "Selesai",
            notes = ""
        ),
        Pesanan(
            idPesanan = 3,
            date = "4 Jun 2024",
            customerName = "Rafly Purnama",
            services = listOf(layanan2),
            duration = "2 hari",
            totalPrice = calculateTotalPrice(listOf(layanan2)),
            perfume = "Serena",
            paymentMethod = "Tunai",
            status = "Selesai",
            notes = ""
        )
    )
}