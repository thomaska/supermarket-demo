package retail

sealed trait Sku {
  def value: Int
}

case object A extends Sku {
  override val value = 50
}

case object B extends Sku {
  override val value = 30
}

case object C extends Sku {
  override val value = 20
}

case object D extends Sku {
  override val value = 15
}

