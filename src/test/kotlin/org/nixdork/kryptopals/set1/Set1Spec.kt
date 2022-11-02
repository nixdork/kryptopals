package org.nixdork.kryptopals.set1

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class Set1Spec : FunSpec({
    context("challenge 1") {
        val challenge1 = Challenge1()
        test("solution") {
            challenge1.solve() shouldBe "I'm killing your brain like a poisonous mushroom"
        }
    }

    context("challenge 2") {
        val challenge2 = Challenge2()
        test("solution") {
            challenge2.solve() shouldBe "the kid don't play"
        }
    }
})
