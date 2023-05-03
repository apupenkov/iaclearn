package strings.tests;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
@SelectClasses({
        ReplaceCharacterInWordsByIndexTest.class,
        ReplaceCharacterAfterLetterPTest.class,
        GetAlphabetOrdinalNumbersTest.class,
        InsertSubstringByIndexTest.class,
        InsertWordAfterSubstringTest.class,
        ModifyStringArrayTest.class,
        RemoteTextBeetwenTest.class,
        SanitazeTextTest.class,
        СountWordOccurrencesTest.class,
        MostFrequentCharactersTest.class,
        CompareSentenceVowelConsonantFrequencyTest.class,
        CountWordsStartEndWithVowelTest.class,
        WordsWithSameFirstAndLastCharacterTest.class,
        FindMinMaxWordsTest.class,
        TelegramPaymentReceiptTest.class,
        FindCommonLettersTest.class,
        FindLongestNonLetterSubstringTest.class,
        FindConsonantsInTwoWordsTest.class,
        CapitalizeWordsTest.class,
        CountPunctuationMarksTest.class,
        SumOfDigitsTest.class,
})
public class Main {
}
