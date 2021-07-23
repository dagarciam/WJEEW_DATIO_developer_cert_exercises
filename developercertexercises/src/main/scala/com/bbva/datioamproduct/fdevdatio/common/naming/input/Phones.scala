package com.bbva.datioamproduct.fdevdatio.common.naming.input

import com.bbva.datioamproduct.fdevdatio.common.naming.Field
import org.apache.spark.sql.Column
import com.bbva.datioamproduct.fdevdatio.common.Constants._
import org.apache.spark.sql.functions.{col, not}

object Phones {
  val keyValue: String = "t_fdev_phones"

  case object Brand extends Field {
    override val name = "brand"
    val filter: Column = not(column.isin(BRAND_FILTER: _*))
  }

  case object Model extends Field {
    override val name = "model"
  }

  case object OperativeSystem extends Field {
    override val name = "operative_system"
  }

  case object OsVersion extends Field {
    override val name = "os_version"
  }

  case object InternalMemory extends Field {
    override val name = "internal_memory"
  }

  case object AudioJack extends Field {
    override val name = "audio_jack"
  }

  case object Nfc extends Field {
    override val name = "nfc"
  }

  case object CustomerId extends Field {
    override val name = "customer_id"
  }

  case object CountryCode extends Field {
    override val name = "country_code"
    val filter: Column = not(column.isin(COUNTRY_CODE_FILTER: _*))
  }

  case object BranchId extends Field {
    override val name = "branch_id"
  }

  case object StockNumber extends Field {
    override val name = "stock_number"
  }

  case object SoldProductNumber extends Field {
    override val name = "sold_product_number"
  }

  case object DiscountAmount extends Field {
    override val name = "discount_amount"
  }

  case object Prime extends Field {
    override val name = "prime"
  }

  case object Taxes extends Field {
    override val name = "taxes"
  }

  case object PriceProduct extends Field {
    override val name = "price_product"
  }

  case object DeliveryId extends Field {
    override val name = "delivery_id"
  }

  case object PurchaseDate extends Field {
    override val name = "purchase_date"
  }

  case object CutoffDate extends Field {
    override val name = "cutoff_date"
    val filter: Column = column.between(CUTOFF_DATE_INITIAL_BOUND, CUTOFF_DATE_FINAL_BOUND)
  }

}
