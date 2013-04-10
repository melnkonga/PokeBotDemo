package fr.univaix.iut.pokebattle.twitter;

import java.io.IOException;

import twitter4j.Twitter;

import com.twitter.hbc.httpclient.ControlStreamException;

import fr.univaix.iut.pokebattle.bot.Bot;
import fr.univaix.iut.pokebattle.tuse.Credentials;
import fr.univaix.iut.pokebattle.tuse.TwitterUserStreamEasy;

public class TwitterBot {
	private TwitterUserStreamEasy twitterUserStreamEasy;
	private Twitter twitter;

	public TwitterUserStreamEasy getTwitterUserStreamEasy() {
		return twitterUserStreamEasy;
	}

	public void setTwitterUserStreamEasy(
			TwitterUserStreamEasy twitterUserStreamEasy) {
		this.twitterUserStreamEasy = twitterUserStreamEasy;
	}

	public Twitter getTwitter() {
		return twitter;
	}

	public void setTwitter(Twitter twitter) {
		this.twitter = twitter;
	}

	public TwitterBot(final Bot bot, Credentials credentials) {
		this.twitter = new TwitterBuilder(credentials).build();
		this.twitterUserStreamEasy = new TwitterUserStreamEasyBuilder(twitter,
				bot).build(credentials);
	}

	public void startBot() throws InterruptedException, ControlStreamException,
			IOException {
		twitterUserStreamEasy.oauth();
	}

}
