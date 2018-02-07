package auto.suggest.util;

import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion;

public final class RegexGenerator {

	public static String getRegexForkeyBySearchType(String key, SearchTypeEnum seachTypeEnum) {
		String regexString = null;
		switch (seachTypeEnum) {
		case POSTFIX:
			regexString = ".*("+key+")$";
			break;
		case PREFIX:
			regexString = "^("+key+").*";
			break;
		case FUZZY:
			regexString = ".*("+key+").*";
			break;
		}
		return regexString;
	}
}