package com.meetup.codegen

import io.swagger.v3.oas.models.media._
import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers

class MappedSwaggerDatePropertiesTest extends AnyFunSpec with Matchers {

  val codeGen = TestScalaCodegen.getServer

  val swaggerMappedTypes =
    Map[String, (String, String => Schema[_])](
      ("date", ("java.time.LocalDate", mkSchema(new DateSchema))),
      ("date-time", ("java.time.ZonedDateTime", mkSchema(new DateTimeSchema)))
    )

  describe("a swagger date/time property") {
    it("should map to the expected type") {
      swaggerMappedTypes.foreach {
        case (from, (to, f)) =>
          codeGen.getSchemaType(f(from)) shouldBe to
      }
    }
  }

}
