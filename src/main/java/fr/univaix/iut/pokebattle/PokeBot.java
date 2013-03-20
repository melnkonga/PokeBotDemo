package fr.univaix.iut.pokebattle;

import fr.univaix.iut.pokebattle.smartcells.PokemonCriesCell;

import fr.univaix.iut.pokebattle.smartcells.PokemonAnswerPersonCell;
import fr.univaix.iut.pokebattle.smartcells.PokemonAttackCell;
import fr.univaix.iut.pokebattle.smartcells.PokemonCatchCell;
import fr.univaix.iut.pokebattle.smartcells.PokemonNoCatchCell;
import fr.univaix.iut.pokebattle.smartcells.PokemonOwnerCell;
import fr.univaix.iut.pokebattle.smartcells.PokemonOwnerMentionBio;



public class PokeBot implements Bot {
    /**
     * List of SmartCells the questions go through to
     * find an answer.
     */
    final SmartCell[] smartCells = new SmartCell[]{
            new PokemonAnswerPersonCell(), new PokemonCatchCell(),
            new PokemonNoCatchCell(),
            new PokemonOwnerCell(), new PokemonAttackCell(),

    };

    /**
     * Ask something to BoBot, it will respond to you.
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
