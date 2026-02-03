package echoweave;

import java.util.*;

public class InputProcessor {
	public String processInput(String input) {
		input = input.toUpperCase();
		
		Set<Character> unique = new LinkedHashSet<>();
		Map<Character, Integer> frequency = new LinkedHashMap<>();
		
		
		for(char c : input.toCharArray()) {
			unique.add(c);
			frequency.put(c, frequency.getOrDefault(c, 0) + 1);
		}
		
		List<Character> evenFreq = new ArrayList<>();
		List<Character> oddFreq = new ArrayList<>();
		
		for(char c : unique) {
			if(frequency.get(c) % 2 == 0) {
				evenFreq.add(c);
			}
			else {
				oddFreq.add(c);
			}
		}
		
		StringBuilder encrypted = new StringBuilder();
		
		for(char c : evenFreq) {
			encrypted.append(c);
		}
		
		for(char c : oddFreq) {
			encrypted.append(c);
		}
		
		for(char c : unique) {
			int extra = frequency.get(c) - 1;
			for(int i = 0; i < extra; i++) {
				encrypted.append(c);
			}
		}
		
		int count = 0;
		for(char c : unique) {
			if(frequency.get(c) == 1) {
				count++;
			}
		}
		
		if(count > 0) {
			if(encrypted.length() % 2 == 0) {
				int n = encrypted.length()/2;
				encrypted.insert(n, count);
			}
			else {
				int n = (encrypted.length()/2) + 1;
				encrypted.insert(n, count);
			}
		}
		
		return encrypted.toString();
	}
}
