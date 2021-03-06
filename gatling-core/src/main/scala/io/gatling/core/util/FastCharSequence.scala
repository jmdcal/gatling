/**
 * Copyright 2011-2014 eBusiness Information, Groupe Excilys (www.ebusinessinformation.fr)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * 		http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.gatling.core.util

import StringHelper._

object FastCharSequence {

  def apply(s: String): FastCharSequence = {
    val chars = s.unsafeChars
    new FastCharSequence(chars, 0, chars.length)
  }
}

class FastCharSequence(chars: Array[Char], offset: Int, count: Int) extends CharSequence {

  def length: Int = count

  def charAt(index: Int): Char = chars(offset + index)

  def subSequence(start: Int, end: Int): CharSequence = new FastCharSequence(chars, offset + start, end - start)

  override def toString: String = String.valueOf(chars, offset, count)
}
