package retail

import org.scalatest.{FlatSpec, Matchers}
import retail.Supermarket.{calculatePrice, discountNforX}

class SupermarketTest extends FlatSpec with Matchers {

  "calcultatePrice" should "calculate correctly prices without offers" in {

    val products = List(A, B, A, B)
    val res = calculatePrice(products, List())
    res shouldBe 160
  }

  "calcultatePrice" should "calculate correctly prices with multiple offers" in {
    val offers = List(discountNforX(A, 3, 130), discountNforX(B, 2, 45))

    val products = List(A, B, A, B, A)
    val res = calculatePrice(products, offers)
    res shouldBe 175
  }

  "calcultatePrice" should "return 0 if there are no products" in {
    val offers = List(discountNforX(A, 5, 100), discountNforX(B, 2, 45))

    val products = List()
    val res = calculatePrice(products, List())
    res shouldBe 0
  }
}
