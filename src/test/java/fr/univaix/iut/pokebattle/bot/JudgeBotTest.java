package fr.univaix.iut.pokebattle.bot;

import static org.fest.assertions.Assertions.assertThat;

import org.junit.Test;

import fr.univaix.iut.pokebattle.twitter.Tweet;

public class JudgeBotTest {
    JudgeBot judgeBot = new JudgeBot();

    @Test
    public void testAsk() throws Exception {
        assertThat(judgeBot.ask(new Tweet("Salut"))).isNull();
        assertThat(judgeBot.ask(new Tweet("This is not a question."))).isNull();
    }
}
