package org.alex.demo.builder

//noinspection ScalaUnnecessarySemicolon
object Application extends App {
  //noinspection LanguageFeature
  private val cocaCola = NutritionFactsBuilder(servingSize = 240, servings = 9) withCalories 100 withFat 45 withSodium 35 withCarbohydrate 27 build;

  private val fanta =
    NutritionFactsBuilder(servingSize = 56, servings = 8).
      withCalories(91).
      withFat(125).
      withSodium(75).
      build;

  println(cocaCola)
  println(fanta)
}
