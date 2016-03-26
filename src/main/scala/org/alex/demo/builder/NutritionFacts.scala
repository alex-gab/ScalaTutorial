package org.alex.demo.builder

class NutritionFacts(private val servingSize: Int,
                     private val servings: Int,
                     private val calories: Int,
                     private val fat: Int,
                     private val sodium: Int,
                     private val carbohydrate: Int) {

  override def toString = s"NutritionFacts(" +
    s"servingSize=$servingSize," +
    s" servings=$servings," +
    s" calories=$calories," +
    s" fat=$fat," +
    s" sodium=$sodium," +
    s" carbohydrate=$carbohydrate)"
}

case class NutritionFactsBuilder(private val servingSize: Int,
                                 private val servings: Int,
                                 private val calories: Int = 0,
                                 private val fat: Int = 0,
                                 private val sodium: Int = 0,
                                 private val carbohydrate: Int = 0) extends Builder[NutritionFacts] {

  def withCalories(calories: Int) = {
    this.copy(calories = calories)
  }

  def withFat(fat: Int) = {
    this.copy(fat = fat)
  }

  def withSodium(sodium: Int) = {
    this.copy(sodium = sodium)
  }

  def withCarbohydrate(carbohydrate: Int) = {
    this.copy(carbohydrate = carbohydrate)
  }

  override def build =
    new NutritionFacts(
      servingSize,
      servings,
      calories,
      fat,
      sodium,
      carbohydrate)
}
