package auto.suggest.service;

import auto.suggest.pojo.AutoSuggestBuffer;
import auto.suggest.util.RegexGenerator;
import auto.suggest.util.SearchTypeEnum;

import java.io.IOException;
import java.util.HashSet;

/**
 * AutoSuggestService class, mainly contains code to perform reading of file and storing it into buffer.
 * will perfom search on buffer
 *
 * @author pappuy
 */
public class AutoSuggestService{
	private String searchKey = null;
	private String fileName = null;
	private SearchTypeEnum searchType =null;

	public AutoSuggestService( String searchKey, String fileName, SearchTypeEnum searchType) {
		this.searchKey = searchKey;
		this.fileName = fileName;
		this.searchType = searchType;
	}

	public void readFileAndPerformAutoSuggest() throws IOException{
		AutoSuggestBuffer buffer = new AutoSuggestBuffer(FileReader.getWordsFromFile(getFileName()));
		HashSet<String> suggestedWords= buffer.seachKeys(RegexGenerator.getRegexForkeyBySearchType(getSearchKey(), getSearchType()));
		display(suggestedWords);
	}

	private void display(HashSet<String> suggestedWords){
		suggestedWords.stream().forEach(elem-> System.out.println(elem));
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