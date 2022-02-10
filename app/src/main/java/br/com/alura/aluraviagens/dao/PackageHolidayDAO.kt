package br.com.alura.aluraviagens.dao

import br.com.alura.aluraviagens.model.PackageHoliday
import java.math.BigDecimal

class PackageHolidayDAO {
    fun list() = listOf(
        PackageHoliday("São Paulo", "sao_paulo_sp", 2, BigDecimal(243.99)),
        PackageHoliday("Belo Horizonte", "belo_horizonte_mg", 3, BigDecimal(421.50)),
        PackageHoliday("Recife", "recife_pe", 4, BigDecimal(754.20)),
        PackageHoliday("Rio de Janeiro", "rio_de_janeiro_rj", 6, BigDecimal(532.55)),
        PackageHoliday("Salvador", "salvador_ba", 5, BigDecimal(899.99)),
        PackageHoliday("Foz do Iguaçu", "foz_do_iguacu_pr", 1, BigDecimal(289.90))
        )
}