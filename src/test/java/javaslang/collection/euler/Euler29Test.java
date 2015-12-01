/*     / \____  _    _  ____   ______  / \ ____  __    _ _____
 *    /  /    \/ \  / \/    \ /  /\__\/  //    \/  \  / /  _  \   Javaslang
 *  _/  /  /\  \  \/  /  /\  \\__\\  \  //  /\  \ /\\/  \__/  /   Copyright 2014-now Daniel Dietrich
 * /___/\_/  \_/\____/\_/  \_/\__\/__/___\_/  \_//  \__/_____/    Licensed under the Apache License, Version 2.0
 */
package javaslang.collection.euler;

import javaslang.collection.Stream;
import org.junit.Test;

import java.math.BigInteger;

import static org.assertj.core.api.Assertions.assertThat;

public class Euler29Test {

    /**
     * <strong>Problem 29: Distinct powers</strong>
     * <p>
     * Consider all integer combinations of ab for 2 ≤ a ≤ 5 and 2 ≤ b ≤ 5:
     * <ul>
     * <li>2<sup>2</sup>=4, 2<sup>3</sup>=8, 2<sup>4</sup>=16, 2<sup>5</sup>=32</li>
     * <li>3<sup>2</sup>=9, 3<sup>3</sup>=27, 3<sup>4</sup>=81, 3<sup>5</sup>=243</li>
     * <li>4<sup>2</sup>=16, 4<sup>3</sup>=64, 4<sup>4</sup>=256, 4<sup>5</sup>=1024</li>
     * <li>5<sup>2</sup>=25, 5<sup>3</sup>=125, 5<sup>4</sup>=625, 5<sup>5</sup>=3125</li>
     * </ul>
     * If they are then placed in numerical order, with any repeats removed, we get the following sequence of 15 distinct terms:
     * <p>
     * 4, 8, 9, 16, 25, 27, 32, 64, 81, 125, 243, 256, 625, 1024, 3125
     * <p>
     * How many distinct terms are in the sequence generated by ab for 2 ≤ a ≤ 100 and 2 ≤ b ≤ 100?
     * <p>
     * See also <a href="https://projecteuler.net/problem=29">projecteuler.net problem 29</a>.
     */
    @Test
    public void shouldSolveProblem29() {
        assertThat(cnt(5)).isEqualTo(15);
        assertThat(cnt(100)).isEqualTo(9183);
    }

    private static int cnt(int max) {
        return Stream.rangeClosed(2, max)
                .map(BigInteger::valueOf)
                .flatMap(a -> Stream.rangeClosed(2, max).map(a::pow))
                .distinct()
                .length();
    }
}
