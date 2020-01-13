package com.buildfunthings.aoc.days;

import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.buildfunthings.aoc.common.Day;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Day12 implements Day {

    @Override
    public String part1(List<String> input) {
        String json = input.get(0);

        Pattern pattern = Pattern.compile("-?[0-9]+");
        Matcher matcher = pattern.matcher(json);

        int sum = 0;
        while (matcher.find()) {
            String match = matcher.group();
            sum += Integer.parseInt(match);
        }
        return String.valueOf(sum);
    }

    boolean isRed(JsonNode node) {
        Iterator<JsonNode> it = node.iterator();
        while (it.hasNext()) {
            if ("red".equals(it.next().asText())) {
                return true;
            }
        }
        return false;
    }

    int doJsonSum(JsonNode node, int sum) {
        int res = 0;

        if (node.isInt()) {
            res += sum + node.asInt();
        }

        if (node.isArray()) {
            for (JsonNode n : node) {
                res += doJsonSum(n, sum);
            }
        }

        if (node.isObject() && !isRed(node)) {
            Iterator<JsonNode> it = node.elements();
			while (it.hasNext()) {
				JsonNode next = it.next();
				res += doJsonSum(next, sum);
			}
        }
        return res;
    }

    @Override
    public String part2(List<String> input) {

        ObjectMapper mapper = new ObjectMapper();
        try {
            JsonNode js = mapper.readTree(input.get(0));
            return String.valueOf(doJsonSum(js, 0));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        return "0";
    }

}
