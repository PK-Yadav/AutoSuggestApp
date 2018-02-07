package auto.suggest.app;

import auto.suggest.service.AutoSuggestService;
import auto.suggest.serviceintf.IAutoSuggestSearch;
import auto.suggest.util.SearchTypeEnum;

import java.util.Scanner;

/**
 * Hello world!
 */
public class App {
	public static void main(String[] args) {
		try {
			Scanner kb = new Scanner(System.in);
			System.out.println("Hello Welcome to auto suggest search!");
			System.out.print("Please type character for which auto suggest required ..... ");
			String key = kb.next();
			System.out.println("Please provide type of search. Like PRE/POST/FUZ");
			String searchType = kb.next();
			AutoSuggestService autoSuggestSearch = new AutoSuggestService(key, "/Users/pappuy/wikiurldata/input/autosuggest.txt", SearchTypeEnum.getSearchTypeEnumByValue(searchType));
			autoSuggestSearch.readFileAndPerformAutoSuggest();
			kb.close();
		}catch (Exception ex){
			ex.printStackTrace();
		}

	}
}
