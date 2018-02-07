package auto.suggest.serviceintf;

import java.util.Set;

public interface IAutoSuggestSearch {

	Set<String> seachKeys(String prefixKey);

}