package fr.univaix.iut.pokebattle.twitter;

import org.junit.Test;

import java.io.InputStream;

import static org.fest.assertions.Assertions.assertThat;

public class CredentialsTest {
    @Test
    public void testLoadCredentialsGivenAValidPropertiesFileShouldReturnAValidCredentials() throws Exception {
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("./twitter4j.properties");
        Credentials credentials = Credentials.loadCredentials(inputStream);
        assertThat(credentials.getConsumerKey()).isEqualTo("FyQjh06BX2fzqNR6RfIbfg");
        assertThat(credentials.getConsumerSecret()).isEqualTo("ALA9fRkWItQfxync6QP6158ePQkKQ48c8t2LXxeu8o");
        assertThat(credentials.getToken()).isEqualTo("1264492944-xGIEeKVGkKR0onTOou5Z6SuGQGKFGNDal5TnfHn");
        assertThat(credentials.getTokenSecret()).isEqualTo("Bua9gDR8pNTFSgglGcdO0RzRpBLfVsDjBDJpT1iNn4");
    }
}
