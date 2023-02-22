package com.example.visitablepattern.utils

import java.text.DecimalFormat
import java.text.DecimalFormatSymbols

object CurrencyUtil {
    fun toIDR(nominal: Int): String {
        val kursIndonesia = DecimalFormat.getCurrencyInstance() as DecimalFormat
        val formatRp = DecimalFormatSymbols()

        formatRp.currencySymbol = "Rp "
        formatRp.groupingSeparator = '.'

        kursIndonesia.decimalFormatSymbols = formatRp
        kursIndonesia.maximumFractionDigits = 0

        return kursIndonesia.format(nominal)
    }
}