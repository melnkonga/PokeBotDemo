package fr.univaix.iut.pokebattle.smartcells;

import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import fr.univaix.iut.pokebattle.Pokemon;

public class PokemonOwnerMentionBio
{
	public void OwnerMentionBio (Pokemon pokemon) throws TwitterException
	{
		String description = "Owner :" + pokemon.getOwnerPoke();
		Twitter twitter = TwitterFactory.getSingleton();
		twitter.updateProfile(null,null,null,description);
	}
}
