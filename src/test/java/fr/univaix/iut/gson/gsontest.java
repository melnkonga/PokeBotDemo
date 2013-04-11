package fr.univaix.iut.gson;

import static org.junit.Assert.assertEquals;
import gson.DataObjectPokemon;
import gson.bdgsonLoading;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.junit.Test;

import scala.actors.threadpool.Arrays;

import com.google.gson.Gson;



public class gsontest 
{
	String name = "Cocomfort";
	Gson gson = new Gson();
	BufferedReader br = new BufferedReader(new InputStreamReader(
	bdgsonLoading.class.getClassLoader().getResourceAsStream("pokedex.json")));
	DataObjectPokemon[] obj = gson.fromJson(br, DataObjectPokemon[].class);
	Object[] pokemonC = bdgsonLoading.findCaracPokemon(name, obj);
	String str [] = bdgsonLoading.findAttPokemon("Coconfort", obj);
	@Test
	    public void testAsk() throws Exception 
	    {
	        assertEquals("[Armure]", Arrays.toString(str));
	    }
	
	
}
