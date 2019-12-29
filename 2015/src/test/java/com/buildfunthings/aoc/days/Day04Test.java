package com.buildfunthings.aoc.days;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;

import com.buildfunthings.aoc.common.Day;
import com.buildfunthings.aoc.common.DayInputExternalResource;

import org.junit.Rule;
import org.junit.Test;

public class Day04Test {

    @Rule
    public DayInputExternalResource input = new DayInputExternalResource(04);

    @Test
    public void testSampleInput1() {
        Map<String, String> tests = new HashMap<>() {{
                put("abcdef", "609043");
                put("pqrstuv", "1048970");
            }
            };

        for (String k : tests.keySet()) {
            Day day = new Day04();
            assertEquals(tests.get(k), day.part1(new ArrayList<String>() {{ add(k); }}));
        }
    }

    @Test
    public void testSampleInput2() {
        // No test input for this day
    }

    @Test
    public void testRealInput() {
        Day day = new Day04();
        assertEquals("346386", day.part1(input.getLines()));
        assertEquals("9958218", day.part2(input.getLines()));
    }

    public String createHexString(byte[] digest) {
        StringBuffer hexString = new StringBuffer();

        for (int i = 0; i < digest.length; i++) {
            if ((0xff & digest[i]) < 0x10) {
                hexString.append("0" + Integer.toHexString((0xFF & digest[i])));
            } else {
                hexString.append(Integer.toHexString(0xFF & digest[i]));
            }
        }

        return hexString.toString();
    }

    public void testBinaryMath() {
        //byte[] a = new byte[] {-60, 45, 2, -31};
        byte[] a = new byte[] {0, 0, 1, -37};
        System.out.println(createHexString(a));
        for (byte b : a) {
            System.out.print(b + " ");
        }
        System.out.print("\n");
        for (byte b : a) {
            System.out.print((b & 0xFF) + " " );
        }
        System.out.print("\n");

    }
}
