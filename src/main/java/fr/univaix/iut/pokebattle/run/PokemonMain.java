package fr.univaix.iut.pokebattle.run;

import fr.univaix.iut.pokebattle.bot.JudgeBot;
import fr.univaix.iut.pokebattle.bot.PokeBot;

public class PokemonMain {
    public static void main(String[] args) {
    	BotRunner.runBot(new PokeBot(), "twitter4jsalameche.properties");
        BotRunner.runBot(new PokeBot(), "twitter4j.properties");
        BotRunner.runBot(new JudgeBot(), "twitter4jviviane.properties");
    }
}
