package org.alex.demo

import scala.annotation.tailrec

object Vowel extends App {
  private val ENGLISH_VOWELS: String = "aeiou"
  private val GERMAN_VOWELS: String = "aeiouäöü"

  def isVowel(ch: Char, vowelChars: String) = vowelChars.contains(ch)

  def vowels1(s: String, vowelChars: String): String = for (ch <- s if isVowel(ch, vowelChars)) yield ch


  def vowels2(s: String) = {
    @tailrec
    def vowelsHelper(position: Int, vowels: String): String = {
      if (position == s.length) {
        vowels
      } else {
        val char: Char = s.charAt(position)
        vowelsHelper(
          position + 1,
          if (isVowel(char, ENGLISH_VOWELS)) vowels + char.toString else vowels)
      }
    }
    vowelsHelper(0, "")
  }

  @tailrec
  def vowels(s: String,
             vowelChars: String = ENGLISH_VOWELS,
             ignoreCase: Boolean = true): String = {
    if (ignoreCase) {
      vowels(s.toLowerCase, vowelChars, ignoreCase = false)
    } else {
      vowels1(s, vowelChars)
    }
  }


  println(isVowel('c', ENGLISH_VOWELS))
  println(isVowel('i', ENGLISH_VOWELS))

  println(vowels("Übeltätergehör", GERMAN_VOWELS))
  println(vowels("Übeltätergehör", GERMAN_VOWELS, ignoreCase = false))
  println(vowels("Übeltätergehör"))

}
