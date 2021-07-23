package com.bbva.datioamproduct.fdevdatio.common.naming.input

import com.bbva.datioamproduct.fdevdatio.common.naming.Field
import org.apache.spark.sql.Column
import org.apache.spark.sql.functions.{length}
import com.bbva.datioamproduct.fdevdatio.common.Constants._

object Customers {
  val keyValue: String = "t_fdev_customers"

  case object CustomerId extends Field {
    override val name: String = "customer_id"
  }

  case object Zipcode extends Field {
    override val name: String = "zipcode"
  }

  case object CityName extends Field {
    override val name: String = "city_name"
  }

  case object StreetName extends Field {
    override val name: String = "street_name"
  }

  case object CreditCardNumber extends Field {
    override val name: String = "credit_card_number"
    lazy val filter: Column = length(trim) < CREDIT_CARD_NUMBER_FILTER
  }

  case object CreditProviderName extends Field {
    override val name: String = "credit_provider_name"
  }

  case object CompanyName extends Field {
    override val name: String = "company_name"
  }

  case object CompanyEmail extends Field {
    override val name: String = "company_email"
  }

  case object LastName extends Field {
    override val name: String = "last_name"
  }

  case object FirstName extends Field {
    override val name: String = "first_name"
  }

  case object DeliveryId extends Field {
    override val name: String = "delivery_id"
  }

  case object BirthDate extends Field {
    override val name: String = "birth_date"
  }

  case object GlDate extends Field {
    override val name: String = "gl_date"
  }

}
