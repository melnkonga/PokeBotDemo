package fr.univaix.iut.pokebattle;

import fr.univaix.iut.pokebattle.smartcells.PokemonCriesCell;
<<<<<<< HEAD
=======
import fr.univaix.iut.pokebattle.smartcells.PokemonNoCatchCell;
import fr.univaix.iut.pokebattle.smartcells.PokemonOwnerCell;
import fr.univaix.iut.pokebattle.smartcells.PokemonOwnerMentionBio;
>>>>>>> 5f6d2d7c0eb9f5d6997fe0548455daac8c223d12


public class PokeBot implements Bot {
    /**
     * List of SmartCells the questions go through to
     * find an answer.
     */
    final SmartCell[] smartCells = new SmartCell[]{

            new PokemonCriesCell(),

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
