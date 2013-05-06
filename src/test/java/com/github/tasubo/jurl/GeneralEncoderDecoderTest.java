package com.github.tasubo.jurl;


import org.junit.Test;

import static org.hamcrest.Matchers.equalToIgnoringCase;
import static org.junit.Assert.assertThat;

public class GeneralEncoderDecoderTest {

    @Test
    public void encoderShouldHandleNulls() {
        String escaped = URLEncode.encode(null);
        assertThat(escaped, equalToIgnoringCase(""));
    }

    @Test
    public void decoderShouldHandleNulls() {
        String decoded = URLDecode.decode(null);
        assertThat(decoded, equalToIgnoringCase(""));
    }
}
