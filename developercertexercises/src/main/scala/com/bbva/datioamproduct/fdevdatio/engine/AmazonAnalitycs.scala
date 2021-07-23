package com.bbva.datioamproduct.fdevdatio.engine

import com.bbva.datioamproduct.fdevdatio.common.ConfigConstants._
import com.bbva.datioamproduct.fdevdatio.common.Constants.JoinTypes
import com.bbva.datioamproduct.fdevdatio.common.naming.input.Customers
import com.bbva.datioamproduct.fdevdatio.common.naming.input.Phones
import com.bbva.datioamproduct.fdevdatio.common.naming.input.Customers.CreditCardNumber
import com.bbva.datioamproduct.fdevdatio.common.naming.input.Phones.{Brand, CountryCode, CustomerId, CutoffDate, DeliveryId}
import com.bbva.datioamproduct.fdevdatio.common.naming.output.CustomersPhones
import com.datio.fds.amlib.implicits._
import com.datio.spark.logger.LazyLogging
import com.typesafe.config.Config
import org.apache.spark.sql.{Column, DataFrame, SparkSession}
import org.apache.spark.sql.functions.{col, length, lit, not, trim, when}

import scala.collection.mutable

class AmazonAnalitycs(config: Config)(implicit val spark: SparkSession) extends LazyLogging {

  val mapDF: mutable.Map[String, DataFrame] = mutable.Map(
    Customers.keyValue -> config.kirby.readDataFrame(CUSTOMERS_CONFIG),
    Phones.keyValue -> config.kirby.readDataFrame(PHONES_CONFIG)
  )


  def apply(): Unit = {

    mapDF.put(Phones.keyValue, filterPhones(mapDF(Phones.keyValue)))
    mapDF.put(Customers.keyValue, filterCustomers(mapDF(Customers.keyValue)))
    mapDF.put(CustomersPhones.keyValue, joinCustomersPhones(mapDF(Customers.keyValue), mapDF(Phones.keyValue)))

  }

  /** Filtrar la tabla ​t_fdev_phones​:
   * Por fecha diaria, tomando únicamente las fechas que comprenden del 2020-03-01 hasta el 2020-03-04 en el campo cutoff_date,
   * recuperando únicamente los celulares que no sean de las marcas "Dell","Coolpad","Chea","BQ" y "BLU", (utilizar isin y negarlo)
   * también deberán omitirse los países señalados anteriormente que tienen como country_code
   * "CH", "IT", "CZ" y "DK". (isin y negarlo) */

  def filterPhones(df: DataFrame): DataFrame = {
    df
      .filter(
        CutoffDate.filter and Brand.filter and CountryCode.filter
      )
  }

  def filterCustomers(df: DataFrame): DataFrame = {
    val columns: Array[Column] = df.columns.map {
      case CreditCardNumber.name => CreditCardNumber.trim
      case _@name => col(name)
    }

    df
      .filter(CreditCardNumber.filter)
      .select(columns: _*)
    //.withColumn("credit_card_number", trim(col("credit_card_number")))
  }


  /** Tendrán que encontrar la relación entre los clientes y los teléfonos que adquirieron, descartandoa los clientes
   * que no compraron ningún teléfono y a los teléfonos que no fueron adquiridos.
   * Las llaves a usar son​customer_id y​delivery_id en ambas tablas.
   *
   * Tendrán que encontrar a los clientes que no compraron ningún teléfono
   * y los teléfonos que no fueron adquiridos por ningún cliente.
   * Las llaves a usar son​customer_id y​delivery_id en ambas tablas. */

  /**
   * Tipos de Joins
   * INNER -> A nivel de registros se queda unicamente con las relaciones que existen en ambas tablas
   * -> A nivel de columnas regresa las columnas de ambas tablas
   * OUTER -> A nivel de registros conserva los registros que sí hicieron match
   * + los registros de la tabla A que no hicieron match con las columnas de la tabla B en null
   * + los registros de la tabla B que no hicieron match con las columnas de la tabla A en null
   * LEFT -> A nivel de registros se queda con todos los registros de la tabla A
   * -> A nivel de columnas regresa las columnas de ambas tablas, colocando NULL en los campos de la tabla B sin cruce
   * RIGHT -> A nivel de registros se queda con todos los registros de la tabla B
   * -> A nivel de columnas regresa las columnas de ambas tablas, colocando NULL en los campos de la tabla A sin cruce
   * CROSS -> Producto Cartesiano
   * -> Si entra la tabla A con 5 registros y tabla B con 10 registros, devolverá el cruce de 5x10 con 50 registros
   * -> A nivel de columnas regresa las columnas de ambas tablas
   * LEFT_SEMI -> A nivel de registros se queda unicamente con las relaciones que existen en ambas tablas
   * -> A nivel de columnas únicamente regresa las columnas de la tabla A
   * LEFT_ANTI -> A nivel de registros se queda unicamente con las relaciones que NO existen
   * -> A nivel de columnas únicamente regresa las columnas de la tabla A
   **/

  def joinCustomersPhones(customers: DataFrame, phones: DataFrame): DataFrame = {
    customers.join(phones, Seq(CustomerId.name, DeliveryId.name), JoinTypes.inner)
  }

}
