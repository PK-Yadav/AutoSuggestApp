package auto.suggest.service;

import auto.suggest.serviceintf.IAutoSuggestSearch;
import auto.suggest.util.RegexGenerator;
import auto.suggest.util.SearchTypeEnum;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class AutoSuggestService implements IAutoSuggestSearch{

	private HashSet<String> buffer = new HashSet<String>();
	private String searchKey = null;
	private String fileName = null;
	private SearchTypeEnum searchType =null;

	public AutoSuggestService( String searchKey, String fileName, SearchTypeEnum searchType) {
		this.searchKey = searchKey;
		this.fileName = fileName;
		this.searchType = searchType;
	}

	public void readFileAndPerformAutoSuggest() throws IOException{
		setBuffer(FileReader.getWordsFromFile(getFileName()));
		HashSet<String> suggestedWords= seachKeys(RegexGenerator.getRegexForkeyBySearchType(getSearchKey(), getSearchType()));
		display(suggestedWords);
	}

	public HashSet<String > seachKeys(String keyRegex){
		HashSet<String > matchedWords = new HashSet<>();
		matchedWords.addAll(getBuffer().stream().filter(word -> word.matches(keyRegex)).collect(Collectors.toSet()));
		return matchedWords;
	}

	private void display(HashSet<String> suggestedWords){
		suggestedWords.stream().forEach(elem-> System.out.println(elem));
	}

	public HashSet<String> getBuffer() {
		return buffer;
	}

	public void setBuffer(HashSet<String> buffer) {
		this.buffer = buffer;
	}

	public String getSearchKey() {
		return searchKey;
	}

	public void setSearchKey(String searchKey) {
		this.searchKey = searchKey;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public SearchTypeEnum getSearchType() {
		return searchType;
	}

	public void setSearchType(SearchTypeEnum searchType) {
		this.searchType = searchType;
	}
}