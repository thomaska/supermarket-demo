package retail

object Supermarket {
  def discountNforX: (Sku, Int, Int) => List[Sku] => Int = { (S, n, price) => l =>
    var cur = 0
    var totalDis = 0
    val discount = S.value * n - price
    l collect {
      case S =>
        cur += 1
        if (cur % n == 0)
          totalDis += discount
    }
    totalDis
  }

  // For simplification we consider that all prices are Ints
  def calculatePrice(skus: List[Sku], discounts: List[List[Sku] => Int]): Int = {
    val origPrice = skus.map(_.value).sum
    val discount = discounts.map(_ (skus)).sum
    origPrice - discount
  }
}