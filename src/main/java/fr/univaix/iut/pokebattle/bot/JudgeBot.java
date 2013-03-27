package fr.univaix.iut.pokebattle.bot;

import fr.univaix.iut.pokebattle.smartcell.SmartCell;
import fr.univaix.iut.pokebattle.smartcells.PokemonAnswerPersonCell;
import fr.univaix.iut.pokebattle.smartcells.PokemonFusionAttackCell;
import fr.univaix.iut.pokebattle.smartcells.PokemonNoCatchCell;
import fr.univaix.iut.pokebattle.smartcells.PokemonOwnerCell;
import fr.univaix.iut.pokebattle.smartcells.VivianeAttackCells;
import fr.univaix.iut.pokebattle.twitter.Tweet;

import java.util.List;


public class JudgeBot implements Bot {
    /**
     * List of smartcell the questions go through to
     * find an answer.
     */
	 final SmartCell[] smartCells = new SmartCell[]{
	            new VivianeAttackCells(),
	    };
    
    /**
     * Ask something to Bot, it will respond to you.
     *
     * @param question The question you ask.
     * @return An answer... or null if it doesn't get it.
     */
    @Override
    public String ask(Tweet question) {
        for (SmartCell cell : smartCells) {
            String answer = cell.ask(question);
            if (answer != null)
                return answer;
        }
        return null;
    }

}
