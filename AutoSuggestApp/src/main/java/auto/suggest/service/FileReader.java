package auto.suggest.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * FileReader class, which will read a file and returns words from file.
 *
 * @author pappuy
 */
public class FileReader{

	/**
	 * Reading a file and call split method
	 * @param fileName
	 * @return
	 * @throws IOException
	 */
	public static HashSet<String> getWordsFromFile(String fileName) throws IOException{
		List<String> lines = Files.readAllLines(Paths.get(fileName));
		return splitLinesIntoWords(lines);
	}

	/**
	 * Spliting line by line using space,
	 * @param lines
	 * @return
	 */
	private static HashSet<String> splitLinesIntoWords(List<String> lines){
		HashSet<String> words = new HashSet<String>();
		for(String line : lines){
			words.addAll(Stream.of(line.split(" ")).filter(elem-> Objects.nonNull(elem)).filter(elem-> !elem.isEmpty()).collect(Collectors.toSet()));
		}
		return words;
	}
}