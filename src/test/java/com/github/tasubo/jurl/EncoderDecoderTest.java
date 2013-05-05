package com.github.tasubo.jurl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.Matchers.equalToIgnoringCase;
import static org.junit.Assert.assertThat;

@RunWith(Parameterized.class)
public class EncoderDecoderTest {

    private String original;
    private String encoded;


    public EncoderDecoderTest(String original, String encoded) {
        this.original = original;
        this.encoded = encoded;
    }

    @Test
    public void encodingShouldMatch() {
        System.out.println("Encoding: " + original);
        System.out.println("Expecting: " + encoded);

        String escaped = URLEncode.encode(original);
        assertThat(escaped, equalToIgnoringCase(encoded));
    }

    @Test
    public void decodingShouldMatch() {
        System.out.println("Decoding: " + encoded);
        System.out.println("Expecting: " + original);

        String unencoded = URLDecode.decode(encoded);
        assertThat(unencoded, equalToIgnoringCase(original));
    }

    @Parameterized.Parameters
    public static Collection<Object[]> generateData() {
        return Arrays.asList(new Object[][]{
                {" ", "%20"},
                {"%", "%25"},
                {"%23%24%25%5E%26*", "%2523%2524%2525%255E%2526*"},
                {"http://en.wikipedia.org/wiki/Percent-encoding", "http%3A%2F%2Fen.wikipedia.org%2Fwiki%2FPercent-encoding"},
                {"http://en.wikipedia.org/w/index.php?search=asdasdasd&title=Special%3ASearch", "http%3A%2F%2Fen.wikipedia.org%2Fw%2Findex.php%3Fsearch%3Dasdasdasd%26title%3DSpecial%253ASearch"},
                {"ąčę ėįšųū ųū90-ž", "%C4%85%C4%8D%C4%99%20%C4%97%C4%AF%C5%A1%C5%B3%C5%AB%20%C5%B3%C5%AB90-%C5%BE"},
                {"12@#$%^& #$%^& *()_+ 12243", "12%40%23%24%25%5E%26%20%23%24%25%5E%26%20*()_%2B%2012243"}
        });
    }


}
