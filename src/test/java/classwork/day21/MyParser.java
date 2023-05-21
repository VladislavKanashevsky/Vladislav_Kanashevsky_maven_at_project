package classwork.day21;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import java.io.FileReader;
import java.io.IOException;


public class MyParser {

    public void parseGSON() throws IOException {

        String JSON = "src/test/resources/recipe.json";

        Gson gson = new Gson();
        Recipe recipe = gson.fromJson(new JsonReader(new FileReader(JSON)), Recipe.class);
        System.out.println(recipe.getIngredlist());
        System.out.println(recipe.getPreptime());
        System.out.println(recipe.getRecipename());
    }

    public static String fromGSON(Search search) {

        Gson gson = new Gson();

        return gson.toJson(search);

    }
}
